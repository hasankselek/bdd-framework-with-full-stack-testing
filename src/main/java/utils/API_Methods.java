package utils;

import base.BaseTest;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import static io.restassured.RestAssured.given;


public class API_Methods extends BaseTest {

    public static Response sendRequest(String httpMethod, Object requestBody, String endpoint) {

        switch (httpMethod.toUpperCase()) {
            case "GET":
                response = (requestBody != null) ? given().body(requestBody).get(endpoint)
                        : given().get(endpoint);
                break;

            case "POST":
                response = (requestBody != null) ? given().contentType("application/json").body(requestBody).post(endpoint)
                        : given().post(endpoint);
                break;

            case "PATCH":
                response = given().contentType("application/json").body(requestBody).patch(endpoint);
                break;

            case "PUT":
                response = (requestBody != null) ? given().contentType("application/json").body(requestBody).put(endpoint)
                        : given().put(endpoint);
                break;

            case "DELETE":
                response = given().delete(endpoint);
                break;

            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + httpMethod);
        }

        return response;
    }



    public static void statusCodeAssert(int statusCode) {
        response.then()
                .assertThat()
                .statusCode(statusCode);
    }

    public static void assertBody(String field, String expectedValue) {
        requestBody = new JSONObject(response.getBody().asString());
        Assert.assertEquals(requestBody.get(field).toString(), expectedValue);
    }

    public static void assertContainArray(String arrayField){
        requestBody = new JSONObject(response.getBody().asString());
        Assert.assertTrue(requestBody.has(arrayField) &&
                        !requestBody.getJSONArray(arrayField).isEmpty(),
                arrayField + " array is not present or empty");
    }

}

