package pages.ui;

import base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@Slf4j
public class HomePage extends BasePage {

    @FindBy(css = "a[href='/login']")
    private WebElement signUpLoginButton;

    public void assertHomePage() {
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
            log.info("Correct URL: {}", "https://automationexercise.com/");
        } catch (Exception e) {
            log.error("Wrong URL: {}", e.getMessage());
            throw e;
        }
    }

    public void clickSignUpLoginButton(){
        click(signUpLoginButton);
    }
}
