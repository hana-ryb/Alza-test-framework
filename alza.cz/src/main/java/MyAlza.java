import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAlza {
    WebDriver browser;

    public MyAlza(WebDriver browser) {
        this.browser = browser;
    }

    protected void clickOnComparison() {
        browser.findElement(By.xpath("//a[@data-testid='headerNavigationComparison']")).click();
    }






}
