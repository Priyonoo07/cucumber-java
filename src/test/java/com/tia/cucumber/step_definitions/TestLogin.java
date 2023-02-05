package com.tia.cucumber.step_definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.tia.cucumber.pages.LoginPage;
import com.tia.cucumber.utils.Constants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogin {

	private static WebDriver driver;
	private static ExtentTest extentTest;
    private LoginPage loginPage = new LoginPage();

    public TestLogin() {
    	driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }
    
    @When("User go to Website")
    public void user_go_to_Website() {
        driver.get(Constants.baseUrl+Constants.pathLogin);
        extentTest.log(LogStatus.PASS, "User go to Website");
    }

    @And("User enter username")
    public void user_enter_username() {
        loginPage.inputUsername(Constants.username);
        extentTest.log(LogStatus.PASS, "User enter username");
    }
    
    @And("User enter password")
    public void user_enter_password() {
        loginPage.inputPassword(Constants.password);
        extentTest.log(LogStatus.PASS, "User enter password");
    }

    @And("User click remember me")
    public void user_click_remember_me() {
        loginPage.clickRememberMe();
        extentTest.log(LogStatus.PASS, "User click remember me");
    }
    
    @And("User click button login")
    public void user_click_button_login() {
        loginPage.clickBtnLogin();
        extentTest.log(LogStatus.PASS, "User click button login");
    }

    @Then("User valid credentials")
    public void user_invalid_credentials() {
        Assert.assertEquals(loginPage.getTextValidationLogin(),Constants.expectedLogin);
        extentTest.log(LogStatus.PASS, "User valid credentials");
    }
    
}
