package tests.day22_CrossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C03_DataProvider {


    @Test
    public void test01() throws IOException {
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella icin arama yapalim
        AmazonPage amazon = new AmazonPage();
        amazon.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        Assert.assertTrue(amazon.aramaSonucElementi.getText().contains("Nutella"));
        ReusableMethods.getScreenshotWebElement("amazonSonuc",amazon.aramaSonucElementi);
        Driver.closeDriver();
    }
    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArrayi = {{"Nutella"}, {"Java"}, {"Samsung"}, {"Turkey"}};
        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    public void dataProviderTesti(String arananKelime) {
        /*
          Arayacagimiz kelimeleri bir liste gibi tutup
        bana yollayacak bir veri saglayici olusturacagiz
         */
        AmazonPage amazon = new AmazonPage();
        //amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella, java, samsung ve Turkey icin arama yapalim
        amazon.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);
        // sonuclarin aradigimiz kelime icerdigini test edelim
        String expectedKelime = arananKelime;
        String actualSonucYazisi = amazon.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        // sayfayi kapatalim


    }
}
