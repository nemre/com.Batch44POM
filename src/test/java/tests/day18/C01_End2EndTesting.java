package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

import javax.security.auth.kerberos.KerberosCredMessage;

public class C01_End2EndTesting {
    @Test
    public void createHotel(){
        //1. Tests packagenin altına class olusturun: CreateHotel
        //2. Bir metod olusturun: createHotel
        //3. https://www.hotelmycamp.com adresine git.
        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
        //    a. Username : manager
        //    b. Password  : Manager1!
        //5. Login butonuna tıklayın.
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        hotelMyCampPage.HotelManegementLinki.click();
        hotelMyCampPage.HotelListLinki.click();
        hotelMyCampPage.addHotelLinki.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        actions.click(hotelMyCampPage.hotelCodeKutusu)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Select select=new Select(hotelMyCampPage.IDGRoup);
        select.selectByVisibleText("Hotel Type2");

        //8. Save butonuna tıklayın.
        hotelMyCampPage.saveButton.click();

        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
       // Assert.assertTrue(hotelMyCampPage.alert.isDisplayed());

        //10. OK butonuna tıklayın.
        hotelMyCampPage.ok.click();
       // Driver.getDriver().switchTo().alert().accept();

    }


}
