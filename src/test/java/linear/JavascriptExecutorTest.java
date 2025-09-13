package linear;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;

import java.time.Duration;
import java.util.Calendar;

import static org.testng.Assert.*;

public class JavascriptExecutorTest extends BaseTest {
    @Test
    public void testEnableButton() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/disabledbutton.html");

        WebElement button = driver.findElement(By.id("myButton"));
        assertFalse(button.isEnabled());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')", button);

        assertTrue(button.isEnabled());

        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        assertEquals(alertText, "Kliknięto przycisk!");

        alert.accept();
    }

    @Test
    public void testCalculateTotal() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/nobutton.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("calculateTotal();");

        WebElement result = driver.findElement(By.id("totalAmount"));
        String resultText = result.getText();

        System.out.println("Result: " + resultText);
        assertEquals(resultText, "10.00");
    }

    @Test
    public void testBasicAccessAuth() {
        driver.get("https://admin:admin@adminthe-internet.herokuapp.com/basic_auth");
    }
}
