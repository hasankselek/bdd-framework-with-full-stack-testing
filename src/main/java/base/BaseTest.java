package base;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.ContentType;

import java.util.HashMap;

public abstract class BaseTest {
    
    protected static Response response;
    protected static HashMap<String, Object> map;
    protected static JSONObject requestBody;
    protected static Faker faker;
    protected static RequestSpecification requestSpec;

    public BaseTest() {
        requestBody = new JSONObject();
        map = new HashMap<>();
        faker = new Faker();
    }

}