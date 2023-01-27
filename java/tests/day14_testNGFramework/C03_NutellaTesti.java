package tests.day14_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_NutellaTesti {
    // amazon sayfasina gidin
    // nutella icin arma yapin
    // sonuclarin nutella icerdigini test edin

    @Test
    public void test01(){
        // amazon sayfasina gidin
        Driver.getDriver().get("https://www.amazon.com");

        // nutella icin arma yapin
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        // sonuclarin nutella icerdigini test edin
        WebElement aramaSonucElementi=Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="nutella";
        String actualAramaSonucu=aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

        Driver.closeDriver();
    }
}
