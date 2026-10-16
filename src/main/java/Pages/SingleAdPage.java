package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleAdPage extends BasePage {

    public SingleAdPage(WebDriver driver) {
        super(driver);
    }

    private By adHeadline = By.xpath("//h1[@data-testid=\"adTitleDesktop\"]");
    private By priceOfAd = By.xpath("//*[@data-testid=\"adPriceDesktop\"]");
    private By showNumberBtn = By.xpath("//*[@data-testid=\"showNumberButton\"]");
    private By sendMsgBtn = By.cssSelector("button[data-testid=\"sendMessageButton\"]");

    //pop-up Contact Seller
    private By textArea = By.xpath("//*[@placeholder=\"Tekst poruke\"]");
    private By submitMsgBtn = By.id("sendMessageSubmit");
    public By popUpMsg = By.id("confirmationModal");
    private By closePopUpMsgBtn = By.xpath("//*[text()=\"U redu\"]");


    public String getAdHeadline() {
        return readText(adHeadline);
    }

    public String getAdPrice() {
        return readText(priceOfAd);
    }

    public void clickShowNumber() {
        click(showNumberBtn);
    }

    public void clickSendMessage() {
        click(sendMsgBtn);
    }

    public void enterMessageText(String tekst) {
        sendKeys(textArea, tekst);
    }

    public void clickSend() {
        click(submitMsgBtn);
    }


    public void closePopUpMsg() {
        click(closePopUpMsgBtn);
    }

    public boolean isConfirmationMsgDisplayes() {
        return  isDisplayed(popUpMsg);
    }


}






