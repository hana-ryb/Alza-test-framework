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

    protected void goToMainPage(){
        browser.findElement(By.xpath("//a[@data-testid=\"headerLogo\"]"));
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

    protected void clickOnFavourites() {
        browser.findElement(By.xpath("//a[@data-testid='headerCommodityListIcon']")).click();
    }

    protected void clickOnLanguageSwitcher() {
        browser.findElement(By.xpath("//span[@data-testid='headerLanguageSwitcher']")).click();
    }

    protected void clickOnOrdersAndGoods() {
        browser.findElement(By.xpath("//a[@data-testid='headerOrdersIcon']")).click();
    }

    protected void clickIntoSearchField() {
        browser.findElement(By.xpath("//input[@data-testid='searchInput']"));
    }

    protected void clickOnSearchButton() {
        browser.findElement(By.xpath("//button[@data-testid='button-search']")).click();
    }

    protected void clickOnMyAlza() {
        browser.findElement(By.xpath("//span[@data-testid='headerContextMenuToggleTitle']")).click();
    }

}
