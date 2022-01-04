package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_0008_Sign_In_Page {

    public US_0008_Sign_In_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id ="username")
    public WebElement usernameTextBox;

    @FindBy (id ="password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[text()='Cancel']")
    public WebElement cancelButton;


}
