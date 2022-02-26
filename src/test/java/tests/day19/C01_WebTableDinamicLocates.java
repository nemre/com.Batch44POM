package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import pages.HotelMyCampWebTablePage;
import utilities.Driver;

public class C01_WebTableDinamicLocates {
    //3 test method'u olusuralim
     HotelMyCampWebTablePage hotelMyCampWebTablePage;
    HotelMyCampPage hotelMyCampPage;
    @Test
    public void satirGetirTesti(){
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();

        //1.Method: satir numarasi verdigimde bana o satirdaki datalari yazdirsin
        hotelMyCampWebTablePage=new HotelMyCampWebTablePage();
        WebElement ucuncuSatirEle=hotelMyCampWebTablePage.satirYazdir(4);
        System.out.println(ucuncuSatirEle.getText());
        Driver.closeDriver();
    }
    @Test
    public void hucreGetirTesti(){
    //2.Method: satir ve data numarasi girdigimde, verdigim datayi yazdirsin
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();

        hotelMyCampWebTablePage=new HotelMyCampWebTablePage();
        //2.satirin 4. datasi //tbody//tr[2]//td
        //4.   "    5.    "   //tbody//tr[4]//td[5]
        System.out.println(hotelMyCampWebTablePage.hucreWebEleGetir(3,5));
        Driver.closeDriver();
    }
    @Test
    public void sutunYazdirTesti(){
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
    //3.Method: sutun numarasi verdigimde bana tum sutunu yazdirsin
        hotelMyCampWebTablePage=new HotelMyCampWebTablePage();
        hotelMyCampWebTablePage.sutunYazdir(4);
        Driver.closeDriver();

    }
}
