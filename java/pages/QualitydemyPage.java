package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualitydemyPage {

    public QualitydemyPage(){PageFactory.initElements(Driver.getDriver(),this);}

    // Log in Page
    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement loginLink;

    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement acceptCookie;

    @FindBy(linkText = "My courses")
    public WebElement myCourse;
///
    @FindBy(xpath = "//div[@class='instructor-box menu-icon-box']")
    public WebElement myCourseLink;

    @FindBy(id = "cancel_rating_btn_1")
    public WebElement editRating;

    @FindBy(xpath = "//i[@class='fas fa-star filled']")
    public WebElement star;
}
