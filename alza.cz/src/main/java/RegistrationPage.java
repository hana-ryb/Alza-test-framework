import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    WebDriver browser;
    WebDriverWait wait;

    public RegistrationPage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, Duration.ofMillis(10000));
    }

    protected void fillInEmail(String email) {
        browser.findElement(By.id("edth1EmailLogin")).click();
        browser.findElement(By.id("edth1EmailLogin")).clear();
        browser.findElement(By.id("edth1EmailLogin")).sendKeys(Keys.CONTROL + "a");
        browser.findElement(By.id("edth1EmailLogin")).sendKeys(Keys.DELETE);
        browser.findElement(By.id("edth1EmailLogin")).sendKeys(email);
    }

    protected void fillInPassword(String randomPassword) {

        browser.findElement(By.id("edth1Password")).sendKeys(randomPassword);
    }

    protected void fillInPasswordAgain(String randomPassword) {
        browser.findElement(By.id("edth1PasswordConfirm")).sendKeys(randomPassword);
    }

    protected void fillInTelephoneNumber(String telephoneNumber) {
        browser.findElement(By.id("ctl00_ctl00_cpcm_cpc_ud2_phoneCountryBasicPhoneValidator_inpTelNumber")).sendKeys(telephoneNumber);
    }

    protected void clickOnSaveButton() {
        browser.findElement(By.xpath("//span[contains(text(), 'Uložit')]")).click();
        wait.until(r->browser.findElement(By.xpath("//h1[contains(text(), \"Přihlášení\")]")).isDisplayed());
    }

    protected String getNameOfFillInCodeAlert() {
        return browser.findElement(By.xpath("//div[@class='dialogTitle']")).getText();
    }

    protected String getNameofSignInConfirmation() {
        return browser.findElement(By.xpath("//h1[contains(text(), \"Přihlášení\")]")).getText();
    }

    protected String getNameOfAlertWrongFormatOfEmail() {
        return browser.findElement(By.xpath("//div[@class='alzaAlertContent']")).getText();
    }

}
