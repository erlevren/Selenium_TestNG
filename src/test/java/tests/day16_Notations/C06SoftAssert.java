package tests.day16_Notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06SoftAssert extends TestBase {
    @Test(groups = "grup2")
    public void test01() {
        /*
          Softassertion baslangic ve bitis satirlari arasindaki tum assertion'lari yapip
        bitis satirina geldiginde bize buldugu tum hatalari rapor eder
          softAssert baslangici obje olusturmaktir
         */
        SoftAssert softAssert = new SoftAssert();
        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2-title in Amazon içerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");
        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erisilemiyor");
        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //5-arama yapıldıgını test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed());
        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"),"sonuc yazisi Kutella icermiyor");
        /*softAssert'e bitis satirini soylemek icin assertAll() kullanilir
        softAssert.assertAll(); son olarak yazilmazsa islem yapilmamis olur
         */
        softAssert.assertAll();
        /*
        Softassert'un hata bulsa bile calismaya devam etme ozelligi assertAll()'a kadardir
        Eger assertAll()'da failed rapor edilirse calisma durur ve class'in kalan kismi calistirilmaz
        Yani assertAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur
         */
        System.out.println("assertion'lardan fail olan olursa, burasi calismaz");
    }
}
