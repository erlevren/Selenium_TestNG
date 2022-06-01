package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {
    public BrcPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[normalize-space()='Login']")
    public WebElement login;
    @FindBy (xpath = "//input[@id='formBasicEmail']")
    public WebElement email;
    @FindBy (xpath = "//input[@id='formBasicPassword']")
    public WebElement password;
    @FindBy (xpath = "//button[@type='submit']")
    public WebElement ikinciLogin;
    @FindBy (xpath = "//button[@id='dropdown-basic-button']")
    public WebElement user;


}
