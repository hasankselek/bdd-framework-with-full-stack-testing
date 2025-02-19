package pages.ui;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    private WebElement registerPageText;

    @FindBy(css = "#id_gender1")
    private WebElement idGender;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "#days")
    private WebElement daysDropdown;

    @FindBy(css = "#months")
    private WebElement monthsDropdown;

    @FindBy(css = "#years")
    private WebElement yearsDropdown;

    @FindBy(css = "#newsletter")
    private WebElement newsletter;

    @FindBy(css = "#optin")
    private WebElement offers;

    public String registerPageText(){
        return getText(registerPageText);
    }

    public void selectGender(String gender){
        if (gender.equalsIgnoreCase("Mr")) {
            click(idGender);
        }
    }

    public void enterPassword(String password){
        sendKeys(passwordInput, password);
    }

    public void selectDateOfBirth(String day, String month, String year){
        new Select(daysDropdown).selectByVisibleText(day);
        new Select(monthsDropdown).selectByVisibleText(month);
        new Select(yearsDropdown).selectByVisibleText(year);
    }

    public void selectNewsletterOffers(){
        click(newsletter);
        click(offers);
    }

    public void fillAccountDetail(DataTable dataTable){

    }
}
