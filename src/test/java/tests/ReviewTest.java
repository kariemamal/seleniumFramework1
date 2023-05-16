package tests;

import org.example.pages.ReviewPage;
import org.example.pages.WalletHubProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReviewTest extends TestBase {

    WalletHubProfilePage walletHubProfilePage;
    ReviewPage reviewPage;

    @Test
    public void rateWithFourStars() throws InterruptedException {
        walletHubProfilePage = new WalletHubProfilePage(webDriver);
        walletHubProfilePage.hoverRate(4);
        Assert.assertTrue(webDriver.findElements(walletHubProfilePage.reviewStarts).get(3).getAttribute("aria-checked").equalsIgnoreCase("true"));
    }


    String reviewText="WalletHub checks all the most important boxes when it comes to security. It uses the same 128-bit encryption and SSL FDIC-insured financial institutions use. It supports multi-factor authentication. Personal data collected at signup is anonymized once stored. Plus, the registration process requires only the last four digits of your social security number, not the whole thing.";

    @Test
    public void submitReview(){
        walletHubProfilePage.rateWithStars(4);
        reviewPage= new ReviewPage(webDriver);
        reviewPage.selectInsurance(2);
        reviewPage.submitReview(reviewText);
    }

}