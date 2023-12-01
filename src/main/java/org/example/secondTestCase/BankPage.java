package org.example.secondTestCase;

import org.example.basePage.BasePage;
import org.example.firstTestCase.ChromePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.constant.Constant.*;
/**
 * @author ivannikolaev
 */

public class BankPage extends BasePage {
    /**
     * field for checking that text of title is correct
     */
    private String text;
    /**
     * field for checking that block of currency is existed
     */
    private boolean blockIsEnable;
    /**
     * field for checking correct bankTitle
     */
    private String bankTitle;
    /**
     * field for checking exist of title of block page
     */
    private String titleOfBlockPage;
    /**
     * field for checking that block has currency
     */
    private boolean isThreeCurrency;
    /**
     * field for checking that sell more than buy USD
     */
    private boolean sellMoreThanBuyUSD;
    /**
     * field for checking that sell more than buy EUR
     */
    private boolean sellMoreThanBuyEUR;


    public BankPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isThreeCurrency() {
        return isThreeCurrency;
    }

    public boolean isSellMoreThanBuyUSD() {
        return sellMoreThanBuyUSD;
    }

    public boolean isSellMoreThanBuyEUR() {
        return sellMoreThanBuyEUR;
    }

    public String getTitleOfBlockPage() {
        return titleOfBlockPage;
    }

    public String getBankTitle() {
        return bankTitle;
    }

    public String getText() {
        return text;
    }

    public boolean isBlockIsEnable() {
        return blockIsEnable;
    }
    /**
     * search input element add send word there
     * @return this - object of the class for making a chain
     */

    public BankPage enter() {
        openPage(GOOGLE_URL);
        WebElement search = waitElementIsVisible(webDriver.findElement(searchField));
        search.click();
        search.sendKeys(FIND_WORD_BANK);
        search.submit();
        return this;
    }
    /**
     * search title of bank
     * @return this - object of the class for making a chain
     */

    public BankPage checkTextOfTitle() {
        WebElement element = webDriver.findElement(TITLE_OF_BANK);
        this.text = element.getText();
        return this;
    }
    /**
     * click on ref of cite "Открытие"
     * @return this - object of the class for making a chain
     */

    public BankPage clickToRef() {
//       WebElement wait = waitElementIsVisible(webDriver.findElement(REF_OF_BANK));
        String ref =  "https://www.open.ru";
        openPage(ref);
        this.bankTitle = webDriver.getTitle();
        return this;
    }
    /**
     * click on list for find block with currency
     * @return this - object of the class for making a chain
     */

    public BankPage clickOnList() {
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"headerButtonsBlockId\"]/div[2]"));
        webElement.click();
        return this;
    }
    /**
     * check that block with currency is existed
     * @return this - object of the class for making a chain
     */

    public BankPage findBlock() {
        try {
            WebElement webElement = waitElementIsVisible(webDriver.findElement(TITLE_OF_BLOCK));
            this.blockIsEnable = true;
        } catch (Exception e) {
            this.blockIsEnable = false;
        }
        return this;
    }
    /**
     * clock on this block for checking currency
     * @return this - object of the class for making a chain
     */

    public BankPage clickOnBlock() {
        WebElement webElement = webDriver.findElement(TITLE_OF_BLOCK);
        webDriver.get(webElement.getAttribute("href"));
        this.titleOfBlockPage = webDriver.getTitle();
        return this;
    }
    /**
     * check that we have three currency
     * @return this - object of the class for making a chain
     */

    public BankPage checkCountCurrency() {
        List<WebElement> webElements = webDriver.findElements(TABLE_OF_CURRENCY);
//            WebElement webElement1 = webElement.findElement(By.xpath(".//span[@class='currency__text']"));
        this.isThreeCurrency = webElements.size() >= 3;
        return this;
    }
    /**
     * check that sell more than buy USD
     * @return this - object of the class for making a chain
     */

    public BankPage checkSellMoreBuyUSD() {
        List<WebElement> webElements = webDriver.findElements(TABLE_OF_CURRENCY);
        for (WebElement webElement : webElements) {
            WebElement webElement1 = webElement.findElement(By.xpath(".//td[@class=\"card-rates-table__cell card-rates-table__name large-text\"]/div/span[@class='currency__text']"));
            if (webElement1.getText().equals("USD")) {
                WebElement buy = webElement.findElement(By.xpath(".//td[@class=\"card-rates-table__cell card-rates-table__purchase large-text\"]"));
                WebElement sell = webElement.findElement(By.xpath(".//td[@class='card-rates-table__cell card-rates-table__sale large-text']"));
                String corrBuy = buy.getText().replace(',', '.');
                String corrSell = sell.getText().replace(',', '.');
                this.sellMoreThanBuyUSD = Double.parseDouble(corrBuy) > Double.parseDouble(corrSell);
            }
        }
        return this;
    }
    /**
     * check that sell more than buy EUR
     * @return this - object of the class for making a chain
     */
    public BankPage checkSellMoreBuyEUR() {
        List<WebElement> webElements = webDriver.findElements(TABLE_OF_CURRENCY);
        for (WebElement webElement : webElements) {
            WebElement webElement1 = webElement.findElement(By.xpath(".//td[@class=\"card-rates-table__cell card-rates-table__name large-text\"]/div/span[@class='currency__text']"));
            if (webElement1.getText().equals("EUR")) {
                WebElement buy = webElement.findElement(By.xpath(".//td[@class=\"card-rates-table__cell card-rates-table__purchase large-text\"]"));
                WebElement sell = webElement.findElement(By.xpath(".//td[@class='card-rates-table__cell card-rates-table__sale large-text']"));
                String corrBuy = buy.getText().replace(',', '.');
                String corrSell = sell.getText().replace(',', '.');
                this.sellMoreThanBuyEUR = Double.parseDouble(corrBuy) > Double.parseDouble(corrSell);
            }
        }
        return this;
    }
}

