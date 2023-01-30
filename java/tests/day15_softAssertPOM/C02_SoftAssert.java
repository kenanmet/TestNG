package tests.day15_softAssertPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C02_SoftAssert {
    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Online banking menusu icinde Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
    // (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
    // (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
    // (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

    @Test (groups = "smoke")
    public void test01(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage=new ZeroWebAppPage();
        zeroWebAppPage.signInButton.click();

        // 3. Login kutusuna “username” yazin
        zeroWebAppPage.loginBox.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        zeroWebAppPage.passwordBox.sendKeys("password");

        // 5. Sign in tusuna basin
        zeroWebAppPage.submitButton.click();

        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().navigate().back();
        zeroWebAppPage.onlineBanking.click();
        zeroWebAppPage.payBills.click();

        // 7. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.purchaseFCButton.click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroWebAppPage.currencyDropdown);
        select.selectByVisibleText("Eurozone (euro)");

        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualDropdownSelect=select.getFirstSelectedOption().getText();
        String expectedDropdownSelect="Eurozone (euro)";
        softAssert.assertEquals(actualDropdownSelect,expectedDropdownSelect,"Eurozone select failed");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement>optionsElementList=select.getOptions();
        List<String>actualOptionsListStr=new ArrayList<>();

        for (WebElement each:optionsElementList
             ) {
            actualOptionsListStr.add(each.getText());
        }
        String[] arr={"Select One", "Australia (dollar)", "Canada (dollar)",
                "Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)"
                ,"Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)"
                ,"Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)"
                ,"Thailand (baht)"};
        List<String>expectedOptionsList= Arrays.asList(arr);

        Collections.sort(actualOptionsListStr);
        Collections.sort(expectedOptionsList);

        softAssert.assertEquals(actualOptionsListStr,expectedOptionsList);

        ReusableMethods.bekle(3);
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
