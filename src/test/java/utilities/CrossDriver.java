package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver() {

    }
    static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        if (driver == null) { //driver'a deger atanmamissa bir kere if calistiktan sonra tekrar yeni pencere acmamasi
            // icin ikinci driver calisacagi zaman if'e deger atandigi icin if calismaz direk
            //return den driver ayni pencerede calisir
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "headless-chrome"://chrome penceri acmadan testi yapar(gorunmeden arka planda calisir)
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { // driver'a deger atanmissa
            driver.quit();
            driver = null;
        }


    }

}

