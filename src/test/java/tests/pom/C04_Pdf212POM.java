package tests.pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C04_Pdf212POM {
    @Test
    public void test01() {
        HotelMyCampPage hotel = new HotelMyCampPage();
        //1 ) Bir Class olustur : PositiveTest
        //2) Bir test method olustur positiveLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");
        //login butonuna bas
        //test data username: manager ,
        //test data password : Manager1!
        hotel.loginButtonu.click();
        hotel.username.sendKeys("manager");
        hotel.password.sendKeys("Manager1!");
        hotel.login.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotel.basariliGiris.isDisplayed());
        Driver.closeDriver();
    }
}
