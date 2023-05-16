package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletHubProfilePage extends PageBase {


//    @FindBy(css = "div.review-action review-star.rvs-svg svg")
//    public List<WebElement> reviewStarts;

   public By reviewStarts = By.cssSelector("div.review-action review-star.rvs-svg svg");

    public WalletHubProfilePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void hoverRate(int numOfStars) {
        hover(reviewStarts ,numOfStars);
    }

    public void rateWithStars(int numOfStars) {
        click(reviewStarts , numOfStars);
    }



}