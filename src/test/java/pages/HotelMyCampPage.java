package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelMyCampPage {


    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement ilkLoginLinki;
    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement usernamebox;
    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;
    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement ikinciLogin;
    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement girisYapılamadı;
    @FindBy(xpath ="//span[text()='ListOfUsers']")
    public WebElement basariligiris;
    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement HotelManegementLinki;
    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement HotelListLinki;
    @FindBy(xpath = "//a[@class='btn btn-circle btn-default']")
    public WebElement addHotelLinki;
    @FindBy(xpath = "//input[@id='Code']")
    public WebElement hotelCodeKutusu;
    @FindBy(css = "[name=\"IDGroup\"]")
    public WebElement IDGRoup;
    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;
    @FindBy (xpath = "//div[text()='Hotel was inserted successfully']")
    public WebElement alert;
    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement ok;

    public void bekleme(int saniye){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void girisYap(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ilkLoginLinki.click();
        usernamebox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        password.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        ikinciLogin.click();
    }
}
