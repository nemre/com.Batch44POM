package tests.day27;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProviderNegativeLoginTesti {
    @DataProvider
    public static Object[][] arananUserList() {
        String liste[][]={{"manager11","manager11"},{"manager12","manager12"},{"manager13","manager13"}};
        return liste;
    }

    @Test(dataProvider = "arananUserList")
    public void yanlisSifreUsernameTesti(String wrongUsername, String wrongPassword){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        hotelMyCampPage.usernamebox.sendKeys(wrongUsername);
        hotelMyCampPage.password.sendKeys(wrongPassword);
        hotelMyCampPage.ikinciLogin.click();
        Assert.assertTrue(hotelMyCampPage.girisYapılamadı.isDisplayed());
        Driver.closeDriver();
    }

}
