package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlktest {

    //atrık drive a ihtiyacımız varsa Driver.getDriver yazmalıyız

    @Test
    public void test01(){
        //amazona git ve test et
        Driver.getDriver().get("https://www.amazon.com");
        String actTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actTitle.contains("Amazon"));

        Driver.closeDriver();
    }
    @Test(groups = {"miniRagression", "smoke"})
    public void test02(){
        //bestbuy a git ve url den test et
        Driver.getDriver().get("https://www.bestbuy.com");
        String actUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actUrl.contains("bestbuy"));

        Driver.closeDriver();

    }
}
