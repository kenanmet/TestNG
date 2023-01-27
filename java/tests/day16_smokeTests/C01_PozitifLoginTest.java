package tests.day16_smokeTests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PozitifLoginTest {

    @Test
    public void pozitifLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.loginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdValidMail"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdValidPassword")+ Keys.ENTER);

        ReusableMethods.bekle(3);
        Assert.assertTrue(qualitydemyPage.myCourse.isDisplayed());
        Driver.closeDriver();
    }
}
