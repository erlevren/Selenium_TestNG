package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {
    @Test
    public void test01() {
        FacebookPage facebook = new FacebookPage();
        Faker faker = new Faker();
        //facebook ana sayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");
        //Kullanici mail kutusuna rastgele bir isim yazdirin
        facebook.emailKutusu.sendKeys(faker.internet().emailAddress());
        //Kullanici sifre kutusuna rastgele bir password yazdirin
        facebook.sifreKutusu.sendKeys(faker.internet().password());
        //Login button u na basin
        facebook.girisButonu.click();
        //Giris yapilamadigini test edin
        Assert.assertTrue(facebook.girilemediYaziElementi.isDisplayed());
        System.out.println(facebook.girilemediYaziElementi.getText());
        Driver.closeDriver();

    }
}
