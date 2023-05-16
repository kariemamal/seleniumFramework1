package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestBase {
    public static WebDriver webDriver;
    WebDriverWait webDriverWait;


    @BeforeSuite
    @Parameters({"browser", "url"})  //these data are invoked from testng.xml file
    public void startDriver(String browser, String url) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications"); // disable popup of notification permission which block elements
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(chromeOptions);
        }
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }
//
//    @AfterSuite
//    public void endDriver(){
//        webDriver.quit();
//    }


    public void assertIsEqual(WebElement actualElement, String expected) {
        webDriverWait = new WebDriverWait(webDriver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(actualElement));
        Assert.assertEquals(actualElement.getText(), expected);
    }

    public boolean assertElementIsDisplay(WebElement element) {
        webDriverWait = new WebDriverWait(webDriver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
        return true;
    }


}
