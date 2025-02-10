import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComparisonPageTests extends AbstractBaseTest {
    ComparisonPage comparisonPage;
    MyAlza myAlza;
    MainPage mainPage;

    @BeforeEach
    public void beforeTest() {
        mainPage = new MainPage(browser);
        comparisonPage = new ComparisonPage(browser);
        myAlza = new MyAlza(browser);
    }

    @Test
    public void addAndDeleteProductToComparison() {
        mainPage.clickOnMyAlza();

        myAlza.clickOnComparison();

        comparisonPage.clickOnAddProduct();

        comparisonPage.enterSearchText("aku");
        waitFor(4);

        String expectedNameOfItemToCompare = comparisonPage.getNameOfItem(3);
        System.out.println(expectedNameOfItemToCompare);

        comparisonPage.addItemToCompare(3);

        Assertions.assertEquals(expectedNameOfItemToCompare,comparisonPage.getNameOfItemToCompare());

        comparisonPage.scrollDown();

        comparisonPage.deleteAllProducts();

        String expectedMessageFromEmptyComparison = comparisonPage.getMessageFromEmptyComparison();
        System.out.println(expectedMessageFromEmptyComparison);

        Assertions.assertEquals("Žádné zboží k porovnání", expectedMessageFromEmptyComparison);

    }


}
