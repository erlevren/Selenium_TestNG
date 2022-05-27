package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /*
        POM'da driver icin TestBase class'ina extends etmek yerine Driver class'indan statik methodlar kullanarak
    driver olusturup, ilgili ayarlarin yapilmasi ve en sonda driver'in kapatilmasi tercih edilmistir
     */
    static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver==null) { //driver'a deger atanmamissa bir kere if calistiktan sonra tekrar yeni pencere acmamasi
                            // icin ikinci driver calisacagi zaman if'e deger atandigi icin if calismaz direk
                            //return den driver ayni pencerede calisir
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null) { // driver'a deger atanmissa
            driver.close();
            driver=null;
        }



    }

}
