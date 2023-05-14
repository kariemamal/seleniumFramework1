package tests;

import org.example.pages.WalletHubProfilePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReviewTest extends TestBase {

    WalletHubProfilePage walletHubProfilePage;

    @Test
    public void rateWithFourStars() {
        walletHubProfilePage = new WalletHubProfilePage(webDriver);
        webDriver.navigate().refresh();
        Actions actions = new Actions(webDriver);
        actions.perform();
        walletHubProfilePage.rate(4);

        System.out.println(walletHubProfilePage.reviewStarts.get(0).getAttribute("aria-checked"));
        System.out.println(walletHubProfilePage.reviewStarts.get(1).getAttribute("aria-checked"));
        System.out.println(walletHubProfilePage.reviewStarts.get(2).getAttribute("aria-checked"));
        System.out.println(walletHubProfilePage.reviewStarts.get(3).getAttribute("aria-checked"));
        System.out.println(walletHubProfilePage.reviewStarts.get(4).getAttribute("aria-checked"));
//        Assert.assertTrue(walletHubProfilePage.reviewStarts.get(4).getAttribute("aria-checked"));
        walletHubProfilePage.reviewStarts.get(3).click();
    }

}
