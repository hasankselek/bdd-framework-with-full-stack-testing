package automation.stepdefinitions.ui;

import io.cucumber.java.en.*;
import pages.ui.HomePage;

public class HomePageStepDef {

    private final HomePage homePage;

    public HomePageStepDef() {this.homePage = new HomePage();}

    @Given("The user navigate to {string} website")
    public void the_user_navigate_to_website(String url) {
        homePage.navigateToUrl(url);
    }
    @Then("The user should see the home page")
    public void the_user_should_see_the_home_page() {

        homePage.assertHomePage();
    }
}
