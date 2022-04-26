package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import pageobject.action.Action;
import utils.ActionApi;

import static utils.SessionEnums.*;

public class StepsApi extends ActionApi {

    @Given("I send request for price of {string}")
    public void iSendRequestForPriceOf(String coin) throws JSONException {
        connector(REQUEST_SPECIFICATION);
        getResponceFromCoinMarketCap(RESPONSE_GET, REQUEST_SPECIFICATION, coin);
    }

    @When("I get price of {string}")
    public void iGetPriceOf(String coin) throws JSONException {
        getPriceOfCoinInBs(RESPONSE_GET, coin);

    }

    @Then("I will convert {string} in Bs")
    public void iWillConvertInBs(String coin) throws JSONException {
        convertCoinInBs(coin);
    }

    /////////////////////////////////////////

    @Given("I send request for info of ETH")
    public void iSendRequestForInfoOfETH() throws JSONException {
        makeConnection(ETH_INFO);
    }

    @When("I got response i will check logo {string}, tehnical doc on github {string}")
    public void iGotResponseIWillCheckLogoTehnicalDocOnGithub(String logo, String git) throws JSONException {
        confirmingInfoOfEth(ETH_INFO, logo, git);
    }

    @And("I check symbol {string} and date {string} od added coin")
    public void iCheckSymbolAndDateOdAddedCoin(String symbol, String date) throws JSONException {
        confirmingInfoOfEth1(ETH_INFO, symbol, date);
    }


    @Then("I will verify platform tag name {string}")
    public void iWillVerifyPlatformTagName(String tag) throws JSONException {
        confirmingInfoOfEth2(ETH_INFO, tag);
    }



    ////////////////////////////////

    private int numCoin;

    @Given("I send request for first {int} coins")
    public void iSendRequestForFirstCoins(int arg0) throws JSONException {
        makeConnectionForFirst10Coins(arg0);
        numCoin = arg0;
    }

    @When("I check which currency is mineable")
    public void iCheckWhichCurrencyIsMineable() throws JSONException {
        firs10CoinsInfo(numCoin);
    }

    @Then("I will verify every coin")
    public void iWillVerifyEveryCoin() throws JSONException {
        writeNameOfCoins(numCoin);
    }

}
