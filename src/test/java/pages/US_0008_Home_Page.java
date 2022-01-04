package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_0008_Home_Page {

    public US_0008_Home_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (id = "account-menu")
    public WebElement menuIcon;

    @FindBy (id = "login-item")
    public WebElement menuIcon_SignInLink;

    @FindBy (xpath = "//span[text()='User Info']")
    public WebElement menuIcon_UserInfoLink;

    @FindBy (xpath = "//span[text()='Password']")
    public WebElement menuIcon_PasswordLink;

    @FindBy (xpath = "//span[text()='Sign out']")
    public WebElement menuIcon_SignOutLink;


    @FindBy (id = "entity-menu")
    public WebElement menuMyOperation;


}
