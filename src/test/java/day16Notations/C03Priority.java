package day16Notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03Priority extends TestBase {
    /*
        TestNG test methodlarini isim sirasina gore calistirir
    eger isim siralamasinin disinda bir siralama ile calismasini isterseniz
    o zaman test methodlarina oncelik yani priority tanimlayabiliriz.
        priority kusuktan buyuge gore calisir. Eger bir test methoduna priority degeri atanmamissa
    defoult olarak priority=0 olarak kabul edilir
     */
    @Test (priority =-5)
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test (priority = -2)
    public void test02() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void techproTesti() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }
}
