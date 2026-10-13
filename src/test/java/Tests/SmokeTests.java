package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

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
    public void test02_ProveraElemenataBrzogPretrazivaca() {
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
    public void test05_PrijavaKorisnikaNaSistem() {
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
        driver.get("https://www.polovniautomobili.com/auto-oglasi/30111567/audi-a4-s-line?paPage=srchpg&paSection=tsbx&paPromo=true&paPageNo=1&sort=basic");
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

        homePage.click(By.cssSelector("button[data-testid=\"creditPromoOk\"]"));
        myProfilPage.openFollowedAds();


        Assert.assertNotNull(savedAdsPage.getHeadlineOfPage());
    }







    // --- TEST SCENARIO 4: Postavljanje Oglasa ---

    @Test
    public void test05_NegativanTestSlanjeForme() {
        homePage.open();
        homePage.acceptCookies();
        homePage.clickLoginButton();
        loginPage.loginWithValidCredetntials();
        homePage.clickOnPostAd();
        postAdPage.clickOnCarCategory();

        // 1. Unosimo sve podatke koje imamo spremljene u tvojoj metodi
        postAdPage.fillMandatoryForm();


        // 2. Klikćemo na dugme za slanje
        postAdPage.clickSubmitButton();

        // 3. VERIFIKACIJA: Proveravamo da je sajt izbacio grešku za marku/obavezna polja
        Assert.assertTrue(postAdPage.isSubmitBtnStillDisplayed());
    }





}