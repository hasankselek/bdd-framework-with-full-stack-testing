package base;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utils.RequestBuilder;

import java.util.HashMap;

public abstract class BaseTest {

    protected static JsonPath repJP;
    protected static Response response;
    protected static HashMap map;
    protected static JSONObject requestBody;
    protected RequestBuilder builder;
    protected static Faker faker;

    public BaseTest() {
        builder = new RequestBuilder();
        requestBody = new JSONObject();
        map = new HashMap<>();
        faker = new Faker();
    }
}