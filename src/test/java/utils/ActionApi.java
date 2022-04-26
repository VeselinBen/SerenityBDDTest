package utils;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.ApiConnector;
import models.Platform;
import models.ResponceBody;
import models.data.ResponseBodyConvertor;
import net.serenitybdd.core.Serenity;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static javax.lang.model.element.ElementKind.ENUM;

public class ActionApi {

    ApiConnector apiConnector = new ApiConnector();

    public void connector(SessionEnums ENUM) {
        RequestSpecification apiRequestSpecification = apiConnector.requestSpecification();
        Serenity.setSessionVariable(ENUM).to(apiRequestSpecification);
    }

    public void getResponceFromCoinMarketCap(SessionEnums RESPONSE_METHOD, SessionEnums CONNECTION, String coin) throws JSONException {
        Response response = apiConnector.sendGetRequest(coin);
        Serenity.setSessionVariable(RESPONSE_METHOD).to(response);

        ResponceBody responseBody = response.as(ResponceBody.class);
        System.out.println(responseBody.toString());

    }

    public void getPriceOfCoinInBs(SessionEnums RESPONSE_METHOD, String coin) throws JSONException {
        Response response = Serenity.sessionVariableCalled(RESPONSE_METHOD);

        JSONObject object = new JSONObject(response.asPrettyString());
        int idCoin = object.getJSONArray("data").getJSONObject(0).getInt("id");

        Serenity.setSessionVariable(coin).to(idCoin);

    }

    public void convertCoinInBs(String coin) throws JSONException {
        int idCoin = Serenity.sessionVariableCalled(coin);
        Response responsePrice = apiConnector.sendGetRequestForConvertor(idCoin);
        Serenity.setSessionVariable(coin).to(responsePrice);

        JSONObject object1 = new JSONObject(responsePrice.asPrettyString());
        double price = object1.getJSONObject("data").getJSONObject("quote").getJSONObject("BOB").getDouble("price");
        System.out.println("Price of 10.43 " + coin + " in Bolivian Bolivano is " + Math.floor(price));
    }

    /////////////////////////////////////

    public void makeConnection(SessionEnums RESPONSE_COIN) throws JSONException {
        Response ethResponse = apiConnector.sendGetRequestForInfo(1027);
        JSONObject ethObject = new JSONObject(ethResponse.asPrettyString());
        Serenity.setSessionVariable(RESPONSE_COIN).to(ethObject);
    }

    public void confirmingInfoOfEth(SessionEnums RESPONSE_COIN, String logo1, String git1) throws JSONException {

        JSONObject ethObject = Serenity.sessionVariableCalled(RESPONSE_COIN);

        String logo = ethObject.getJSONObject("data").getJSONObject("1027").getString("logo");
        System.out.println(logo);
        Assert.assertEquals(logo, logo1);

        String tehnicalDoc = (String) ethObject.getJSONObject("data").getJSONObject("1027").getJSONObject("urls").getJSONArray("technical_doc").get(0);
        System.out.println(tehnicalDoc);
        Assert.assertEquals(tehnicalDoc, git1);

    }

    public void confirmingInfoOfEth1(SessionEnums RESPONSE_COIN, String symbol1, String date) throws JSONException {

        JSONObject ethObject = Serenity.sessionVariableCalled(RESPONSE_COIN);

        String symbol = ethObject.getJSONObject("data").getJSONObject("1027").getString("symbol");
        System.out.println(symbol);
        Assert.assertEquals(symbol, symbol1);

        String dateAdded = ethObject.getJSONObject("data").getJSONObject("1027").getString("date_added");
        System.out.println(dateAdded);
        Assert.assertEquals(dateAdded, date);
    }

    public void confirmingInfoOfEth2(SessionEnums RESPONSE_COIN, String tag) throws JSONException {

        JSONObject ethObject = Serenity.sessionVariableCalled(RESPONSE_COIN);

        String platform = ethObject.getJSONObject("data").getJSONObject("1027").getString("platform");
        Platform data = new Gson().fromJson(platform, Platform.class);

        Assert.assertNull("Has eth plaform?",data);

        String tags = ethObject.getJSONObject("data").getJSONObject("1027").getString("tags");
        System.out.println(tags);
        Assert.assertTrue(tags.contains(tag));
    }

    /////////////////////////////////

    public void makeConnectionForFirst10Coins(int numCoin) throws JSONException {
        Response responseMineble;

        for (int i = 1; i <= numCoin; i++){
            responseMineble = apiConnector.sendGetRequestForInfo(i);
            JSONObject jsonCoin = new JSONObject(responseMineble.asPrettyString());

            Serenity.setSessionVariable(ENUM).to(jsonCoin);

            if(i < 10) {
                firs10CoinsInfo(i);
                writeNameOfCoins(i);
            }
            else {
                continue;
            }

        }
    }

    public void firs10CoinsInfo(int row) throws JSONException {
        JSONObject jsonCoin = Serenity.sessionVariableCalled(ENUM);

        String tags = jsonCoin.getJSONObject("data").getJSONObject(String.valueOf(row)).getString("tags");
        String tagsActual = "mineable";
        Assert.assertTrue(tags.contains(tagsActual));

    }

    public void writeNameOfCoins(int row) throws JSONException {
        JSONObject jsonCoin = Serenity.sessionVariableCalled(ENUM);

        int id = jsonCoin.getJSONObject("data").getJSONObject(String.valueOf(row)).getInt("id");
        String name = jsonCoin.getJSONObject("data").getJSONObject(String.valueOf(row)).getString("name");
        String tags = jsonCoin.getJSONObject("data").getJSONObject(String.valueOf(row)).getString("tags");
        String tagsActual = "mineable";
        boolean mineable;
        if(tags.contains(tagsActual)){
            mineable = true;
        }
        else {
            mineable = false;
        }
        System.out.println("ID "+id);
        System.out.println("Name "+name);
        System.out.println("Mineable "+mineable);
    }




}
