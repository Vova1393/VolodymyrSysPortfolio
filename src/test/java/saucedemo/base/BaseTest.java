package saucedemo.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import screenshot.base.ScreenshotUtil;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver; // protected oznacza, że wszystkie clasy które będą dziedziczyć z tej klasy będą mieli dostęp do tego obiektu

    protected static final Logger LOG = LogManager.getLogger(BaseTest.class);

    long startTime;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestResult myTest) {
        driver = new FirefoxDriver();
        driver.manage().window().maximize(); // zrobimy okno zawsze maksymalnego rozmiaru
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        LOG.info("Test " + myTest.getMethod().getMethodName() + " started");
        startTime = System.currentTimeMillis();
    }

    @AfterMethod
    public void methodTearDown(ITestResult result) throws IOException {
        long endTime = System.currentTimeMillis();
        LOG.info("Upłenęło czasu {}ms ", endTime - startTime);

        // wprzypadku nieudanenego testu screenshor zostanie zrobiony automatycznie
        if(result.getStatus() != ITestResult.SUCCESS){
            String screenshotName = "screenshots/" + result.getName() + result.getEndMillis() + ".png";
            ScreenshotUtil.takeScreenshot(driver, screenshotName);
        }
    }
}
