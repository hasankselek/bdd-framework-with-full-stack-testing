package automation.stepdefinitions.api;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.api.API_Common;
import utils.API_Methods;
import utils.ConfigurationReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiSteps extends BaseTest {

    API_Common apiCommon = new API_Common();
    public static String requestBody;

    @Given("I set the base API URL")
    public void ı_set_the_base_apı_url() {

        RestAssured.baseURI = "https://automationexercise.com/api";
    }

    @Given("The api user sends a {string} request to {string} endpoint")
    public void the_api_user_sends_a_request_and_saves_the_returned_response(String httpMethod, String endpoint) {

        if (requestBody == null || requestBody.isEmpty()) {
            API_Methods.sendRequest(httpMethod, null, endpoint);
        } else {
            API_Methods.sendRequest(httpMethod, requestBody, endpoint);
        }
    }

    @Given("The api user verifies that the status code is {int}.")
    public void the_api_user_verifies_that_the_status_code_is(int code) {

        API_Methods.statusCodeAssert(code);
    }


    @Given("The api user verifies that the {string} information in the response body is {string}.")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is(String key, String value) {

        API_Methods.assertBody(key, value);
    }

    @Then("The api user verifies response should contain {string} array")
    public void the_response_should_contain_array(String arrayField) {

        API_Methods.assertContainArray(arrayField);
    }

    @When("The api user sends a POST request to {string} endpoint with search query:")
    public void theApiUserSendsARequestToEndpointWithSearchQuery(String endpoint, DataTable dataTable) {

        apiCommon.postSearchProduct(endpoint, dataTable);
    }

    @When("The api user sends a POST request to {string} endpoint without search query:")
    public void theApiUserSendsAPOSTRequestToEndpointWithoutSearchQuery(String endpoint) {

        apiCommon.postSearchProductWithoutSearchProduct(endpoint);
    }

    @When("The api user sends a POST request to {string} endpoint with credentials:")
    public void theApiUserSendsAPOSTRequestToEndpointWithCredentials(String endpoint, DataTable dataTable) {

        apiCommon.postVerifyLoginInvalidInformation(endpoint, dataTable);
    }

    @When("The api user sends a POST request to {string} endpoint without email credentials:")
    public void theApiUserSendsAPOSTRequestToEndpointWithoutEmailCredentials(String endpoint, DataTable dataTable) {

        apiCommon.postVerifyWithoutEmail(endpoint, dataTable);
    }


    @When("The api user sends a POST request to {string} endpoint with user information:")
    public void theApiUserSendsAPOSTRequestToEndpointWithUserInformation(String endpoint, DataTable dataTable) {

        apiCommon.createUser(endpoint, dataTable);
    }


    @When("The api user sends a DELETE request to {string} endpoint")
    public void theApiUserSendsADELETERequestToEndpoint(String endpoint) {

        apiCommon.deleteVerifyLogin(endpoint);
    }

    @When("The api user sends a DELETE request to {string} endpoint with user information:")
    public void theApiUserSendsADELETERequestToEndpointWithUserInformation(String endpoint) {

        apiCommon.deleteUserAccount(endpoint);
    }

    @When("The api user sends a PUT request to {string} endpoint update with user information:")
    public void theApiUserSendsAPUTRequestToEndpointUpdateWithUserInformation(String endpoint, DataTable dataTable) {

        apiCommon.putUpdateUserAccount(endpoint, dataTable);
    }

    @When("The api user sends a GET request to {string} endpoint with email")
    public void theApiUserSendsAGETRequestToEndpointWithEmail(String endpoint) {

        apiCommon.getUserAccountDetail(endpoint);
    }

    @And("The api user validate username")
    public void theApiUserValidateUsername() {

        apiCommon.validateUsername();
    }

    @When("The api user sends a POST request to {string} endpoint with valid credentials:")
    public void theApiUserSendsAPOSTRequestToEndpointWithValidCredentials(String endpoint) {

        apiCommon.postVerifyLoginWithValidInfo(endpoint);
    }
}
