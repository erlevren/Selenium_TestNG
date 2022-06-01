package tests.day19_SmokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class End2End {
    @Test
    public void test01() throws InterruptedException {
        //1.	Tests packagenin altına class olusturun: CreateHotel
        //2.	Bir metod olusturun: createHotel
        //3.	https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        //4.	Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //a.	Username : manager
        //b.	Password : Manager1!
        HotelMyCampPage hotel = new HotelMyCampPage();
        hotel.loginButtonu.click();
        Thread.sleep(1000);
        hotel.username.sendKeys(ConfigReader.getProperty("hotelUser"));
        hotel.password.sendKeys(ConfigReader.getProperty("hotelPassword"));
        //5.	Login butonuna tıklayın.
        hotel.login.click();
        Thread.sleep(1000);
        //6.	Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        hotel.hotelManagement.click();
        Thread.sleep(1000);
        hotel.hotelList.click();
        Thread.sleep(1000);
        hotel.addHotel.click();
        //7.	Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions = new Actions(Driver.getDriver());
        hotel.code.sendKeys("12345");
        actions.sendKeys(Keys.TAB).sendKeys("erol").sendKeys(Keys.TAB).sendKeys("antalya").
                sendKeys(Keys.TAB).sendKeys("987654321").sendKeys(Keys.TAB).sendKeys("erol@gmail.com").
                sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        Select select = new Select(hotel.dropdown);
        select.selectByIndex(1);
        //8.	Save butonuna tıklayın.
        hotel.save.click();
        Thread.sleep(1000);
        //9.	“Hotel was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(hotel.visible.isDisplayed());
        //10.	OK butonuna tıklayın.
        hotel.okButton.click();
        Driver.closeDriver();

    }
}
