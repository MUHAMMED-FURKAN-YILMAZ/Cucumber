package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.US_0008_Home_Page;
import pages.US_0008_Sign_In_Page;
import pages.US_0008_User_Password_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0008_StepDefinitions {

    US_0008_Home_Page home_Page=new US_0008_Home_Page();
    US_0008_Sign_In_Page sign_in_page=new US_0008_Sign_In_Page();
    US_0008_User_Password_Page password_page= new US_0008_User_Password_Page();


    @When("User goes to GMIBank page")
    public void user_goes_to_gmi_bank_page() {
        Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));
    }

    @Then("User click menuIcon")
    public void userClickMenuIcon() {
        home_Page.menuIcon.click();
    }

    @And("User click signInButton")
    public void userClickSignInButton() {

        home_Page.menuIcon_SignInLink.click();
    }

    @And("User enter the valid username")
    public void userEnterTheValidUsername() {
        sign_in_page.usernameTextBox.sendKeys(ConfigReader.getProperty("CurrentValidUsername"));
    }

    @And("User enter the valid password")
    public void userEnterTheValidPassword() {
        sign_in_page.passwordTextBox.sendKeys(ConfigReader.getProperty("CurrentValidPassword"));
    }

    @And("User click the Sign in button")
    public void userClickTheSignInButton() {
        sign_in_page.signInButton.click();
    }

    @And("User click password icon")
    public void userClickPasswordIcon() {
        home_Page.menuIcon_PasswordLink.click();
    }

    @And("User click current password and enter current password")
    public void userClickCurrentPasswordAndEnterCurrentPassword() {
        password_page.currentPassword_TextBox.sendKeys(ConfigReader.getProperty("CurrentValidPassword"));
    }

    @And("User click new password and enter current password")
    public void userClickNewPasswordAndEnterCurrentPassword() {
        password_page.newPassword_TextBox.sendKeys(ConfigReader.getProperty("CurrentValidPassword"));
    }

    @And("User click new password confirmation and enter current password")
    public void userClickNewPasswordConfirmationAndEnterCurrentPassword() {
        password_page.confirmPassword_TextBox.sendKeys(ConfigReader.getProperty("CurrentValidPassword"));
    }

    @And("User click save button")
    public void userClickSaveButton() {
        password_page.saveButton.click();
    }

    @And("User sees not saved message")
    public void userSeesNotSavedMessage() {


    }

    @And("User click new password and user enter new password")
    public void userClickNewPasswordAndUserEnterNewPassword() {
        password_page.newPassword_TextBox.sendKeys(ConfigReader.getProperty("ValidNewPassword"));
    }

    @And("User click new password and user enter {string}")
    public void userClickNewPasswordAndUserEnter(String password) {
        password_page.newPassword_TextBox.sendKeys(password);
    }

    @And("User sees password strength on the {string} bar")
    public void userSeesPasswordStrengthOnTheBar(String level) {

        Assert.assertEquals(ConfigReader.getProperty("passwordStrength"+level), password_page.firstBar.getAttribute("style"));

        Assert.assertEquals(Integer.parseInt(level),password_page.passwordStrength(level).size());
    }

    @Then("User sign out to website")
    public void userSignOutToWebsite(){
        home_Page.menuIcon.click();
        home_Page.menuIcon_SignOutLink.click();
        Driver.closeDriver();
    }



}
