package automation.stepdefinitions.ui;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.ui.RegisterPage;

import java.util.Map;

public class RegisterPageSteps {

    private final RegisterPage registerPage;

    public RegisterPageSteps() {this.registerPage = new RegisterPage();}

    @When("The user fill account details")
    public void the_user_fill_account_details(DataTable dataTable) {

        registerPage.fillAccountDetail(dataTable);
    }

    @And("I select newsletter subscription and special offers")
    public void iSelectNewsletterSubscriptionAndSpecialOffers() {

        registerPage.selectNewsletterOffers();
    }
}
