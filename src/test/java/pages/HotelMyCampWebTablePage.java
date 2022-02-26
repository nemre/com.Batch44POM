package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.Path;
import java.util.List;

public class HotelMyCampWebTablePage {
    public HotelMyCampWebTablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//thead//tr[1]//th")
    public List<WebElement> headerBirinciSatir;
    @FindBy (xpath = "//tbody")
    public WebElement tbody;
    @FindBy (xpath = "//tbody//td")
    public List<WebElement> bodyTumData;
    @FindBy (xpath = "//tbody//tr")
    public List<WebElement> stirlarList;

    public WebElement satirYazdir(int satirNo){
        //2. satir yazdir //tbody//tr[2]
        //7. satir yazdir //tbody//tr[7]
        String satirDinamikXpath="//tbody//tr["+ satirNo + "]";
        WebElement satirElementi=Driver.getDriver().findElement(By.xpath(satirDinamikXpath));
        return satirElementi;
    }

    public String hucreWebEleGetir(int satir, int sutun) {
        //2.satirin 4. datasi //tbody//tr[2]//td[4]
        //4.   "    5.    "   //tbody//tr[4]//td[5]
        String DinamikhucreXpath=  "//tbody//tr["+satir+"]//td["+sutun+"]";
        WebElement istenenHucre=Driver.getDriver().findElement(By.xpath(DinamikhucreXpath));
        String hucdeDatasi=istenenHucre.getText();
        return hucdeDatasi;
    }

    public void sutunYazdir(int sutun) {
        //her bir satırdakiistenen sutun ele. yazdırmak için
        //satır sayısını bilmeye ihtiyacım var
        int satirSayısı=stirlarList.size();
        for (int i=1 ; i<satirSayısı; i++){
            System.out.println(hucreWebEleGetir(i,sutun));
        }
    }
}
