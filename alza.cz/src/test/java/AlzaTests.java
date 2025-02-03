import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlzaTests {
    WebDriver browser = WebDriverManager.firefoxdriver().create();
    WebDriverWait wait;

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    public void beforeTest() {
        browser.get("https://www.alza.cz/");
        waitFor(2);
        WebElement cookiesAcceptButton = browser.findElement(By.xpath("//a[contains(text(), 'Rozumím')]"));
        cookiesAcceptButton.click();
        browser.manage().window().maximize();
    }

   @Test
   public void homePageTest() {
        Assertions.assertEquals("Alza.cz – rychlý a pohodlný nákup odkudkoliv | Alza.cz", browser.getTitle());

   }

    @Test
    public void tvTest() throws InterruptedException{
        Cart cartPage = new Cart(browser);
        MainPage mainPage = new MainPage(browser);
        ProductSubpage productSubpage = new ProductSubpage(browser);
        DetailProductPage detailProductPage = new DetailProductPage(browser);

        mainPage.goToProductSubpage("/tv-foto-audio-video");

        productSubpage.goToProduct("Televize");

        //productSubpage.scrollIntoViewWithWebElement("//a[@href='#cenaasc']"); //ElementClickInterceptedException: Element <a id="ui-id-3" class="ui-tabs-anchor" href="#cenaasc"> is not clickable at point (682,19) because another element <input class="header-alz-127 default-placeholder" name="exps" type="text"> obscures it
        //productSubpage.scrollIntoView("//a[@href='#cenaasc']"); //ElementClickInterceptedException: Element <a id="ui-id-3" class="ui-tabs-anchor" href="#cenaasc"> is not clickable at point (682,19) because another element <input class="header-alz-127 default-placeholder" name="exps" type="text"> obscures it
        // //div[contains(@class,'firstRow')]//a[@class='btnk1']
        // "//a[@href='#cenaasc']"
        // "//span[contains(text(), 'Všechny televize')]" (an element slightly above the button) => NoSuchElementException
        // //span[contains(text(), 'Zobrazit další')] (an element at the bottom of the page) => NoSuchElementException


        productSubpage.scrollDown();
        productSubpage.scrollDown();

        detailProductPage.sortByAscending("#cenaasc");
        //waitFor(3);

        detailProductPage.addFirstProductToCart();

        String expectedNameOfTv = "Televize " + detailProductPage.getExpectedNameOfCheapest();
        System.out.println(expectedNameOfTv);

        detailProductPage.goToCartNotEmpty();

        String actualNameOfTv = cartPage.getActualNameOfFirstItemInCart();

        Assertions.assertEquals(expectedNameOfTv, actualNameOfTv);

        int priceOfOne = cartPage.getPriceOfFirstItem();
        System.out.println(priceOfOne);

        cartPage.plusOneItem(0);

        int priceOfTwo = Integer.parseInt(browser.findElement(By.cssSelector(".c5")).getText().replaceAll("\\D", ""));
        System.out.println(priceOfTwo);


        Assertions.assertTrue(
                priceOfTwo == priceOfOne * 2 ||
                priceOfTwo == priceOfOne * 2 + 1
        );//sometimes the price of one consists of pennies and gets rounded up

        //Assertions.assertEquals(priceOfOne * 2,priceOfTwo );
        //Assertions.assertEquals(priceOfOne * 2 | priceOfOne * 2 + 1,priceOfTwo );
    }

}
