package tests.PageObjectModel;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {

    @Test
    public void test01() {
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        // cikarsa cookies kabul edin
        // kullanici mail kutusuna yanlis bir isim yazdirin
        FacebookPage fbp = new FacebookPage();
        fbp.emailKutusu.sendKeys(ConfigReader.getProperty("fbWrongEmail"));
        // kullanici sifre kutusuna yanlis bir password yazdirin
        fbp.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));
        // login butonuna basin
        fbp.girisButonu.click();
        // giris yapilamadigini test edin
        Assert.assertTrue(fbp.girilemediYaziElementi.isDisplayed());
        // sayfayi kapatin
        Driver.closeDriver();
    }
}
