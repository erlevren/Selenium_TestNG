package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class n11Page {
    public n11Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "myLocation-close-info")
    public WebElement alert;

    @FindBy(xpath = "//span[@title='Mağazalar']")
    public WebElement magazalar;

    @FindBy(xpath = "//a[@title='Mağazaları Gör']")
    public WebElement magazalariGor;

    @FindBy(xpath = "(//*[text()='Tüm Mağazalar'])[1]")
    public WebElement tumMagazalar;

    @FindBy (xpath = "//*[@id=\"contentSellerList\"]/div/div[2]/div/div[2]/div[4]/div[2]/ul/li")
    public WebElement aHarfiIleBaslayanlar;


}
