import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver browser;
    WebDriverWait wait;

    public MainPage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, Duration.ofMillis(10000));

    }

    protected void clickOnTv() {
        browser.findElement(By.xpath("//a[@href='/tv-foto-audio-video']")).click();
    }

    protected void goToProductSubpage(String productSubpageCategory) {
        String xpath = "//a[@href='$']".replace("$", productSubpageCategory);
        browser.findElement(By.xpath(xpath)).click();
        wait.until(r->browser.findElement(By.cssSelector(".catalogLocalTitlePage-alz-8")).isDisplayed());
    }

    protected void acceptCookies() {
        browser.findElement(By.xpath("//a[contains(text(), 'Rozumím')]")).click();
    }

    protected void clickOnSignIn() {
        browser.findElement(By.xpath("//span[@data-testid='headerContextMenuToggleLogin']")).click();
    }
}
