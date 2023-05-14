package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {

    WebDriverWait webDriverWait;
    Actions actions;
    public PageBase(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        webDriverWait = new WebDriverWait(webDriver, 30);
         actions = new Actions(webDriver);
    }


    /* custom click action with waiting to avoid loading issues*/
    public void click(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /* custom sendKey action with waiting to avoid element loading issues */
    public void type(WebElement webElement, String Word) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(Word);
    }

    public void hover(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        actions.moveToElement(webElement);
    }





}
