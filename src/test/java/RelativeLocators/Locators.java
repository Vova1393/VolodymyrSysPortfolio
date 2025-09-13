package RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;
import saucedemo.base.BaseTest;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Locators extends BaseTest {
    @Test
    public void testBelow() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativeform.html");

        WebElement email = driver.findElement(By.id("email"));
        String expectedEmailText = "jan.kowalski@gmail.com";
        String currentEmailText = email.getAttribute("value");

        assertEquals(currentEmailText, expectedEmailText);

        By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
        WebElement password = driver.findElement(passwordLocator);
        String expectedPasswordText = "Tajne123";
        String currentPasswordText = password.getAttribute("value");
        assertEquals(currentPasswordText, expectedPasswordText);
    }

    @Test
    public void testAbove() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativeform.html");

        WebElement password = driver.findElement(By.id("password"));
        String expectedPasswordText = "Tajne123";
        String currentPasswordText = password.getAttribute("value");

        assertEquals(currentPasswordText, expectedPasswordText);

        By emailLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
        WebElement email = driver.findElement(emailLocator);
        String expectedEmailText = "jan.kowalski@gmail.com";
        String currentEmailText = email.getAttribute("value");
        assertEquals(currentEmailText, expectedEmailText);
    }

    @Test
    public void testCancel() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativeform.html");

        WebElement loginButton = driver.findElement(By.cssSelector("button.login-button"));

        String expectedLoginButtonText = "Login";
        String currentLoginButtonText = loginButton.getText();

        assertEquals(currentLoginButtonText, expectedLoginButtonText);

        By submitLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.cssSelector("button.login-button"));
        WebElement cancelButton = driver.findElement(submitLocator);
        String expectedCancelButtonText = "Cancel";
        String currentCancelButtonText = cancelButton.getText();
        assertEquals(currentCancelButtonText, expectedCancelButtonText);
    }

    @Test
    public void testLogin() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativeform.html");

        WebElement cancelButton = driver.findElement(By.cssSelector("button.cancel-button"));

        String expectedCancelButtonText = "Cancel";
        String currentCancelButtonText = cancelButton.getText();
        assertEquals(currentCancelButtonText, expectedCancelButtonText);

        By cancelLocator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.cssSelector("button.cancel-button"));
        WebElement loginButton = driver.findElement(cancelLocator);
        String expectedLoginButtonText = "Login";
        String currentLoginButtonText = loginButton.getText();
        assertEquals(currentLoginButtonText, expectedLoginButtonText);
    }

    @Test
    public void testMiddle() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativebuttons.html");

        WebElement middleButton = driver.findElement(By.id("middle"));

        By button2Locator = RelativeLocator.with(By.tagName("button")).above(middleButton);

        WebElement button2 = driver.findElement(button2Locator);
        button2.click();
        String expectedButton2Text = "2";
        String currentButton2Text = button2.getText();
        assertEquals(currentButton2Text, expectedButton2Text);

        By button8Locator = RelativeLocator.with(By.tagName("button")).below(middleButton);

        WebElement button8 = driver.findElement(button8Locator);
        button8.click();

        String expectedButton8Text = "8";
        String currentButton8Text = button8.getText();
        assertEquals(currentButton8Text, expectedButton8Text);

        By button4Locator = RelativeLocator.with(By.tagName("button")).toLeftOf(middleButton);

        WebElement button4 = driver.findElement(button4Locator);
        button4.click();

        String expectedButton4Text = "4";
        String currentButton4Text = button4.getText();
        assertEquals(currentButton4Text, expectedButton4Text);

        By button6Locator = RelativeLocator.with(By.tagName("button")).toRightOf(middleButton);

        WebElement button6 = driver.findElement(button6Locator);
        button6.click();

        String expectedButton6Text = "6";
        String currentButton6Text = button6.getText();
        assertEquals(currentButton6Text, expectedButton6Text);

        By button1Locator = RelativeLocator.with(By.tagName("button")).toLeftOf(middleButton).above(button4);
        WebElement button1 = driver.findElement(button1Locator);
        button1.click();

        String expectedButton1Text = "1";
        String currentButton1Text = button1.getText();
        assertEquals(currentButton1Text, expectedButton1Text);

        By button3Locator = RelativeLocator.with(By.tagName("button")).toRightOf(middleButton).above(button6);
        WebElement button3 = driver.findElement(button3Locator);
        button3.click();

        String expectedButton3Text = "3";
        String currentButton3Text = button3.getText();
        assertEquals(currentButton3Text, expectedButton3Text);

        By button7Locator = RelativeLocator.with(By.tagName("button")).below(middleButton).toLeftOf(button8);
        WebElement button7 = driver.findElement(button7Locator);
        button7.click();

        String expectedButton7Text = "7";
        String currentButton7Text = button7.getText();
        assertEquals(currentButton7Text, expectedButton7Text);

        By button9Locator = RelativeLocator.with(By.tagName("button")).below(middleButton).toRightOf(button8);
        WebElement button9 = driver.findElement(button9Locator);
        button9.click();

        String expectedButton9Text = "9";
        String currentButton9Text = button9.getText();
        assertEquals(currentButton9Text, expectedButton9Text);
    }
}
