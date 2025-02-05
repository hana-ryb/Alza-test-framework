import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlzaParentOperations {
    WebDriver browser;
    WebDriverWait wait;

    public AlzaParentOperations(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, Duration.ofMillis(10000));
    }

    protected void goToCartNotEmpty() {
        browser.findElement(By.cssSelector(".header-alz-18 .header-alz-103")).click();
        wait.until(r->browser.findElement(By.cssSelector(".c1 .mainItem")).isDisplayed());
    }

    protected void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollTo(0, 0);");
    }

    protected void scrollIntoView(String xpath) {
        var element = browser.findElement(By.xpath(xpath));
        var js = (JavascriptExecutor) browser;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    protected void scrollIntoViewWithWebElement(String xpath) throws InterruptedException {
        WebElement element = browser.findElement(By.xpath(xpath));
        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    protected void getBack() {
        browser.navigate().back();
    }
}
