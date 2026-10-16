package Tests;

import org.junit.Assert;
import org.junit.Test;

public class SmokeTests extends BaseTest {

   // Test Scenario 1: Provera Početne Stranice i Osnovne Navigacije (Homepage & Navigation)

    @Test
    public void test01_UcitavanjeHomepageAIVerifikacijaNaslova() {
        homePage.open();
        homePage.acceptCookies();

        String actualTitle = driver.getTitle();
        Assert.assertTrue("Naslov ne sadrži 'Polovni automobili'", actualTitle.contains("Polovni automobili"));
        Assert.assertTrue("Glavni element nije vidljiv", homePage.isLogoDisplayed());
    }

    @Test
    public void test02_ProveraPrikazaElemenataBrzogPretrazivaca() {
        homePage.open();
        homePage.acceptCookies();

        Assert.assertTrue("Padajući meni za marku nije vidljiv", homePage.isBrandDropdownDisplayed());
    }

    //Test Scenario 2: Pretraga I filtriranje vozila

    @Test
    public void test03_PretragaVozilaPoZadatojMarkiIModelu() {
        homePage.open();
        homePage.acceptCookies();

        homePage.selectMarku("Audi");
        homePage.selectModel("A1");
        homePage.clickSearchBtn();
    }

    @Test
    public void test04_FiltriranjePretragePoCeniITipuGoriva() {
        homePage.open();
        homePage.acceptCookies();

        homePage.selectMarku("Audi");
        homePage.selectModel("A4");

        homePage.enterPrice("15000");
        homePage.selectFuel("Dizel");
        homePage.clickSearchBtn();

        homePage.waitForUrlToContain("Audi");
        Assert.assertTrue(driver.getCurrentUrl().contains("Audi"));

    }

    //Test Scenario 3: Autentifikacija i Kontakt Forma

    @Test
    public void test05_NeuspesnaPrijavaPogresnimKredencijalima() {
        homePage.open();
        homePage.acceptCookies();
        homePage.clickLoginButton();

        loginPage.enterEmail("test.student@example.com");
        loginPage.enterPassword("TestPassword123!");
        loginPage.clickLoginBtn();

        Assert.assertFalse("Poruka o grešci nije prikazana", loginPage.getErrorMsg().isEmpty());    }

    @Test
    public void test06_SlanjePorukeProdavcuPutemKontaktForme() {
        homePage.open();
        homePage.acceptCookies();
        homePage.selectMarku("Audi");
        homePage.selectModel("A4");

        homePage.clickSearchBtn();

        homePage.waitForUrlToContain("Audi");

        searchResultPage.clickOnFirstAd();
        singleAdPage.clickSendMessage();
        loginPage.loginWithValidCredetntials();
        singleAdPage.clickSendMessage();

        singleAdPage.enterMessageText("Dobar dan, da li je auto jos uvek dostupan?");

        Assert.assertTrue(singleAdPage.isConfirmationMsgDisplayes());

    }


    //Test Scenario 4: Pregled sačuvanih oglasa

    @Test
    public void test07_PregledSacuvanihOglasa() {
        homePage.open();
        homePage.acceptCookies();
        homePage.clickLoginButton();
        loginPage.loginWithValidCredetntials();
        homePage.clickLoginButton();

        homePage.acceptPromoCredit();
        myProfilPage.openFollowedAds();


        Assert.assertNotNull(savedAdsPage.getHeadlineOfPage());
    }




    //Test scenario 5: Negativan test - Postavljanje oglasa bez svih obaveznih polja

    @Test
    public void test08_PostavljanjeOglasaSaNepotpunimObaveznimPodacima() {
        homePage.open();
        homePage.acceptCookies();
        homePage.clickLoginButton();
        loginPage.loginWithValidCredetntials();
        homePage.clickOnPostAd();
        postAdPage.clickOnCarCategory();

        postAdPage.fillMandatoryForm();
        postAdPage.clickSubmitButton();

        Assert.assertTrue(postAdPage.isSubmitBtnStillDisplayed());
    }





}