package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderIleNegatifLoginTesti {
    // Qualitydemy anasayfaya gidin
    // verilen yanlis kullanici adi ve password kombinasyonlari icin
    // giris yapilamadigini test edin
    // username     password
    // A11          A12345
    // B12          B12345
    // C13          C12345
    // D14          D12345
    // E15          E12345
    @DataProvider
    public static Object[][] kullaniciBilgileri() {
        Object [][] kullaniciBilgileriArr={{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"},{"E15","E12345"}};

        return kullaniciBilgileriArr;
    }

    @Test (dataProvider = "kullaniciBilgileri")
    public void negatifLoginTest(String username, String password){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.loginLink.click();

        qualitydemyPage.emailBox.sendKeys(username);
        qualitydemyPage.passwordBox.sendKeys(password + Keys.ENTER);


        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
    }
}
