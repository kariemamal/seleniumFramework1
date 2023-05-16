package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewPage extends PageBase {


    By dropDownInsuranceField = By.cssSelector(".wrev-drp span.dropdown-placeholder");
    By dropDownInsurances = By.cssSelector("ng-dropdown.wrev-drp div.dropdown ul li");
    By textReviewField = By.cssSelector("div.textarea-user textarea");
    By submitButton = By.cssSelector("div.sub-nav-ct div.sbn-action");

    public ReviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectInsurance(int index){
        click(dropDownInsuranceField);
        click(dropDownInsurances , index);
    }

    public void submitReview(String text){
        type(textReviewField, text);
        click(submitButton);
    }

}
