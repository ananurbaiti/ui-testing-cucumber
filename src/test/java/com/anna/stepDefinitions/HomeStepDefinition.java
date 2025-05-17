package com.anna.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.home.PopUpSignUp;
import utilities.AlertHandler;
import utilities.DriverManager;

import java.time.Duration;

public class HomeStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(HomeStepDefinition.class);

    private final PopUpSignUp popUpSignUp = new PopUpSignUp();

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        DriverManager.getDriver();
    }

    @When("I click on the signup link")
    public void iClickOnTheSignupLink() {
        HomePage homePage = new HomePage();
        homePage.clickSignUpLink();
    }

    // Tambahkan step tunggu popup muncul (boleh juga langsung di step input)
    @And("I wait for the signup popup to appear")
    public void iWaitForTheSignupPopupToAppear() {
        popUpSignUp.waitForSignUpPopup();
    }


    @And("I fill in the username field with {string}")
    public void iFillInTheUsernameFieldWith(String username) {
        // Tunggu popup muncul dulu sebelum input username
        popUpSignUp.waitForSignUpPopup();

        if(username.equals("randomusername")) {
            username = "jakarta" + System.currentTimeMillis();
        }
        popUpSignUp.enterUsername(username);
    }

    @And("I fill in the password field with {string}")
    public void iFillInThePasswordFieldWith(String password) {
        // Tunggu popup muncul dulu sebelum input password
        popUpSignUp.waitForSignUpPopup();

        popUpSignUp.enterPassword(password);
    }

    @And("I click on the signup button")
    public void iClickOnTheSignupButton() {
        popUpSignUp.clickSignUpButton();
    }

    @Then("I should see a message {string}")
    public void iShouldSeeAMessage(String expectedAlertMessage)  {
        AlertHandler alertHandler = new AlertHandler();
        try {
            // Tunggu alert muncul dulu maksimal 5 detik
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            String actualAlertMessage = alertHandler.getAlertText();
            logger.info("Actual alert message: {}", actualAlertMessage);
            alertHandler.acceptAlert();
            Assert.assertEquals("Alert message does not match", expectedAlertMessage, actualAlertMessage);
        } catch (Exception e) {
            logger.error("Alert tidak muncul atau error", e);
            Assert.fail("Alert tidak muncul atau error: " + e.getMessage());
        }
    }


}
