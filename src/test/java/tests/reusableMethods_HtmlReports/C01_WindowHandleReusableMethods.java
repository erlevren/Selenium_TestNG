package tests.reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandle = Driver.getDriver().getWindowHandle();
        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ArrayList<String> pencereler = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(pencereler.get(1));
        System.out.println(Driver.getDriver().getTitle());
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandle = Driver.getDriver().getWindowHandle();
        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        ReusableMethods.switchToWindow("New Window");
        System.out.println(Driver.getDriver().getTitle());
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();

        ReusableMethods.waitFor(3);

        Assert.assertEquals(expectedTitle, actualTitle);
        Driver.closeDriver();
    }
}
