package tests.day21;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethod;

import java.io.IOException;
import java.util.Set;
public class C01_WindowHandleReusableMethods {
    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/windows adresine gidelim
        // new tab butonuna basalim
        // new tab'a gecip title'inin "New Window" oldugunu test edin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> handleSeti=Driver.getDriver().getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each : handleSeti
        ) {
            if (!each.equals(ilkSayfaWindowHandle)){
                ikinciSayfaHandle=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandle);
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        System.out.println("actualTitle"+ actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void reusableMEthod() throws IOException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethod.switchToWindow("New WinDow");

        String expTitle="New WinDow";
        String actTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actTitle,expTitle);
        ReusableMethod.getScreenshot("WindowSwicth");
        Driver.closeDriver();
    }
}
