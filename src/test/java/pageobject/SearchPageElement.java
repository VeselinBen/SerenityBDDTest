package pageobject;

import lombok.ToString;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public abstract class SearchPageElement extends PageObject {

    @FindBy(xpath = "//a[@class='cmc-link']//span[@class='shfsau-0 jalYSY'][normalize-space()='Cryptocurrencies']")
    public WebElementFacade viewAll;

    @FindBy(xpath = "//a[normalize-space()='NFT']")
    public WebElementFacade NFTButton;

    @FindBy(xpath = "//p[normalize-space()='Bitcoin']")
    public WebElementFacade BTC;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr/td/div/button")
    public List<WebElementFacade> coins100;


//    //div[@class='sc-16r8icm-0 sc-1teo54s-0 dBKWCw']//p[@class='sc-1eb5slv-0 iworPT']
    @FindAll(@FindBy(xpath = "//div[@class='sc-16r8icm-0 sc-1teo54s-0 dBKWCw']//p[@class='sc-1eb5slv-0 iworPT']"))
    protected List<WebElementFacade> cois100p;

    /////////////

//    //tbody/tr

    @FindBy(xpath = "//tbody/tr")
    public List<WebElementFacade> tr100;

//    //td[11]//button

    @FindBy(xpath = "//td[11]//button")
    public WebElementFacade button100InTr;

    //////////////////////////

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr/td[11]/div")
    public List<WebElementFacade> coinsDiv100;

    @FindBy(xpath = "//button[normalize-space()='View Historical Data']")
    public WebElementFacade viewHistoryButton;

    @FindBy(xpath = "//button[@class='x0o17e-0 eXPsOy']")
    public WebElementFacade days7HistoryButton;

    @FindBy(xpath = "//li[normalize-space()='Last 7 days']")
    public WebElementFacade last7DaysView;

    @FindBy(xpath = "//button[@class='x0o17e-0 cEEOTh']")
    public WebElementFacade continue7DaysButton;

    @FindBy(xpath = "//a[contains(text(),'Spotlight')]")
    public WebElementFacade spotlightButton;

    //tr[td//p[text()="%s"]]//button[span] - menuElemButtonTriTacke String
    //tr/td[3]//p[@color='text'] - nameElem

    @FindBy(xpath = "//tr/td[3]//p[@color='text']")
    public List<WebElementFacade> nameOfEveryCoin;

    //h2[@class='sc-1q9q90x-0 jCInrl h1']

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div[2]/div/div[1]/div[1]/div/a[3]")
    public WebElementFacade coinForAssert;

    /////////////////////////////////////

//    //*[@id="__next"]/div/div[1]/div[2]/div/div[2]/div[4]/div[2]/table/tbody/tr

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[2]/div[4]/div[2]/table/tbody/tr/td[2]/a/div/div/p")
    public List<WebElementFacade> mostVisitedCoins;

//    //a[@href='/most-viewed-pages/'][normalize-space()='See more >']

    @FindBy(xpath = "//a[@href='/most-viewed-pages/'][normalize-space()='See more >']")
    public WebElementFacade seeMoreMostVisited;

//    //*[@id="__next"]/div/div[1]/div[2]/div/div/div[2]/table/tbody/tr/td[3]/a/div/div/p

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[2]/table/tbody/tr/td[3]/a/div/div/p")
    public List<WebElementFacade> onMostVisitedPageCoins;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[2]/table/tbody/tr/td[1]")
    public List<WebElementFacade> datesOnHisoryPage;

//  //*[@id="__next"]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr/td/div/button





//    @FindBy(xpath = coinXPath)

//    public WebElementFacade coin;


    //*[@id="__next"]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr[1]

//    //*[@id="__next"]//table/tbody/tr[5]//div[contains(@display,"flex")]//a


}

