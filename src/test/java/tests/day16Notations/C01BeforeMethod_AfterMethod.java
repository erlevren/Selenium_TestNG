package tests.day16Notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01BeforeMethod_AfterMethod extends TestBase {
    /*
    @BeforeMethod ve @AfterMethod notasyonlari JUnit'deki @Before ve @after gibidir
    Her test method'undan once ve sonra calisirlar
     */
    @Test
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
