package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US3001_Page;

public class US3001_StepDefinitions {
    US3001_Page us3001_page = new US3001_Page();

    @Then("gmibank giris butonuna tiklar")
    public void gmibankGirisButonunaTiklar() {
        us3001_page.ilkGirisButonu.click();
    }

    @Then("gmibank register butonuna tiklar")
    public void gmibankRegisterButonunaTiklar() {
        us3001_page.registerButonu.click();
    }

    @And("gmibank password kutusuna tiklar")
    public void gmibankPasswordKutusunaTiklar() {
        us3001_page.passwordKutusu.click();
    }

    @Given("{string} girer")
    public void girer(String password) throws InterruptedException {
        us3001_page.passwordKutusu.sendKeys(password);
        Thread.sleep(2000);
    }

    @Then("gmibank Password strength red gorunur")
    public void gmibankPasswordStrengthRedGorunur() {
        Assert.assertTrue(us3001_page.red.isDisplayed());
    }

    @Then("gmibank Password strength orange gorunur")
    public void gmibankPasswordStrengthOrangeGorunur() {
        Assert.assertTrue(us3001_page.orange.isDisplayed());
    }

    @Then("gmibank Password strength yellow gorunur")
    public void gmibankPasswordStrengthYellowGorunur() {
        Assert.assertTrue(us3001_page.yellow.isDisplayed());
    }

    @Then("gmibank Password strength lightgreen gorunur")
    public void gmibankPasswordStrengthLightgreenGorunur() {
        Assert.assertTrue(us3001_page.lightgreen.isDisplayed());
    }

    @Then("gmibank Password strength green gorunur")
    public void gmibankPasswordStrengthGreenGorunur() {
        Assert.assertTrue(us3001_page.green.isDisplayed());
    }
}