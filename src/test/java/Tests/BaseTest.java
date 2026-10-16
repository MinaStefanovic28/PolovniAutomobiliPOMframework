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
        driver = new ChromeDriver();
        driver.manage().window().maximize();


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
