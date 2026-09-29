package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private By headlineOfFirstAd = By.id("29095781");
    private By priceOfFirstAd = By.xpath("(//article//span[contains(@class,'price')])[1]");
    private By numberOfSearchResults = By.tagName("h1");

    public String getNumberOfSearchResult() {
        return readText(numberOfSearchResults);
    }

    public String getFirstAdHeadline() {
        return readText(headlineOfFirstAd);
    }

    public void clickOnFirstAd() {
        click(headlineOfFirstAd);
    }

}

