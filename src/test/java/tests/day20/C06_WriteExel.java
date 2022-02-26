package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.*;

public class C06_WriteExel {
    @Test
    public void test01() throws IOException {
        //ulkeler exeline 5.sutun olarak nufus sutununu ekleyin
        //3.satirdaki ulkenin nufusunu 1000000 yapalim

        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fis);

        //ilk satırın 5. huc. nufus sat. yazdır
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1000000");

        //degişiklikleri ana dosyaya kaydet
        FileOutputStream fos=new FileOutputStream(path);
        workbook.write(fos);
    }
}
