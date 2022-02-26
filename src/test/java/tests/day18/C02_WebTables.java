package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import pages.HotelMyCampWebTablePage;

import java.util.List;

public class C02_WebTables {
    HotelMyCampPage hotelMyCampPage;
    HotelMyCampWebTablePage hotelMyCampWebTablePage;
    @Test
    public void loginT() {
        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //○ Username : manager
        //○ Password : Manager1!
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.girisYap();

    }

    //● table( ) metodu oluşturun
    @Test (dependsOnMethods = "loginT")
    public void table(){
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
         //header kısmında 1. satır ve dataları locate edelim
        //  //thead//tr[1]//td
        hotelMyCampWebTablePage=new HotelMyCampWebTablePage();
        List<WebElement> headerDataList=hotelMyCampWebTablePage.headerBirinciSatir;
        System.out.println("tablodaki sutun sayısı :"+ headerDataList.size());

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        // tbody dememiz yeterli
        System.out.println(hotelMyCampWebTablePage.tbody.getText());


    }

 @Test(dependsOnMethods = "loginT")
    public void printRows(){
     //● printRows( ) metodu oluşturun //tr
     //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
     //tbody//tr
     hotelMyCampWebTablePage=new HotelMyCampWebTablePage();
     System.out.println(hotelMyCampWebTablePage.stirlarList.size());
     //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
     List<WebElement> stirWebElementList=hotelMyCampWebTablePage.stirlarList;
     for (WebElement each :stirWebElementList){
         System.out.println(each.getText());
     }
     //○ 4.satirdaki(row) elementleri konsolda yazdırın.
     System.out.println("4. satir: "+ stirWebElementList.get(3).getText());

 }
}
