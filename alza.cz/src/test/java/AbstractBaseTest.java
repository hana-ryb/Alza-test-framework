import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractBaseTest {
    WebDriver browser = WebDriverManager.firefoxdriver().create();
    WebDriverWait wait = new WebDriverWait(browser, Duration.ofMillis(10000));

    @BeforeEach
    void commonBeforeTest() {
        browser.get("https://www.alza.cz/");
        WebElement cookiesAcceptButton = browser.findElement(By.xpath("//a[contains(text(), 'Rozumím')]"));
        cookiesAcceptButton.click();
        browser.manage().window().maximize();
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
