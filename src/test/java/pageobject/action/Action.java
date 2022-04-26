package pageobject.action;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SearchPageElement;

import java.util.List;
import java.util.NoSuchElementException;

public class Action extends SearchPageElement {
    private static final String baseUrl = "https://coinmarketcap.com/";

    public void connection(){
        getDriver().get(baseUrl);
    }

    public void waitForElement(WebElementFacade facade) {
        waitFor(facade);
    }

    public void waitForListElement(List<WebElementFacade> facade) {
        for (WebElementFacade w : facade) {
            waitFor(w);
        }
    }

    public void sendKeyToElement(WebElementFacade facade, String text) {
        facade.sendKeys(text);
    }

    public void clickOnElement(WebElementFacade facade) {
        facade.click();
    }

    public void selectChoose(WebElementFacade select, String text) {
        Select select1 = new Select(select);
        select1.selectByVisibleText(text);
    }

//    public void scrollPage() {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//
//        int dataSize = getDriver().findElements(dataLocator).size();
//        while (true){
//            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//            wait.ignoring(NoSuchElementException.class)
//                    .until(ExpectedConditions.invisibilityOfElementLocated(loadingLocator));
//
//            if (getDriver().findElements(dataLocator).size()== dataSize)
//                break;
//            dataSize = getDriver().findElements(dataLocator).size();
//        }
//    }
}
