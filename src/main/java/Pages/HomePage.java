package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By markaDropdown = By.xpath("//*[@id='brand']//input | //*[contains(@id, 'brand')]//input");
    private By modelDropdown = By.xpath("//*[@id='model']//input | //*[contains(@id, 'model')]//input");
    private By btnPretraga = By.id("searchButton");
    private By cookieAcceptBtn = By.xpath("//button[contains(text(),'U redu')]");
    private By loginBtn = By.cssSelector("span[data-testid=\"headerSignIn\"]");
    private By priceInput = By.id("priceTo");
    private By fuelDropdown = By.id("fuel");
    private By logoHeader = By.id("headerPolovniAutomobiliLogo");


    public void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'U redu')]")));
            button.click();
        } catch (Exception e) {
            System.out.println("Kolačići se nisu pojavili ili su već prihvaćeni, nastavljam test.");
        }
    }

    public void selectModel(String model) {
        click(modelDropdown);
        sendKeys(modelDropdown, model);
        driver.findElement(modelDropdown).sendKeys(Keys.ENTER);
    }

    public void selectMarku(String marka) {
        click(markaDropdown);
        sendKeys(markaDropdown, marka);
        driver.findElement(markaDropdown).sendKeys(Keys.ENTER);

    }

    public void clickSearchBtn() {
        click(btnPretraga);
    }

    public void open() {
        driver.get("https://www.polovniautomobili.com/");
    }

    public boolean isLogoDisplayed() {
        return isDisplayed(logoHeader);
    }

    public void clickLoginButton() {
        click(loginBtn);
    }

    public boolean isBrandDropdownDisplayed() {
        return isDisplayed(markaDropdown);
    }

    public boolean isModelDropdownDisplayed() {
        return isDisplayed(modelDropdown);
    }

    public void enterPrice(String price) {
        click(priceInput);
        sendKeys(priceInput, price);
    }

    public void selectFuel(String fuel) {
        selectReactOption(fuelDropdown, fuel);
    }


}

