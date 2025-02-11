package pages.api;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utils.ConfigurationReader;

import javax.xml.crypto.Data;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_Common extends BaseTest {

    public void createUser(String endpoint, DataTable dataTable){

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

    public void deleteVerifyLogin(String endpoint){

        response = given().contentType("application/json").when().delete(endpoint);
    }

    public void getUserAccountDetail(String endpoint){
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("email", ConfigurationReader.get("email"))
                .when()
                .get(endpoint);
    }

    public void validateUsername(){
        Assert.assertEquals(ConfigurationReader.get("userName"), response.jsonPath().getString("user.name"));
    }

    public void postSearchProduct(String endpoint,DataTable dataTable){
        Map<String, String> searchData = dataTable.asMap(String.class, String.class);
        response = given().formParam("search_product", searchData.get("search_product")).when().post(endpoint);
    }

    public void postSearchProductWithoutSearchProduct(String endpoint){
        response = given().contentType("application/json").when().post(endpoint);
    }

    public void postVerifyLoginInvalidInformation(String endpoint,DataTable dataTable){
        Map<String, String> credentialsData = dataTable.asMap(String.class, String.class);
        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .multiPart("email",credentialsData.get("email"))
                .multiPart("password",credentialsData.get("password"))
                .when()
                .post(endpoint);
    }

    public void postVerifyWithoutEmail(String endpoint,DataTable dataTable){
        Map<String, String> credentialsData = dataTable.asMap(String.class, String.class);
        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .multiPart("password", credentialsData.get("password"))
                .when()
                .post(endpoint);
    }

    public void postVerifyLoginWithValidInfo(String endpoint){
        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .multiPart("email",ConfigurationReader.get("email"))
                .multiPart("password",ConfigurationReader.get("password"))
                .when()
                .post(endpoint);
    }

    public void putUpdateUserAccount(String endpoint, DataTable dataTable){
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

    public void deleteUserAccount(String endpoint){

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
}
