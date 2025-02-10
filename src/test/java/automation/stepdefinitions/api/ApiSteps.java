package automation.stepdefinitions.api;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utils.API_Methods;
import utils.ConfigurationReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiSteps extends BaseTest {

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
        Map<String, String> searchData = dataTable.asMap(String.class, String.class);
        response = given().formParam("search_product", searchData.get("search_product")).when().post(endpoint);
    }

    @When("The api user sends a POST request to {string} endpoint without search query:")
    public void theApiUserSendsAPOSTRequestToEndpointWithoutSearchQuery(String endpoint) {
        response = given().contentType("application/json").when().post(endpoint);
    }

    @When("The api user sends a POST request to {string} endpoint with credentials:")
    public void theApiUserSendsAPOSTRequestToEndpointWithCredentials(String endpoint, DataTable dataTable) {
        Map<String, String> credentialsData = dataTable.asMap(String.class, String.class);
        response = given()
                .formParam("email", credentialsData.get("email"))
                .formParam("password", credentialsData.get("password"))
                .when()
                .post(endpoint);
    }

    @When("The api user sends a POST request to {string} endpoint without email credentials:")
    public void theApiUserSendsAPOSTRequestToEndpointWithoutEmailCredentials(String endpoint, DataTable dataTable) {

        Map<String, String> credentialsData = dataTable.asMap(String.class, String.class);
        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .multiPart("password", credentialsData.get("password"))
                .when()
                .post(endpoint);
    }


    @When("The api user sends a POST request to {string} endpoint with user information:")
    public void theApiUserSendsAPOSTRequestToEndpointWithUserInformation(String endpoint, DataTable dataTable) {

        ConfigurationReader.set("userName", faker.name().firstName());
        ConfigurationReader.set("email", faker.internet().emailAddress());
        ConfigurationReader.set("password", "Ac!2" + faker.internet().password());

        Map<String, String> userInformation = dataTable.asMap(String.class, String.class);

        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("name", ConfigurationReader.get("userName"))
                .multiPart("email", ConfigurationReader.get("email"))
                .multiPart("password", ConfigurationReader.get("password"));

        // Map içindeki tüm verileri tek seferde multiPart'a ekleyelim
        userInformation.forEach(request::multiPart);

        response = request.when().post(endpoint);
    }


    @When("The api user sends a DELETE request to {string} endpoint")
    public void theApiUserSendsADELETERequestToEndpoint(String endpoint) {

        response = given().contentType("application/json").when().delete(endpoint);
    }

    @When("The api user sends a DELETE request to {string} endpoint with user information:")
    public void theApiUserSendsADELETERequestToEndpointWithUserInformation(String endpoint) {
        response = RestAssured.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("email", ConfigurationReader.get("email"))
                .multiPart("password", ConfigurationReader.get("password"))
                .when()
                .delete(endpoint);


        //clear configurationReader
        ConfigurationReader.set("userName", "");
        ConfigurationReader.set("email", "");
        ConfigurationReader.set("password", "");


    }

    @When("The api user sends a PUT request to {string} endpoint update with user information:")
    public void theApiUserSendsAPUTRequestToEndpointUpdateWithUserInformation(String endpoint, DataTable dataTable) {

        Map<String, String> userInformation = dataTable.asMap(String.class, String.class);

        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("name", ConfigurationReader.get("userName"))
                .multiPart("email", ConfigurationReader.get("email"))
                .multiPart("password", ConfigurationReader.get("password"));

        // Map içindeki tüm verileri tek seferde multiPart'a ekleyelim
        userInformation.forEach(request::multiPart);

        response = request.when().put(endpoint);


    }

    @When("The api user sends a GET request to {string} endpoint with email")
    public void theApiUserSendsAGETRequestToEndpointWithEmail(String endpoint) {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("email", ConfigurationReader.get("email"))
                .when()
                .get(endpoint);
    }

    @And("The api user validate username")
    public void theApiUserValidateUsername() {

        Assert.assertEquals(ConfigurationReader.get("userName"), response.jsonPath().getString("user.name"));
    }
}
