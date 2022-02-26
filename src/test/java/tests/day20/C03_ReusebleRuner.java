package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ReusebleRuner {
    @Test
    public void test01(){
        //ulkelr exeli, sayfa 1, 11.index satir, 2. index azerbaycan old. test et

        String path="src/test/java/resources/ulkeler.xlsx";
        String ecpData="Azerbaycan";
        String actData= ReusebleMethodExel.hücreGetir(path,"Sayfa1",11,2).toString();
        Assert.assertEquals(actData,ecpData);
    }
}
