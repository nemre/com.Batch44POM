package tests.day20;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReusebleMethodExel {
    //bir metod olustur
    //dosya yolu ve satir, hücre indexini verince hücre bilgilerini yazdırsın

    public static Cell hücreGetir(String path,String sayfaismi,int satirindex, int hücreindex)  {
        Cell cell=null;
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            Workbook workbook= WorkbookFactory.create(fileInputStream);
            cell=workbook.getSheet(sayfaismi).getRow(satirindex).getCell(hücreindex);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return cell;
    }

    public static Map<String,String> mapOlustur(String path, String sayfaAdi)  {
        Map<String,String> exelMap=new HashMap();
        Workbook workbook=null;
        //ilk adım exele ulaş
        try {
            FileInputStream fis=new FileInputStream(path);
            workbook=WorkbookFactory.create(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int satirSayisi=workbook.getSheet(sayfaAdi).getLastRowNum();

        String key="";
        String value="";

        for (int i=0 ; i<=satirSayisi ; i++){
            //2. adim tablodaki hücreleri mape uygun hale getirme
        key=workbook.getSheet(sayfaAdi).getRow(i).getCell(0).toString();
        value=workbook.getSheet(sayfaAdi).getRow(i).getCell(1).toString()+
                    ","+workbook.getSheet(sayfaAdi).getRow(i).getCell(2).toString()+
                    ","+workbook.getSheet(sayfaAdi).getRow(i).getCell(3).toString();
        exelMap.put(key,value);
        }

        return exelMap;
    }
}
