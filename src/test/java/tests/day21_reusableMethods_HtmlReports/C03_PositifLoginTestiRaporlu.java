package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class C03_PositifLoginTestiRaporlu extends TestBaseRapor {
    BrcPage brcPage;
    @Test
    public void pozitifLoginTestRaporlu() throws InterruptedException, IOException {
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli");

        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        //      login butonuna bas
        brcPage = new BrcPage();
        brcPage.login.click();
        extentTest.info("Ilk login butonuna tiklandi");
        //test data user email: customer@bluerentalcars.com ,
        Thread.sleep(1000);
        brcPage.email.sendKeys(ConfigReader.getProperty("brcEmail"));
        extentTest.info("Gecerli email yazildi");
        //test data password : 12345
        Thread.sleep(1000);
        brcPage.password.sendKeys(ConfigReader.getProperty("brcPassword"));
        extentTest.info("Gecerli password yazildi");
        //login butonuna tiklayin
        Thread.sleep(1000);
        brcPage.ikinciLogin.click();
        extentTest.info("ikinci login butonuna basildi");
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUsername = brcPage.user.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(expectedUsername,actualUsername);
        extentTest.pass("Kullanici basarili sekilde giris yapti");
        ReusableMethods.getScreenshot("sayfaResmi");
        Driver.closeDriver();
        extentTest.pass("Driver kapatildi, test sonlandirildi");

    }
}
