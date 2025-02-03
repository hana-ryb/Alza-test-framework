import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductSubpage {
    WebDriver browser;
    WebDriverWait wait;
    WebElement element;

    public ProductSubpage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, Duration.ofMillis(10000));
    };


    protected void goToTelevize() {
        browser.findElement(By.xpath("//span[contains(text(), 'Televize')]")).click();
    }

    protected void goToProduct(String productCategory) {
        String xpath = "//span[contains(text(), '$')]".replace("$", productCategory);
        browser.findElement(By.xpath(xpath)).click();
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
}
