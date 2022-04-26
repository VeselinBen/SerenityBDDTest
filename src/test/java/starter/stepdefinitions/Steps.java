package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.CoinMarketCap;
import pageobject.SearchPageElement;

public class Steps
{
    CoinMarketCap marketCap;

    @Given("I navigate to CoinMarketcap web page")
    public void iNavigateToCoinMarketcapWebPage() {
        marketCap.loadPage();
    }

//    //////////////////////

    @Given("I want to check NFTs price")
    public void iWantToCheckNFTsPrice() {
        marketCap.redirectToNFT();
    }

    @When("I comeback to Cryptocurrencies")
    public void iComebackToCryptocurrencies() {
        marketCap.redirectToCripty();
    }

    @Then("I will verify all results are displayed")
    public void iWillVerifyAllResultsAreDisplayed() {
        marketCap.verifyBtc();
    }

//    ///////////////////////

    @Given("I Select from {int} to {int} coins")
    public void iSelectFromToCoins(int from, int to) throws InterruptedException {
        marketCap.selectButtonForConins(from, to);
    }

    @When("I navigate on history data of random coin")
    public void iNavigateOnHistoryDataOfRandomCoin() throws InterruptedException {
        marketCap.redirectOn7DaysHistiry();
    }

    @And("I change data range to display last {int} days")
    public void iChangeDataRangeToDisplayLastDays(int arg0) throws InterruptedException {
        marketCap.changeHistoryDataOnLast7Days();
    }

    @Then("I will check the attributes of the coin")
    public void iWillCheckTheAttributesOfTheCoin() throws InterruptedException {
        marketCap.checkingResalt();
    }

    //////////////////////////////////////////

    @Given("I select spotlight coins")
    public void iSelectSpotlightCoins() throws InterruptedException {
        marketCap.hoverCriptoClickOnSpotlight();
    }

    @When("I navigate to most visited coins")
    public void iNavigateToMostVisitedCoins() throws InterruptedException {
        marketCap.navigateToMostVisitCoin();
    }

    @And("open most visited coins in new tab")
    public void openMostVisitedCoinsInNewTab() throws InterruptedException {
        marketCap.navigateToMostVisitCoinWithNewTab();
    }

    @Then("I verify most visited page")
    public void iVerifyMostVisitedPage() {
        marketCap.verifyMostVisitCoins();
    }
}
