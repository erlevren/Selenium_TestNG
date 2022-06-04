package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBaseCross {
    protected WebDriver driver;
    //protected static String tarih;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser) {


        driver = CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //LocalDateTime date = LocalDateTime.now();
        //DateTimeFormatter formatter= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        //tarih = date.format(formatter);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        CrossDriver.closeDriver();
    }

}

