import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComparisonPage extends AlzaParentOperations {

    public ComparisonPage(WebDriver browser) {
        super(browser);
    }

    public void goToComparisonPage() {
        browser.get("https://www.alza.cz/compare-products");
    }

    String getComparisonPageURL() {
        return browser.getCurrentUrl();
    }

    public void clickOnAddProduct() {
        browser.findElement(By.cssSelector(".blAddItem .hlAddItem")).click();
    }

    public void deleteAllProducts() {
        browser.findElement(By.xpath("//a[contains(@class, 'hlRemoveComparsions')]")).click();
    }

    public String enterSearchText(String searchText) {
        browser.findElement(By.xpath("//input[contains(@id, 'edtAddItemSearch')]")).clear();
        browser.findElement(By.xpath("//input[contains(@id, 'edtAddItemSearch')]")).sendKeys(searchText);
        return searchText;
    }

    public void addItemToCompare(int index) {
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'ui-menu-item')]")));
        browser.findElements(By.xpath("//li[contains(@class, 'ui-menu-item')]")).get(index).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(@class,'accept')]//a[@class='name']")));
    }

    String getNameOfItem(int index) {
        return browser.findElements(By.xpath("//li[contains(@class, 'ui-menu-item')]//span[contains(@class, 'text')]")).get(index).getText();
    }

    String getNameOfItemToCompare() {
        return browser.findElement(By.xpath("//th[contains(@class,'accept')]//a[@class='name']")).getText();
    }

    protected void deleteItemToCompare() {
        browser.findElements(By.xpath("//a[contains(@title, 'Odebrat z porovnání')]")).get(0).click();
    }

    String getMessageFromEmptyComparison() {
        return browser.findElement(By.xpath("//td/h2")).getText();
    }

    }
