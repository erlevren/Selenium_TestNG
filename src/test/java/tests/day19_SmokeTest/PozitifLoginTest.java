package tests.day19_SmokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {
    @Test
    public void positiveLoginTest() throws InterruptedException {
        //Driver driver = new Driver();
        //driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        /*
            POM'de Driver class'indaki getDriver()'nin obje olusturularak kullanilmasini engellemek icin
        Singleton pattern kullanimi benimsenmistir.

            SingleTon Pattern : tekli kullanim, bir class'in farkli class'lardan obje olusturularak
        kullanimini engellemek icin kullanilir

            Bunu saglamak icin yapmamiz gereken sey oldukce basit. Obje olusturmak icin kullanilan constructor'i
        private yaptigimizda baska class'larda Driver class'indan obje olusturulmasi mumkun OLAMAZ
         */
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        BrcPage brcPage = new BrcPage();
        brcPage.login.click();
        //test data user email: customer@bluerentalcars.com ,
        Thread.sleep(1000);
        brcPage.email.sendKeys(ConfigReader.getProperty("brcEmail"));
        //test data password : 12345
        Thread.sleep(1000);
        brcPage.password.sendKeys(ConfigReader.getProperty("brcPassword"));
        //login butonuna tiklayin
        Thread.sleep(1000);
        brcPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUsername = brcPage.user.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(expectedUsername,actualUsername);
        Driver.closeDriver();

    }
}
