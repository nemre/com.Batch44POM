package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageIlkClass {

    @Test
    public void test01(){
        //amazon agit
        Driver.getDriver().get("https://www.amazon.com");
        //nutella yaz arat
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        //sonucları test et
        String actSonucYazısı=amazonPage.sonucYazısıElementi.getText();
        Assert.assertTrue(actSonucYazısı.contains("nutella"));
        Driver.closeDriver();
    }

    @Test(groups = {"miniRagression", "smoke"})
    public void test2(){
        //amazona git
        Driver.getDriver().get("https://www.amazon.com");
        //java için arama yap
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("java"+Keys.ENTER);
        //sonucu dogrula
        String jsonuc=amazonPage.sonucYazısıElementi.getText();
        Assert.assertTrue(jsonuc.contains("java"));
    }
}
