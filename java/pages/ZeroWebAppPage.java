package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebAppPage {

    public ZeroWebAppPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//li[@id='onlineBankingMenu']")
    public WebElement onlineBanking;

    @FindBy(xpath = "//*[text()='Pay Bills']")
    public WebElement payBills;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseFCButton;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement currencyDropdown;
}
