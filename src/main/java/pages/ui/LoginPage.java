package pages.ui;

import base.BasePage;
import context.TestContext;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigurationReader;

@Slf4j
public class LoginPage extends BasePage {

    @FindBy(css = "div[class='signup-form'] h2")
    private WebElement newUserSignupText;

    @FindBy(css = "input[placeholder='Name']")
    private WebElement nameBox;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement emailBox;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signUpButton;

    public String newUserSignupText(){
        return getText(newUserSignupText);
    }

    public void clickSignup(){
        click(signUpButton);
    }

    public void fillNameEmailBoxes(String name) {
        String fakeEmail = faker.internet().emailAddress();
        sendKeys(nameBox,name);
        log.info("Name: {}",name);
        ConfigurationReader.set("name",name);
        ConfigurationReader.set("email",fakeEmail);
        sendKeys(emailBox,fakeEmail);
        log.info("Email: {}",fakeEmail);
    }
}
