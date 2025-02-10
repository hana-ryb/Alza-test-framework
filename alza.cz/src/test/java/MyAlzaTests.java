import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyAlzaTests extends AbstractBaseTest {
   MainPage mainPage;
   MyAlza myAlza;
   ComparisonPage comparisonPage;

   @BeforeEach
    public void beforeTest() {
        mainPage = new MainPage(browser);
        myAlza = new MyAlza(browser);
        comparisonPage = new ComparisonPage(browser);
    }

    @Test
    public void goToComparisonPage() {
        mainPage.clickOnMyAlza();

        myAlza.clickOnComparison();

        Assertions.assertEquals("https://www.alza.cz/compare-products",comparisonPage.getComparisonPageURL());
    }

}
