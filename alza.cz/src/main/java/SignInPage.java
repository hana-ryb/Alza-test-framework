import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver browser;

    public SignInPage(WebDriver browser) {
        this.browser = browser;
    }

    protected void clickOnNewRegistration() {
        browser.findElement(By.id("registerLink")).click();
    }


}
