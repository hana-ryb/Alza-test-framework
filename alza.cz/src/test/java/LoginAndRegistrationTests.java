import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.RandomStringUtils.random;

public class LoginAndRegistrationTests extends AbstractBaseTest {
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

        Assertions.assertEquals("Přihlášení", registrationPage.getNameofSignInConfirmation());

        //String fillInCodeAlert = registrationPage.getNameOfFillInCodeAlert();
        //System.out.println(fillInCodeAlert);
        //Assertions.assertEquals("Zadejte ověřovací kód", registrationPage.getNameOfFillInCodeAlert());
    }

    @Test
    public void invalidFormatOfEmailRegistration() {

        mainPage.clickOnSignIn();

        signInPage.clickOnNewRegistration();

        registrationPage.fillInEmail("wrongFormat");
        waitFor(6);

        System.out.println(registrationPage.getNameOfAlertWrongFormatOfEmail());

        Assertions.assertEquals("Nesprávný formát emailu", registrationPage.getNameOfAlertWrongFormatOfEmail());

    }

    @Test
    public void loginThirdPartiesAccounts() {

        mainPage.clickOnSignIn();

        signInPage.logInByThirdPartyAccount("Google");

        Assertions.assertEquals("Sign in - Google Accounts", browser.getTitle());

        signInPage.getBack();

        signInPage.logInByThirdPartyAccount("Apple");

        Assertions.assertEquals("Sign in to Apple Account", browser.getTitle());

        signInPage.getBack();

        signInPage.logInByThirdPartyAccount("Seznam");

        Assertions.assertEquals("Log in", browser.getTitle());

        signInPage.getBack();

        signInPage.logInByThirdPartyAccount("MojeId");

        Assertions.assertEquals("Přihlášení do MojeID - MojeID", browser.getTitle());
    }

}
