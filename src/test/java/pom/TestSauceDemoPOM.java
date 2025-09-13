package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.DescriptorPage;
import pages.InventoryPage;
import pages.LoginPage;
import saucedemo.base.BaseTest;
import tables.CartItem;

import javax.management.Descriptor;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestSauceDemoPOM extends BaseTest {
    @Test
    public void testOneProductToCart() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce")
                .addOneProductToToCart()
                .addItemByIndex(1)
                .addItemByIndex(2)
                .goToCart();

        CartPage cartPage = new CartPage(driver);
        List<WebElement> items = cartPage.getItems();

        assertEquals(items.size(), 3);

        List<CartItem> cartItems = cartPage.getCartItems();
        cartItems.get(1).clickRemoveButton();
        cartItems = cartPage.getCartItems();
        double sum = cartItems.stream().mapToDouble(CartItem::getPrice).sum();
        cartItems.stream().forEach( item ->
                LOG.info("{} cena produktu {}", item.getName(), item.getPrice()));
        LOG.info("suma cen produktów w koszyku:{}", sum);
        cartItems.get(0).clickInventoryItemLink();
    }

    @Test
    public void testOneProductFromProductDetailsToCart() {
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce")
                .descriptionButton()
                .addProductToCart()
                .goToCart();

        CartPage cartPage = new CartPage(driver);
        List<WebElement> items = cartPage.getItems();

        assertEquals(items.size(), 1);

    }
    @Test
    public void testAllProductsToCartAndSum() {
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce")
                .addAllItemsToCart()
                .goToCart();

        CartPage cartPage = new CartPage(driver);
        List<WebElement> items = cartPage.getItems();

        assertEquals(items.size(), 6);

        List<CartItem> cartItems = cartPage.getCartItems();
        double sum = cartItems.stream().mapToDouble(CartItem::getPrice).sum();
        cartItems.stream().forEach(item -> LOG.info("{} cena produktu {}", item.getName(), item.getPrice()));
        LOG.info("Total price of items in the cart:{}", sum);
        assertEquals(sum, 129.94);
    }
}
