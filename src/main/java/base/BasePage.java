package base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ConfigurationReader;
import utils.Driver;

import java.time.Duration;

@Log4j2
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            log.info("Clicked on element: {}", element);
        } catch (Exception e) {
            log.error("Error clicking element: {}", e.getMessage());
            throw e;
        }
    }

    protected void sendKeys(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            log.info("Sent keys '{}' to element: {}", text, element);
        } catch (Exception e) {
            log.error("Error sending keys to element: {}", e.getMessage());
            throw e;
        }
    }

    protected String getText(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String text = element.getText();
            log.info("Got text '{}' from element: {}", text, element);
            return text;
        } catch (Exception e) {
            log.error("Error getting text from element: {}", e.getMessage());
            throw e;
        }
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            boolean isDisplayed = element.isDisplayed();
            log.info("Element {} is displayed: {}", element, isDisplayed);
            return isDisplayed;
        } catch (TimeoutException | NoSuchElementException e) {
            log.info("Element {} is not displayed", element);
            return false;
        }
    }

    protected void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info("Waited for element to be visible: {}", element);
        } catch (Exception e) {
            log.error("Error waiting for element visibility: {}", e.getMessage());
            throw e;
        }
    }

    protected void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            log.info("Waited for element to be clickable: {}", element);
        } catch (Exception e) {
            log.error("Error waiting for element to be clickable: {}", e.getMessage());
            throw e;
        }
    }

    public void navigateToUrl(String url) {
        try {
            driver.get(ConfigurationReader.get(url));
            log.info("Navigated to URL: {}", url);
        } catch (Exception e) {
            log.error("Error navigating to URL: {}", e.getMessage());
            throw e;
        }
    }




}
