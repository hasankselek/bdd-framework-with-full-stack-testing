package base;

import utils.ConfigLoader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utils.RequestBuilder;
import utils.TestData;

import java.util.HashMap;

public abstract class BaseTest {

    protected static ConfigLoader configLoader;
    protected static JsonPath repJP;
    protected static Response response;
    protected static HashMap map;
    protected static JSONObject requestBody;
    protected RequestBuilder builder;

    public BaseTest() {
        builder = new RequestBuilder();
        requestBody = new JSONObject();
        map = new HashMap<>();
        configLoader = new ConfigLoader();
    }
}