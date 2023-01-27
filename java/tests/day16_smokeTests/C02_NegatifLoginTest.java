package tests.day16_smokeTests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegatifLoginTest {
    QualitydemyPage qualitydemyPage = new QualitydemyPage();

    @Test
    public void yanlisMail() {
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.loginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdInvalidMail"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdValidPassword") + Keys.ENTER);

        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }

    @Test
    public void yanlisPassword() {
        qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.loginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdValidMail"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdInvalidPassword") + Keys.ENTER);

        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }

    @Test
    public void yanlisMailYanlisPassword() {
        qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.loginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdInvalidMail"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdInvalidPassword") + Keys.ENTER);

        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }

}
