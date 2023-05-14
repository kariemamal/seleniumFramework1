package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WalletHubProfilePage extends PageBase{
    public WalletHubProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "div.review-action review-star.rvs-svg svg")
    public List<WebElement> reviewStarts;


        public void rate(int numOfStars){
            hover(reviewStarts.get(numOfStars-1));
            click(reviewStarts.get(numOfStars-1));
        }

}
