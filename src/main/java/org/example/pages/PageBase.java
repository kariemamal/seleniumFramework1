package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class PageBase {
    WebDriverWait webDriverWait;
    Actions actions;
    JavascriptExecutor js;
    Select select;
    List<WebElement> webElements;
    WebElement webElement;
    WebDriver webDriver;

    public PageBase(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, 30);
        actions = new Actions(webDriver);
        js = (JavascriptExecutor) webDriver;
        this.webDriver=webDriver;
    }


    /* custom click action with waiting to avoid loading issues*/
    public void click(By by, int index) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)) );
        webElements = webDriver.findElements(by);
        webElement = webElements.get(index - 1);
        webElement.click();
    }

    public void click(By by) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)) );
        webElement = webDriver.findElement(by);
        webElement.click();
    }

    /* custom sendKey action with waiting to avoid element loading issues */
    public void type(By by, String Word) {
        webElement = webDriver.findElement(by);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(Word);
    }

    public void hover(By by, int numOfStars) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)) );
        webElements = webDriver.findElements(by);
        webElement = webElements.get(numOfStars - 1);
        actions.moveToElement(webElement).build().perform();
    }


    public void scrollInto(By by) {
        webElement = webDriver.findElement(by);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }


}