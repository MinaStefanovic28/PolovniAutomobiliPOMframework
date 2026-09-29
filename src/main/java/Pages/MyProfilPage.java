package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfilPage extends BasePage {

    public MyProfilPage(WebDriver driver) {
        super(driver);
    }

    private By followedAdsLink = By.xpath("//ul[@data-testid=\"adsIFollow\"]");
    private By userEmailLabel = By.xpath("//span[@data-testid=\"profileHeaderLoggedIn\"]");


    public void openFollowedAds() {
        click(followedAdsLink);
    }

    public String getUserEmail() {
        return readText(userEmailLabel);
    }
}
