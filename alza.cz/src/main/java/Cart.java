import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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

    protected void selectCharityItem(int index) {
        Select charitySelect = new Select(browser.findElement(By.xpath("//div/select")));
        charitySelect.selectByIndex(index);
    }

    protected void addSelectedCharityItemToCart() {
        browser.findElement(By.xpath("//a[@class=\"orderButton\"]")).click();
    }
}
