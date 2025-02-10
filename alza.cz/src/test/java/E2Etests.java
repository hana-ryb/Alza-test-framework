import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class E2Etests extends AbstractBaseTest {

    Cart cartPage;
    MainPage mainPage;
    ProductSubpage productSubpage;
    DetailProductPage detailProductPage;
    SignInPage signInPage;
    RegistrationPage registrationPage;

   @BeforeEach
   public void beforeTest() {
       cartPage = new Cart(browser);
       mainPage = new MainPage(browser);
       productSubpage = new ProductSubpage(browser);
       detailProductPage = new DetailProductPage(browser);
       signInPage = new SignInPage(browser);
       registrationPage = new RegistrationPage(browser);
   }

   @Test
   public void homePageTest() {
        Assertions.assertEquals("Alza.cz – rychlý a pohodlný nákup odkudkoliv | Alza.cz", browser.getTitle());

   }

    @Test
    public void tvTest() throws InterruptedException{
        mainPage.goToProductSubpage("/tv-foto-audio-video");

        productSubpage.goToProduct("Televize");

        productSubpage.scrollDown();
        productSubpage.scrollDown();

        detailProductPage.sortByAscending("#cenaasc");
        waitFor(3);

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
                priceOfTwo == priceOfOne * 2 + 1 ||
                priceOfTwo == priceOfOne * 2 - 1
        );//sometimes the price of one consists of pennies and gets rounded up

    }


}
