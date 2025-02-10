import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartTests extends AbstractBaseTest {
    public Cart cart;
    public MainPage mainPage;

    @BeforeEach
    public void beforeTest() {
        mainPage = new MainPage(browser);
        cart = new Cart(browser);
    }

    @Test
    public void selectAndAddCharityItemToCart() {
        cart.openCart();

        cart.selectCharityItem(0);

        WebElement selectedCharityItemOptionOne = browser.findElement(By.xpath("//div/select/option[1]"));

        Assertions.assertTrue(selectedCharityItemOptionOne.isSelected());

        Assertions.assertEquals("0", selectedCharityItemOptionOne.getAttribute("index"));

        cart.addSelectedCharityItemToCart();

        String numberOfItemsInCart = browser.findElement(By.xpath("//div[@class=\"countEdit\"]/input")).getAttribute("value");
        System.out.println("Number of items in the cart is: " + numberOfItemsInCart);

        Assertions.assertEquals("1",numberOfItemsInCart);

    }


}
