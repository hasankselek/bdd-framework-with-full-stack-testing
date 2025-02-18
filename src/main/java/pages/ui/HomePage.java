package pages.ui;

import base.BasePage;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@Slf4j
public class HomePage extends BasePage {

    public void assertHomePage() {
        try {
            Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
            log.info("Correct URL: {}", "https://automationexercise.com/");
        } catch (Exception e) {
            log.error("Wrong URL: {}", e.getMessage());
            throw e;
        }
    }

}
