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
    @FindBy (xpath = "//span[normalize-space()='Hotel Management']")
    public WebElement hotelManagement;
    @FindBy (xpath = "//a[normalize-space()='Hotel List']")
    public WebElement hotelList;
    @FindBy (xpath = "//span[@class='hidden-480']")
    public WebElement addHotel;
    @FindBy (xpath = "//input[@id='Code']")
    public WebElement code;
    @FindBy (xpath = "//select[@id='IDGroup']")
    public WebElement dropdown;
    @FindBy (xpath = "//*[@id='btnSubmit']")
    public WebElement save;
    @FindBy (xpath = "//*[@class='bootbox-body']")
    public WebElement visible;
    @FindBy (xpath = "//*[@class='btn btn-primary']")
    public WebElement okButton;
    @FindBy (xpath = "//select[@id='IDGroup']")
    public WebElement id;
    @FindBy (xpath = "//a[normalize-space()='Hotel Rooms']")
    public WebElement hotelRooms;
    @FindBy (xpath = "//*[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfHotelRooms;


}
