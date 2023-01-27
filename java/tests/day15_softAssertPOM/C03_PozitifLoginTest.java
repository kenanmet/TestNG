package tests.day15_softAssertPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C03_PozitifLoginTest {
    // 1- https://www.qualitydemy.com/ anasayfasina gidin
    // 2- login linkine basin
    // 3- Kullanici email'i olarak valid email girin
    // 4- Kullanici sifresi olarak valid sifre girin
    // 5- Login butonuna basarak login olun
    // 6- Basarili olarak giris yapilabildigini test edin

    QualitydemyPage qualitydemyPage=new QualitydemyPage();
    @Test
    public void test01(){
        // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://qa.qualitydemy.com/");
        qualitydemyPage.acceptCookie.click();

        // 2- login linkine basin
        qualitydemyPage.loginLink.click();

        // 3- Kullanici email'i olarak valid email girin
        qualitydemyPage.emailBox.sendKeys("rkah1381@gmail.com");

        // 4- Kullanici sifresi olarak valid sifre girin
        qualitydemyPage.passwordBox.sendKeys("12345Yuh.");

        // 5- Login butonuna basarak login olun
        qualitydemyPage.loginButton.click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qualitydemyPage.myCourse.isDisplayed());

    /*
        List<WebElement> elements=Driver.getDriver().findElements(By.xpath("//i[@class='fas fa-star filled']"));
        int starsayisi=elements.size();
        System.out.println(starsayisi);
    */
        Driver.closeDriver();
    }
}
