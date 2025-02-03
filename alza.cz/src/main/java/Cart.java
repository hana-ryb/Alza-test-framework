import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    WebDriver browser;

    public Cart(WebDriver browser) {
        this.browser = browser;
    }

    protected void openCart() {
        browser.get("https://www.alza.cz/Order1.htm");
    }

    protected void plusOneItem(int index) {
        browser.findElements(By.cssSelector(".c2 .countPlus")).get(index).click();
    }

    int getPriceOfFirstItem() {
        String priceOfFirstItem = browser.findElement(By.cssSelector(".c5")).getText();
        return Integer.parseInt(priceOfFirstItem.replaceAll("\\D", ""));
    }

    String getActualNameOfFirstItemInCart() {
        return browser.findElement(By.cssSelector(".c1 .mainItem")).getText();
    }
}
