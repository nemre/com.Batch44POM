package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PropertiesIlkClass {
    @Test
    public void propertiesLoginTesti(){
        //hotelmaycamp site. pozitif testi pom a uygun uygula
        //https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        //login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        //test data username: manager ,
        hotelMyCampPage.usernamebox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        //test data password : Manager1!
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.bekleme(3);
        hotelMyCampPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelMyCampPage.basariligiris.isDisplayed());


    }
}
