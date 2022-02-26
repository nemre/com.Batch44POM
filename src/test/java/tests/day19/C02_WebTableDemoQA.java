package tests.day19;

import org.testng.annotations.Test;
import pages.DemoQAPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebTableDemoQA {
    //Bir Class olusturun D19_WebtablesHomework
     @Test(groups = {"smoke","regression"})
    public void demoQaTest(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("DemoQAUrl"));

        DemoQAPage demoQAPage=new DemoQAPage();
        //  2. Headers da bulunan department isimlerini yazdirin
        //normalde thead//th olur ancak bu tablo class ismleriile oluşturulmuş
        System.out.println("başlık satırı elementi:"+demoQAPage.baslikSatiriElementi.getText());
        //ikinci yontem Liste koyarız

        //  3. sutunun basligini yazdirin
        System.out.println("3. sutun baslıkgı :"+demoQAPage.basliklarWebelementiListesi.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        System.out.println("tum body : "+ demoQAPage.tekWebEle.getText());

        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("tablo data sayısı:"+demoQAPage.tabloDataWebEle.size());

        //  6. Tablodaki satir sayisini yazdirin
        System.out.println("tum satır sauısı:"+demoQAPage.tumSatirEle.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //farkılı yollardan hesaplana bilir. hucre/satır
        System.out.println("tablo sutun sayısı :"+
                (demoQAPage.tabloDataWebEle.size())/(demoQAPage.tumSatirEle.size()));

        //  8. Tablodaki 3.kolonu yazdirin
        demoQAPage.sutunyazdır(3);

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        demoQAPage.ismegoreMaasYzdir("Kierra");

         //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        demoQAPage.hucreYazdir(2,3);









     }




}
