package tests.day18_PageObjectModel;

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
        ArrayList<String> urunAdlari = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            urunAdlari.add(rSCP.allProducts.get(i).getText());

        }
        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        List<Integer> randomSecilen = new ArrayList<>();
        Random rnd = new Random();
        List<Integer> randomIndexList = new ArrayList<>();

        int randomSelect = 5;

        while (randomIndexList.size() < randomSelect) {
            int randomIndex = rnd.nextInt(rSCP.addToCartList.size());
            if (!randomIndexList.contains(randomIndex)) {
                randomIndexList.add(randomIndex);
            }
        }

        List<String> priceList = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        double expectedTotalPrice = 0;
        for (int i = 0; i < randomSelect; i++) {
            js.executeScript("arguments[0].click();", rSCP.addToCartList.get(randomIndexList.get(i)));

            System.out.println(urunAdlari.get(randomIndexList.get(i)));
            priceList.add(rSCP.priceElement.get(randomIndexList.get(i)).getText().replace("$", ""));
            expectedTotalPrice += Double.parseDouble(priceList.get(i));
        }




        // 7.Checkout'a tıklayın
        rSCP.checkOutButtonElement.click();
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        // 7.Checkout'a tıklayın
    }
}

