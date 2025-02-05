import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AlzaParentOperations {

    public SignInPage(WebDriver browser) {
        super(browser);
    }

    protected void clickOnNewRegistration() {
        browser.findElement(By.id("registerLink")).click();
    }

    protected void logInByThirdPartyAccount(String thirdPartyAccount) {
        String xpath = "//a[@data-tid='login-by-$']".replace("$", thirdPartyAccount);
        browser.findElement(By.xpath(xpath)).click();

    }


}
