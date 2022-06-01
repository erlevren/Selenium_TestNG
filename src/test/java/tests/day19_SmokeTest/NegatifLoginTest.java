package tests.day19_SmokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTest {
    BrcPage brcPage = new BrcPage();
    @Test
    public void yanlisSifre() throws InterruptedException {
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage = new BrcPage();
        brcPage.login.click();
        //test data user email: customer@bluerentalcars.com ,
        Thread.sleep(1000);
        brcPage.email.sendKeys(ConfigReader.getProperty("brcEmail"));
        //test data password : 54321
        Thread.sleep(1000);
        brcPage.password.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        //login butonuna tiklayin
        Thread.sleep(1000);
        brcPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLogin.isDisplayed());
        Driver.closeDriver();

    }

    @Test (dependsOnMethods = "yanlisSifre")
    public void yanlisKullanici() throws InterruptedException {
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage = new BrcPage();
        brcPage.login.click();
        //test data user email: boss@bluerentalcars.com ,
        Thread.sleep(1000);
        brcPage.email.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //test data password : 54321
        Thread.sleep(1000);
        brcPage.password.sendKeys(ConfigReader.getProperty("brcPassword"));
        //login butonuna tiklayin
        Thread.sleep(1000);
        brcPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLogin.isDisplayed());
        Driver.closeDriver();

    }
    @Test(dependsOnMethods = "yanlisKullanici")
    public void yanlisSifreYanlisKullanici() throws InterruptedException {
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage = new BrcPage();
        brcPage.login.click();
        //test data user email: boss@bluerentalcars.com ,
        Thread.sleep(1000);
        brcPage.email.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //test data password : 54321
        Thread.sleep(1000);
        brcPage.password.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        //login butonuna tiklayin
        Thread.sleep(1000);
        brcPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLogin.isDisplayed());
        Driver.closeDriver();

    }
}
