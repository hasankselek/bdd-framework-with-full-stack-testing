package utils;

import java.util.HashMap;

public class TestData {

    HashMap<String, HashMap<String, Object>> reqBody = new HashMap<>();

    public HashMap hubRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("name", "Test Hub");
        requestBody.put("phone", "01000000004");
        requestBody.put("address", "Houston, Texas");

        return requestBody;
    }

    public HashMap requestBody(String folder) {

        reqBody.put("hub", hubRequestBody());

        return reqBody.get(folder);
    }

    public HashMap blogRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();


        requestBody.put("title", "Marhabalar");
        requestBody.put("description", "Postman Asrina Hos Geldiniz");
        requestBody.put("position",12);

        return requestBody;
    }

    public HashMap deliverymanRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("name", "cimen.deliveryman");
        requestBody.put("mobile", "51515951595");
        requestBody.put("email", "cimeno.deliveryman@agileswiftcargo.com");
        requestBody.put("address", "W");
        requestBody.put("delivery_charge", "0.00");
        requestBody.put("pickup_charge", "0.00");
        requestBody.put("return_charge", "0.00");


        return requestBody;
    }

    public HashMap merchantShopRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("", "");

        return requestBody;
    }

    public HashMap merchantRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("name","Ali" );
        requestBody .put("business_name","PARIS AS" );
        requestBody.put("mobile","123456789" );

        return requestBody;
    }

    public HashMap parcelRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("", "");

        return requestBody;
    }



    public HashMap supportRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("", "");

        return requestBody;
    }


    public HashMap<String, Object> regularRequestBody(String folder1) {
        HashMap<String, Object> regularRequestBody = new HashMap<>();
        regularRequestBody.put("note", "Hızlı ve Guvenilir teslimatin tek adresi");
        regularRequestBody.put("parcel_quantity", 17);


        return regularRequestBody;
    }

    public HashMap requestRegularBody(String folder1) {

        reqBody.put("pickuprequest", regularRequestBody(folder1));

        return reqBody.get(folder1);
    }


}
