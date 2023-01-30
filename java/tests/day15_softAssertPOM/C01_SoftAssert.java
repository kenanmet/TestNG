package tests.day15_softAssertPOM;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;


public class C01_SoftAssert {
    // amazon anasayfaya gidin
    // amazon anasayfaya gittiginizi dogrulayin
    // nutella aratin
    // arama sonuclarinin nutella icerdigini dogrulayin
    // java aratin
    // arama sonuclarinin 1000'den fazla oldugunu dogrulayin

    @Test (groups = {"minireg1","minireg2"})
    public void test01(){
        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        // amazon anasayfaya gittiginizi dogrulayin
        SoftAssert softAssert=new SoftAssert();
        String expectedUrlKelime="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlKelime),"Url amazon icermiyor");

        // nutella aratin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("nutella" + Keys.ENTER);

        // arama sonuclarinin nutella icerdigini dogrulayin
        String aramaSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazisi.contains("nutella"),"arama sonuclari nutella icermiyor");

        // java aratin
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("java" + Keys.ENTER);

        // arama sonuclarinin 1000'den fazla oldugunu dogrulayin
        aramaSonucYazisi=amazonPage.aramaSonucuElementi.getText(); // 1-48 of over 7,000 results for "java"
        String [] sonucArr=aramaSonucYazisi.split(" "); // [1-48, of, over, 7,000, results, for, "java"]

        String javaSonucSayisiStr=sonucArr[3]; // 6,000
        javaSonucSayisiStr=javaSonucSayisiStr.replaceAll("\\W",""); // 6000
        int sonucSayisiInt=Integer.parseInt(javaSonucSayisiStr);
        softAssert.assertTrue(sonucSayisiInt>1000,"java icin arama sonuc sayisi 1000'den fazla degil");


        softAssert.assertAll();
        Driver.closeDriver();
    }
}
