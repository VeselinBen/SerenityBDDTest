package pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.action.Action;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CoinMarketCap extends SearchPageElement {


    Action action;

    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public void loadPage() {
        action.connection();
    }

    public void redirectToNFT () {
        action.waitForElement(NFTButton);
        action.clickOnElement(NFTButton);
    }

    public void redirectToCripty() {
        action.waitForElement(viewAll);
        action.clickOnElement(viewAll);
    }

    public void verifyBtc(){
        Assert.assertEquals("Expected Bitcoin","Bitcoin", BTC.getText());
    }

    String expectedCoinString;
    String actualCoinString;

    public void selectButtonForConins(int from, int to) throws InterruptedException {
        int randomNumCoinsPick  = (int)Math.floor(Math.random()*(to-from+1)+from);
        System.out.println("Num 5-10 "+ randomNumCoinsPick);

        //specify the number of pixels the page has to be scrolled

        System.out.println("FindAll "+cois100p.size());

        for (int i = 0; i < randomNumCoinsPick; i++){

            for (int j = 500; j < 3000; j+=500) {
                js.executeScript("window.scrollBy(0, "+j+")");
                Thread.sleep(500);
            }

            System.out.println("FindAll 1 "+cois100p.size());

            System.out.println("Koina 100 ima "+coins100.size());
//            pregleda sve

            int randomNum100 = (int)Math.floor(Math.random()*100);
            System.out.println("0-100 "+ randomNum100);


            ////////////////PROBA SA IMENOM COINA ////////////////////////////

            List<String> nameCoins = new ArrayList<>();

            for (int k = 0; k < nameOfEveryCoin.size(); k ++) {
                nameCoins.add(nameOfEveryCoin.get(k).getText());
            }

            String choosenCoinRandom = nameCoins.get(randomNum100);
            actualCoinString = choosenCoinRandom;

            System.out.println("Proba1: "+choosenCoinRandom);
            String oneCoin = "//tr[td//p[text()=\"%s\"]]//button[span]";

            WebElementFacade choosenCoin = findBy(String.format(oneCoin, choosenCoinRandom));

//            dodje do tog jednog i klikni
            actions.moveToElement(choosenCoin).perform();
            js.executeScript("arguments[0].click();", choosenCoin);

//            klikne na tri tacke

            if ((randomNumCoinsPick-1) == i){
                continue;
            }else {
                redirectOn7DaysHistiry();
                changeHistoryDataOnLast7Days();
                checkingResalt();
                redirectToCripty();
            }

        }

    }

    public void redirectOn7DaysHistiry() throws InterruptedException {
        action.waitForElement(viewHistoryButton);
        actions.moveToElement(viewHistoryButton).perform();
        js.executeScript("arguments[0].click();", viewHistoryButton);


        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(1000);
        action.waitForElement(days7HistoryButton);
        actions.moveToElement(days7HistoryButton).click().perform();
        js.executeScript("arguments[0].click();", days7HistoryButton);

        expectedCoinString = coinForAssert.getText();

    }

    public void changeHistoryDataOnLast7Days() throws InterruptedException {

        Thread.sleep(1000);
        action.waitForElement(last7DaysView);
        actions.moveToElement(last7DaysView).perform();
        js.executeScript("arguments[0].click();", last7DaysView);

        action.waitForElement(continue7DaysButton);
        actions.moveToElement(continue7DaysButton).perform();
        js.executeScript("arguments[0].click();", continue7DaysButton);

        Assert.assertEquals(expectedCoinString, actualCoinString);
    }

    public void checkingResalt () throws InterruptedException {

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, YYYY");
        String dateToday = formatter.format(today);
        System.out.println("Datum danas: "+ dateToday);
        Thread.sleep(500);

        action.waitForListElement(datesOnHisoryPage);

        boolean isHaveDateInList = false;

        for (WebElementFacade facade : datesOnHisoryPage) {
            if(dateToday.equalsIgnoreCase(facade.getText())){
                isHaveDateInList = true;
            }
        }

        ////////////////////////////////////////////////////////////////////////////////BUG

        Assert.assertEquals(true, isHaveDateInList); //TREBA POPRAVITI

        ////////////////////////////////////////////////////////////////////////////////BUG
//        Bug zato sto u doc pise da prikazuje 7 dana istorije, ali prikazuje 6 dana bez danasnjeg
    }

//    Treba dodati

    public void hoverCriptoClickOnSpotlight () throws InterruptedException {
        action.waitForElement(viewAll);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(viewAll).perform();
        Thread.sleep(500);

        action.waitForElement(spotlightButton);
        action.clickOnElement(spotlightButton);
    }

    List<WebElementFacade> mostVisitedCoins1 = new ArrayList<>() ;

    public void  navigateToMostVisitCoin(){
        for (WebElementFacade web : mostVisitedCoins){
            actions.moveToElement(web).perform();

        }

        mostVisitedCoins1.addAll(mostVisitedCoins);
        System.out.println("Size "+mostVisitedCoins1.size());

        action.waitForElement(seeMoreMostVisited);
        action.clickOnElement(seeMoreMostVisited);
    }

    public void  navigateToMostVisitCoinWithNewTab() throws InterruptedException {
        hoverCriptoClickOnSpotlight();

        action.waitForElement(seeMoreMostVisited);

        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        action.sendKeyToElement(seeMoreMostVisited, selectLinkOpeninNewTab);

        getDriver().switchTo().window(getDriver().getWindowHandles().stream().reduce((f, s) -> s).orElse(null));
    }


    public void verifyMostVisitCoins(){

        boolean checked = true;
        int i = 0;

        System.out.println(onMostVisitedPageCoins.size());

        while (checked == false || i == 10){

            String web = onMostVisitedPageCoins.get(i).getText();
            String webFirst = mostVisitedCoins1.get(i).getText();
            if(!web.equalsIgnoreCase(webFirst)) {
                checked = false;
            }
            i++;
        }

        Assert.assertEquals("Equals name of coins",true, checked);


    }


}
