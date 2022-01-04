package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_0008_User_Password_Page {

    public US_0008_User_Password_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "currentPassword")
    public WebElement currentPassword_TextBox;

    @FindBy (id = "newPassword")
    public WebElement newPassword_TextBox;

    @FindBy (id = "confirmPassword")
    public WebElement confirmPassword_TextBox;

    @FindBy (xpath = "(//li[@class='point'])[1]")
    public WebElement firstBar;

    @FindBy (xpath = "//li[@style='background-color: rgb(255, 0, 0);']")
    public List<WebElement> passwordStrength1;

    @FindBy (xpath = "//li[@style='background-color: rgb(255, 153, 0);']")
    public List<WebElement> passwordStrength2;

    @FindBy (xpath = "//li[@style='background-color: rgb(255, 255, 0);']")
    public List<WebElement> passwordStrength3;

    @FindBy (xpath = "//li[@style='background-color: rgb(153, 255, 0);']")
    public List<WebElement> passwordStrength4;

    @FindBy (xpath = "//li[@style='background-color: rgb(0, 255, 0);']")
    public List<WebElement> passwordStrength5;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement saveButton;


    public List<WebElement> passwordStrength(String level) {
        if (level.equals("1")){
            return passwordStrength1;
        }
        else if (level.equals("2")){
            return passwordStrength2;
        }
        else if (level.equals("3")){
            return passwordStrength3;
        }
        else if (level.equals("4")){
            return passwordStrength4;
        }
        else if (level.equals("5")){
            return passwordStrength5;
        }
        else {
            return null;
        }
    }


}
