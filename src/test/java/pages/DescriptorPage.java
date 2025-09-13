package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DescriptorPage {
    private final WebDriver driver;

    public DescriptorPage(WebDriver driver) {
        this.driver = driver;
    }

    public DescriptorPage addProductToCart() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart"));
        addToCartButton.click();
        return this;
    }

    public CartPage goToCart() {
        WebElement shoppingCartLink = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        shoppingCartLink.click();
        return new CartPage(driver);
    }
}
