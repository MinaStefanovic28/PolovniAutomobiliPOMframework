package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By submitButton = By.cssSelector("button[data-testid=\"login\"]");
    private By errorMessage = By.id("errorContainerTop");


    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickLoginBtn() {
        click(submitButton);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

    public String getErrorMsg() {
        return readText(errorMessage);
    }

    public void loginWithValidCredetntials() {
        enterEmail("petrovmina97@gmail.com");
        enterPassword("Deponijadeponija21");
        clickLoginBtn();
    }
}

