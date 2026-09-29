package Pages;

import org.openqa.selenium.*;

public class PostAdPage extends BasePage {

    public PostAdPage(WebDriver driver) {
        super(driver);
    }

    private By carCategoryBtn = By.id("carsDesktopView");

    //Obavezna input polja sa zvezdicom
    //Osnovne informacije
    private By imgUploadInput = By.id("pickfiles");
    private By markaDropdown = By.id("brand");
    private By modelDropdown = By.id("model");
    private By yearInput = By.id("year");
    private By bodyTypeDropdown = By.id("carBody");
    private By fuelTypeDropdown = By.id("fuelType");

    //Tehnicke specijifikacije
    private By cubicInput = By.id("cubic");
    private By powerKwInput = By.id("powerKw");
    private By mileageInput = By.id("mileage");


    private By priceInput = By.id("negotiated");

    private By cityInput = By.id("city");
    private By phoneInput = By.name("cellphone");
    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");
    private By submitAdButton = By.id("submit");


    public void clickOnCarCategory() {
        click(carCategoryBtn);
    }

    public void fillBasicInfo(String marka, String model, String godiste, String karoserija, String gorivo) {
        selectReactOption(markaDropdown, marka);
        selectReactOption(modelDropdown, model);
        sendKeys(yearInput, godiste);
        selectReactOption(bodyTypeDropdown, karoserija);
        selectReactOption(fuelTypeDropdown, gorivo);
    }


    public void fillTechnicalDetails(String kubikaza, String kw, String km, String cena) {
        sendKeys(cubicInput, kubikaza);
        sendKeys(powerKwInput, kw);
        sendKeys(mileageInput, km);
        sendKeys(priceInput, cena);
    }

    public void fillContactInfo(String grad, String telefon, String ime, String prezime) {
        selectReactOption(cityInput, grad);

        try {
            sendKeys(phoneInput, telefon);
            sendKeys(firstNameInput, ime);
            sendKeys(lastNameInput, prezime);
        } catch (Exception ignored) {
        }
    }

    public void fillMandatoryForm() {
        fillBasicInfo("Audi", "A3", "2007", "Hečbek", "Dizel");
        fillTechnicalDetails("1876", "77", "255000", "5000");
        fillContactInfo("Smederevo", "0600442126", "Mina", "Stefanovic");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        try {
            Thread.sleep(1000);
            WebElement checkbox = driver.findElement(By.cssSelector(".ant-checkbox-input, .ant-checkbox-inner, input[type='checkbox']"));
            js.executeScript("arguments[0].click();", checkbox);
            Thread.sleep(500);
        } catch (Exception ignored) {
        }

        clickSubmitButton();
    }

    public void clickSubmitButton() {
        click(submitAdButton);
    }

    public boolean isSubmitBtnStillDisplayed() {
        return isDisplayed(submitAdButton);
    }


}
