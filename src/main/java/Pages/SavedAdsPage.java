package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SavedAdsPage extends BasePage {

    public SavedAdsPage(WebDriver driver) {
        super(driver);
    }


    private By headlineOfPage = By.xpath("//h2[contains(text(), 'Oglasi koje pratim')]");


    public String getHeadlineOfPage() {
        return readText(headlineOfPage);
    }


}


