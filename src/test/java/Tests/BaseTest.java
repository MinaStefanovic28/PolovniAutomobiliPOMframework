package Tests;

import Pages.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;

    protected HomePage homePage;
    protected SearchResultPage searchResultPage;
    protected SingleAdPage singleAdPage;
    protected LoginPage loginPage;
    protected SavedAdsPage savedAdsPage;
    protected PostAdPage postAdPage;
    protected MyProfilPage myProfilPage;


    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

// Ako se pokreće na GitHub-u (ili ako proslediš -Dheadless=true), radiće u pozadini
// U suprotnom, lokalno se otvara normalan prozor
        if ("true".equals(System.getProperty("headless"))) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        } else {
            // Lokalno otvoreno
            options.addArguments("--start-maximized");
        }

        driver = new ChromeDriver(options);

        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        singleAdPage = new SingleAdPage(driver);
        loginPage = new LoginPage(driver);
        savedAdsPage = new SavedAdsPage(driver);
        postAdPage = new PostAdPage(driver);
        myProfilPage = new MyProfilPage(driver);


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
