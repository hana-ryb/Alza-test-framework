import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailProductPage extends AlzaParentOperations {


    public DetailProductPage(WebDriver browser) {
        super(browser);
    }

    protected void sortByAscending(String sortingCategory) {
        String xpath = "//a[@href='$']".replace("$", sortingCategory);
        browser.findElement(By.xpath(xpath)).click();

        /*
        WebElement sortByPriceAscendingButton = null;
        for (int j = 0; j < 5; j++)
            try {
                sortByPriceAscendingButton = browser.findElement(By.cssSelector("//a[@href='#cenaasc']"));
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element error, trying : : " + e.getMessage());
            }
        }
         if (sortByPriceAscendingButton != null) {
            sortByPriceAscendingButton.click();
        } else {
            throw new RuntimeException("Could not locate element after 5 attempts");
        }
        */
        //browser.findElement(By.xpath("//a[@href='#cenaasc']")).click();
        //wait.until(r-> browser.findElement(By.cssSelector(".firstRow .btnk1")).isDisplayed());
    }

    protected void addFirstProductToCart() {
        browser.findElement(By.xpath("//span/child::div/div/a")).click();
    }

    String getExpectedNameOfCheapest() {
        return browser.findElement(By.cssSelector(".firstRow .name")).getText();
    }




}
