package tests.day27;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {
    @DataProvider
    public static Object[][] aranacakkelimelistesi() {

        String aranacaklar[][]={{"nutella"},{"Java"},{"cucumber"}};


        return aranacaklar;


    }




    @Test (dataProvider = "aranacakkelimelistesi")
    public void amazonSearch(String aranacaklar){
        //amazona git nutella arat
        //sonucların nutella icerdiğini test et
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys(aranacaklar + Keys.ENTER);

        Assert.assertTrue(amazonPage.sonucYazısıElementi.getText().contains(aranacaklar));

        Driver.closeDriver();
    }
}
