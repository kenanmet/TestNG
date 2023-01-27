package tests.day15_softAssertPOM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C04_NegativeLoginTesti {
    // 3 test method'u olusturun
    // 1.de yanlıs mail, dogru sifre
    // 2.de dogru mail, yanlıs sifre
    // 3.de yanlıs mail, yanlıs sifre giris yapmayı deneyin
    // giris yapilamadigini test edin.

    QualitydemyPage qualitydemyPage=new QualitydemyPage();
    @Test
    public void wrongMailTest(){
        Driver.getDriver().get("https://qa.qualitydemy.com/");
        qualitydemyPage.loginLink.click();
        qualitydemyPage.emailBox.sendKeys("ali@ali.com");
        qualitydemyPage.passwordBox.sendKeys("12345Yuh."+ Keys.ENTER);

        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void wrongPasswordTest(){
        qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get("https://qa.qualitydemy.com/");
        qualitydemyPage.loginLink.click();
        qualitydemyPage.emailBox.sendKeys("rkah1381@gmail.com");
        qualitydemyPage.passwordBox.sendKeys("123456"+ Keys.ENTER);

        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void wrongMailWrongPwTest(){
        qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get("https://qa.qualitydemy.com/");
        qualitydemyPage.loginLink.click();
        qualitydemyPage.emailBox.sendKeys("ali@ali.com");
        qualitydemyPage.passwordBox.sendKeys("123456"+ Keys.ENTER);

        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }

}
