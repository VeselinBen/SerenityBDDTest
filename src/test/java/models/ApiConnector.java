package models;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import models.data.ResponseBodyConvertor;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;

public class ApiConnector {

    public static final String GET_FOR_ID = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map?CMC_PRO_API_KEY=3117d193-48a5-416f-b2c2-60dcdd46f269";
    public static final String CONVERTING = "https://pro-api.coinmarketcap.com/v2/tools/price-conversion?CMC_PRO_API_KEY=3117d193-48a5-416f-b2c2-60dcdd46f269&amount=10.43&convert=BOB";
    public static final String INFO_ETH = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/info?CMC_PRO_API_KEY=3117d193-48a5-416f-b2c2-60dcdd46f269&id=";

    public RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
//                .setContentType("application/x-www-form-urlencoded;charset=UTF-8")
                .setBaseUri(GET_FOR_ID)
                .build();
    }

//    public RequestSpecification requestSpecificationForConverting() {
//        return new RequestSpecBuilder()
//                .setContentType("application/x-www-form-urlencoded;charset=UTF-8")
//                .setBaseUri(CONVERTING)
//                .build();
//    }

    public Response sendGetRequest(String coinCripto) {
        return SerenityRest.given()
//                .spec(requestSpecification)
                .when()
                .get(GET_FOR_ID+"&symbol="+coinCripto).prettyPeek()
                .thenReturn();
    }

    public Response sendGetRequestForConvertor(int id) {

        return SerenityRest.given()
//                .spec(requestSpecification)
                .when()
                .get(CONVERTING+"&id="+id)
                .thenReturn();
    }

    public Response sendGetRequestForInfo(int idCoin) {
        return SerenityRest.given()
//                .spec(requestSpecification)
                .when()
                .get(INFO_ETH+idCoin)
                .thenReturn();
    }

//    public ResponseBodyConvertor sendGetRequestForConvertor(RequestSpecification requestSpecification) {
//        return SerenityRest.given()
////                .spec(requestSpecification)
//                .when()
//                .get(CONVERTING)
//                .as(ResponseBodyConvertor.class);
//    }

/*    public Response sendPostRequest(RequestSpecification requestSpecification, JsonObject json) {
        return SerenityRest.given().
                contentType(ContentType.JSON)
                .spec(requestSpecification)
                .body(json)
                .when()
                .post()
                .thenReturn();
    }

    public Response sendPutRequest(RequestSpecification requestSpecification, JsonObject json) {
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .spec(requestSpecification)
                .body(json)
                .when()
                .put(PUT).prettyPeek()
                .thenReturn();
    }

    public Response sendDeleteRequest(RequestSpecification requestSpecification) {
        return SerenityRest.given()
                .spec(requestSpecification)
                .when()
                .delete(DELETE)
                .thenReturn();
    }*/


}
