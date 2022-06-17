package tests.reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScreenShotReusableMethod {
    AmazonPage amazon;
    @Test
    public void amazon() throws IOException {
        // amazon sayfasina gidelim fotografini cekelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.getScreenshot("amazon");
        Driver.closeDriver();
    }
    @Test
    public void amazonSonuc() throws IOException {
        amazon = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazon.aramaKutusu.sendKeys("Nutella"+Keys.ENTER);
        ReusableMethods.getScreenshotWebElement("AramaSonucSayisi",amazon.aramaSonucElementi);
    }
    @Test
    public void n11() throws IOException {
        Driver.getDriver().get("https://www.n11.com");
        Driver.getDriver().findElement(By.id("searchData")).sendKeys("Nutella"+Keys.ENTER);
        ReusableMethods.getScreenshotWebElement("AramaSonucSayisi",Driver.getDriver().findElement(By.xpath("//*[@class='resultText ']")));

    }
}
