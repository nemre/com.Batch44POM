package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class C05_ExeliMapeYukleme {
    @Test
    public void test01(){
        //dosya yolu ve sayfa ismi verilen exeli
        //map olarak reuseble metod olustur
        String path="src/test/java/resources/ulkeler.xlsx";
        String sayfaAdi="Sayfa1";

        Map<String,String> ulkelerMap= ReusebleMethodExel.mapOlustur(path,sayfaAdi);
        //map i kullanarak turkiyenin bilgilerirni yardırın
        System.out.println(ulkelerMap.get("Turkey"));

        //Listede newderlands oldugunu test edin
        Assert.assertTrue(ulkelerMap.containsKey("Netherlands"));
    }
}
