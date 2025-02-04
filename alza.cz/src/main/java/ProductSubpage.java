import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductSubpage extends AlzaParentOperations {

    public ProductSubpage(WebDriver browser) {
        super(browser);
    }

    protected void goToTelevize() {
        browser.findElement(By.xpath("//span[contains(text(), 'Televize')]")).click();
    }

    protected void goToProduct(String productCategory) {
        String xpath = "//span[contains(text(), '$')]".replace("$", productCategory);
        browser.findElement(By.xpath(xpath)).click();
    }


}
