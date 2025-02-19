package automation.stepdefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ui.HomePage;
import pages.ui.LoginPage;

public class LoginPageSteps {

    private final LoginPage loginPage;

    public LoginPageSteps() {this.loginPage = new LoginPage();}

    @When("The user enter name {string} and  email for registration")
    public void the_user_enter_name_and_email_for_registration(String name) {

        loginPage.fillNameEmailBoxes(name);
    }

    @And("The user clicks signup button")
    public void theUserClicksSignupButton() {

        loginPage.clickSignup();
    }
}
