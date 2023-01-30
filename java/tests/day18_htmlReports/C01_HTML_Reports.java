package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_Reports extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest=extentReports.createTest("nutella arama testi","kullanici nutella arayabilmeli");
        // amazon'a git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon ana sayfaya gidildi");

        // nutella aratalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        extentTest.info("arama kutusuna nutella yazilip arama yapildi");

        // sonuclarin nutella icerdigini test edelim
        String actualSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        String expectedKeline="kutella";
        extentTest.info("arama sonuclari kaydedildi");

        Assert.assertTrue(actualSonucYazisi.contains(expectedKeline));
        extentTest.pass("arama sonuclarinin nutella icerdigi test edildi");
    }
}
