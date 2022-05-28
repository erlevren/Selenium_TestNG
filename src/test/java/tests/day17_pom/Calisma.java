package tests.day17_pom;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.n11Page;
import utilities.Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Calisma {
    @Test
    public void testName() throws IOException {
        n11Page n11Page = new n11Page();
        //1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör” seçilir.
        Driver.getDriver().get("https://www.n11.com/");
        n11Page.alert.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(n11Page.magazalar).perform();

        n11Page.magazalariGor.click();
        //2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya txt dosyasına yazdırılır.
        n11Page.tumMagazalar.click();
        File aIleBaslayan = new File("C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\n11.xlsx");
        FileInputStream fis = new FileInputStream(aIleBaslayan);
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sayfa1").createRow(0).createCell(0).setCellValue("A Harfindeki Tum Magazalar");
        ArrayList<WebElement>aHarfliMagazalar= new ArrayList<>(Driver.getDriver().
                findElements(By.xpath("//*[@id=\"contentSellerList\"]/div/div[2]/div/div[2]/div[4]/div[2]/ul/li")));
        int cell = 1;
        for (WebElement w:aHarfliMagazalar) {
            workbook.getSheet("Sayfa1").createRow(cell).createCell(0).setCellValue(w.getText());
            cell++;
        }
        FileOutputStream fos = new FileOutputStream(aIleBaslayan);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }
}
