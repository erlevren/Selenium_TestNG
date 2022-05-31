package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ReactShoppıngCartPage {

    public ReactShoppıngCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@class='sc-124al1g-4 eeXMBo']")
    public List<WebElement> allProducts;
    @FindBy(xpath = "//*[@class='sc-124al1g-0 jCsgpZ']")
    public List<WebElement> addToCartList;
    @FindBy(xpath = "//span[normalize-space()='X']")
    public WebElement x;
    @FindBy(xpath = "//div[@class='sc-11uohgb-4 bnZqjD']//p")
    public List<WebElement> urunFiyatlari;
    @FindBy(xpath = "//div[@class='sc-1h98xa9-8 bciIxg']/p[1]")
    public WebElement subtotalPriceElement;
    @FindBy(xpath = "//button[@class='sc-1h98xa9-11 gnXVNU']")
    public WebElement checkOutButtonElement;


}
