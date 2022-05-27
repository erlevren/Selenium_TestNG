package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {
    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[normalize-space()='Log in']")
    public WebElement loginButtonu;
    @FindBy (xpath = "//input[@id='UserName']")
    public WebElement username;
    @FindBy (xpath = "//input[@id='Password']")
    public WebElement password;
    @FindBy (xpath = "//input[@id='btnSubmit']")
    public WebElement login;
    @FindBy (xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement basariliGiris;
}
