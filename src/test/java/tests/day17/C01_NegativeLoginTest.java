package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_NegativeLoginTest {
    @Test
    public void negativeLogin(){
        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com");
        //login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        //test data username: manager1 ,
        hotelMyCampPage.usernamebox.sendKeys("manager1");
        //test data password : manager1!
        hotelMyCampPage.password.sendKeys("manager1!");
        hotelMyCampPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCampPage.girisYapılamadı.isDisplayed());



    }

}
