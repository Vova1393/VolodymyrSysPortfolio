package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage{
    @FindBy(css = "button[id*='add-to-cart']")
    List<WebElement> addToCartButtons;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    public InventoryPage addOneProductToToCart() {
        WebElement sauceLabsBackpackButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        sauceLabsBackpackButton.click();
        return this;
    }

    public InventoryPage addItemByIndex(int index) {
        addToCartButtons.get(index).click();
        return this;
    }

    public InventoryPage addAllItemsToCart() {
        for (WebElement addToCartButton : addToCartButtons) {
            addToCartButton.click();
        }
        return this;
    }

    public CartPage goToCart() {
        WebElement shoppingCartLink = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        shoppingCartLink.click();
        return new CartPage(driver);
    }

    public DescriptorPage descriptionButton() {
        WebElement SauceLabsBackpackLink = driver.findElement(By.cssSelector("div.inventory_item_name "));
        SauceLabsBackpackLink.click();
        return new DescriptorPage(driver);
    }
}
