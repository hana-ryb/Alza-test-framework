import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.apache.commons.lang3.RandomStringUtils.random;

public class AlzaTests extends BaseAbstractTest {

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

        //productSubpage.scrollIntoViewWithWebElement("//a[@href='#cenaasc']"); //ElementClickInterceptedException: Element <a id="ui-id-3" class="ui-tabs-anchor" href="#cenaasc"> is not clickable at point (682,19) because another element <input class="header-alz-127 default-placeholder" name="exps" type="text"> obscures it
        //productSubpage.scrollIntoView("//a[@href='#cenaasc']"); //ElementClickInterceptedException: Element <a id="ui-id-3" class="ui-tabs-anchor" href="#cenaasc"> is not clickable at point (682,19) because another element <input class="header-alz-127 default-placeholder" name="exps" type="text"> obscures it
        // //div[contains(@class,'firstRow')]//a[@class='btnk1']
        // "//a[@href='#cenaasc']"
        // "//span[contains(text(), 'Všechny televize')]" (an element slightly above the button) => NoSuchElementException
        // //span[contains(text(), 'Zobrazit další')] (an element at the bottom of the page) => NoSuchElementException


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
                priceOfTwo == priceOfOne * 2 + 1
        );//sometimes the price of one consists of pennies and gets rounded up

        //Assertions.assertEquals(priceOfOne * 2,priceOfTwo );
        //Assertions.assertEquals(priceOfOne * 2 | priceOfOne * 2 + 1,priceOfTwo );
    }


  @Test
    public void registrationOfNewUser() {

    mainPage.clickOnSignIn();

    signInPage.clickOnNewRegistration();

    String randomEmail = random(6, true, true) + "@gmail.com";
    registrationPage.fillInEmail(randomEmail);

    String randomPassword = random(10, true, true);
    registrationPage.fillInPassword(randomPassword);
    registrationPage.fillInPasswordAgain(randomPassword);

    String randomTelephoneNumber = "777" + random(6, false, true);
    registrationPage.fillInTelephoneNumber(randomTelephoneNumber);

    registrationPage.clickOnSaveButton();
    waitFor(2);

    Assertions.assertEquals("Přihlášení", registrationPage.getNameofSignInConfirmation());

    //String fillInCodeAlert = registrationPage.getNameOfFillInCodeAlert();
    //System.out.println(fillInCodeAlert);
    //Assertions.assertEquals("Zadejte ověřovací kód", registrationPage.getNameOfFillInCodeAlert());
    }
}
