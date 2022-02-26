package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoQAPage {
    public DemoQAPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='rt-tr']")
    public WebElement baslikSatiriElementi;

    @FindBy(xpath = "//div[@class='rt-th rt-resizable-header -cursor-pointer']")
    public List<WebElement> basliklarWebelementiListesi;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    public WebElement tekWebEle;

    @FindBy (xpath = "//div[@class='rt-td']")
    public List<WebElement>tabloDataWebEle;

    @FindBy(xpath = "//div[@class='rt-tr-group']")
    public List<WebElement> tumSatirEle;


    public void sutunyazdır(int sutun) {
        int satirSayisi=tumSatirEle.size();
        String dinamikXpath;
        WebElement gecici;
        System.out.println(basliklarWebelementiListesi.get(sutun-1).getText());

        for (int i=1 ; i<=satirSayisi ; i++){
            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+sutun+"]";
            gecici=Driver.getDriver().findElement(By.xpath(dinamikXpath));
        }

    }

    public void ismegoreMaasYzdir(String isim) {
        int satirSayisi=tumSatirEle.size();
        String dinamikXpath;
        String satirdakiIsim;
        String salary;

        for (int i=1 ; i<satirSayisi ; i++){
            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+1+"]";
            satirdakiIsim=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();
            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+5+"]";
            salary=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();


            if (satirdakiIsim.equals(isim)){
                System.out.println(salary);

            }
        }


    }

    public void hucreYazdir(int satir, int sutun) {
      String  dinamikXpath="((//div[@class='rt-tr-group'])["+satir+"]//div[@class='rt-td'])["+sutun+"]";
        System.out.println(Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText());
    }
}
