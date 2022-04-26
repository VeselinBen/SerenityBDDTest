package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pageobject.SearchPageElement;

public class StepsDefinition extends SearchPageElement {

//    String coinXPath = "//*[@id=\"__next\"]//table/tbody/tr["+(int)Math.floor(Math.random()*(100-1+1)+1)+"]//button";
//    String baseUrl = "https://coinmarketcap.com/";
//    @Given("I navigate to CoinMarketcap web page")
//    public void iNavigateToCoinMarketcapWebPage() {
//        getDriver().get(baseUrl);
//    }
//
//    @Given("I navigate to view all coins")
//    public void iNavigateToViewAllCoins() {
//        viewAll.waitForCondition();
//        viewAll.click();
//    }
//
//    @When("I select one coin from {int} to {int} on list")
//    public void iSelectOneCoinFromToOnList(int fromNum, int toNum) {
//        int random_int = (int)Math.floor(Math.random()*(fromNum-toNum+1)+toNum);
//
//        for (int i = 0; i < random_int; i++) {
//            waitForAnyRenderedElementOf(By.xpath(coinXPath));
//            getDriver().findElement(By.xpath(coinXPath)).click();
//            iNavigateToViewAllCoins();
//        }
//
//    }
//
//    @Then("I will change data range to display last {int} days")
//    public void iWillChangeDataRangeToDisplayLastDays(int days7) {
//    }


}
