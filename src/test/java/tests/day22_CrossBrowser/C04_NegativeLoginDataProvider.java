package tests.day22_CrossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {
    BrcPage brcPage = new BrcPage();

    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object[][] kullaniciBilgileri = {{"erol@gmail.com","54678"},{"evren@gmail.com","123456"},{"ezel@gmail.com","65432"}};
        return kullaniciBilgileri;
    }


    @Test(dataProvider = "kullaniciListesi")
    public void yanlisSifre(String userEMail, String password) throws InterruptedException {
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage = new BrcPage();
        brcPage.login.click();
        //test data user email: dataprovider'dan alalim ,
        Thread.sleep(1000);
        brcPage.email.sendKeys(userEMail);
        //test data password : data provider'den alalim
        Thread.sleep(1000);
        brcPage.password.sendKeys(password);
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
