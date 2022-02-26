package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_SatirSayisi {
    @Test
    public void test01() throws IOException {
        // ulkeler testinde sayfa 1 ve say2 deki satır sayılarını tazdırın
        String path ="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fis);

        int sayfaSatirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        int sayfa1FizikiKullanilanSayfaSayisi=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        System.out.println("1. sayfa satır sayısı:"+sayfaSatirSayisi);
        System.out.println("1. sayfa fiziki satır sayısı : "+sayfa1FizikiKullanilanSayfaSayisi);


        int sayfa2SatirSayisi=workbook.getSheet("Sayfa2").getLastRowNum();
        int sayfa2FizikiKullanilanSayfaSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        System.out.println("2. sayfa satır sayısı:"+sayfa2SatirSayisi);
        System.out.println("2. sayfa fiziki satır sayısı : "+sayfa2FizikiKullanilanSayfaSayisi);

    }
}
