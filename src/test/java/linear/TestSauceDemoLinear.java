package linear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestSauceDemoLinear extends BaseTest {

    @Test
    public void testOneProductToCart() {
        driver.get("https://www.saucedemo.com/");

        WebElement userInput = driver.findElement(By.id("user-name"));
        userInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement sauceLabsBackpackButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        sauceLabsBackpackButton.click();

        WebElement shoppingCartLink = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        shoppingCartLink.click();

        List<WebElement> items = driver.findElements(By.cssSelector("div.cart_item"));
        assertEquals(items.size(), 1);

    }

    @Test
    public void testOneProductFromProductDetailsToCart() {
        driver.get("https://www.saucedemo.com/");

        WebElement userInput = driver.findElement(By.id("user-name"));
        userInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement SauceLabsBackpackLink = driver.findElement(By.cssSelector("div.inventory_item_name "));
        SauceLabsBackpackLink.click();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart"));
        addToCartButton.click();

        WebElement shoppingCartLink = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        shoppingCartLink.click();

        List<WebElement> items = driver.findElements(By.cssSelector("div.cart_item"));
        assertEquals(items.size(), 1);
    }
}
