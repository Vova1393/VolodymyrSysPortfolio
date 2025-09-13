package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tables.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private final WebDriver driver;
    protected By byInventoryItemName =
            By.className("inventory_item_name");
    protected By byInventoryItemDescription =
            By.className("inventory_item_desc");
    protected By byCartQuantity = By.className("cart_quantity");
    protected By byItemPrice = By.className("inventory_item_price");
    protected By byRemoveButton = By.cssSelector("button[id*=remove]");
    protected By byInventoryItemLink = By.cssSelector("a[id*=item]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getItems() {
        return driver.findElements(By.cssSelector("div.cart_item"));
    }

    public List<CartItem> getCartItems() {
        List<CartItem> result = new ArrayList<>();
        for(var product: getItems()) {
            CartItem item = new CartItem();
            item.setName(product.findElement(byInventoryItemName).getText());
            item.setDescription(product.findElement(byInventoryItemDescription).getText());
            item.setQuantity(Integer.parseInt(product.findElement(byCartQuantity).getText()));
            item.setPrice(Double.parseDouble(product.findElement(byItemPrice).getText().substring(1)));
            item.setRemoveButton(product.findElement(byRemoveButton));
            item.setInventoryItemLink(product.findElement(byInventoryItemLink));
            result.add(item);
        }
        return result;
    }
}

