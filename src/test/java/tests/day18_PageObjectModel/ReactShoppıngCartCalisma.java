package tests.day18_PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ReactShoppıngCartPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReactShoppıngCartCalisma {
    @Test
    public void test01() throws InterruptedException {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("ReactShopping"));
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        ReactShoppıngCartPage rSCP = new ReactShoppıngCartPage();
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        for (int i = 0; i < rSCP.allProducts.size(); i++) {
            System.out.println((i + 1) + ".urun : " + (rSCP.allProducts.get(i).getText()));
        }
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        ArrayList<String> urunler = new ArrayList<>();
        for (WebElement w : rSCP.allProducts) {
            urunler.add(w.getText());
        }
        System.out.println(urunler);
        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        for (int i = 0; i < rSCP.allProducts.size(); i++) {
            rSCP.addToCartList.get(i).click();
            Thread.sleep(1000);
            rSCP.x.click();
        }
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        List<WebElement> fiyatlar = Driver.getDriver().findElements(By.xpath("//div[@class='sc-124al1g-6 ljgnQL']"));
        double toplam = 0;
        System.out.println("*************************************");
        for (int i = 0; i < fiyatlar.size(); i++) {
            System.out.println(fiyatlar.get(i).getText());

        }


    }
}



// 7.Checkout'a tıklayın
//rSCP.checkOutButtonElement.click();
// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
// 7.Checkout'a tıklayın



