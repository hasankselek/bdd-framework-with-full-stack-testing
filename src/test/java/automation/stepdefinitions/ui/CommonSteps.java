package automation.stepdefinitions.ui;

import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ui.LoginPage;
import pages.ui.RegisterPage;

import static org.testng.AssertJUnit.*;

@Slf4j
public class CommonSteps {


    private final LoginPage loginPage;
    private final RegisterPage registerPage;

    public CommonSteps() {
        this.loginPage = new LoginPage();
        this.registerPage = new RegisterPage();
    }

    @When("The user should see {string} text")
    public void the_user_should_see_text(String expectedText) {

            try {
                String actualText = null;

                log.info("Verifying expected text: {}", expectedText);

                if (expectedText.equals("New User Signup!")) {
                    actualText = loginPage.newUserSignupText();
                }
                else if (expectedText.equals("ENTER ACCOUNT INFORMATION")) {
                    actualText = registerPage.registerPageText();
                }
                else {
                    log.warn("Unexpected expectedText value: {}", expectedText);
                    return;
                }

                log.info("Comparing expected vs actual text: Expected = '{}', Actual = '{}'", expectedText, actualText);
                assertEquals(expectedText, actualText);

                log.info("Expected text verified successfully!");

            } catch (Exception e) {
                log.error("Error occurred while verifying text: {}", e.getMessage(), e);
            }
        }
}
