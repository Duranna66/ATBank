package org.example.thirdTestCase;

import org.example.basePage.BasePage;
import org.example.secondTestCase.BankPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.constant.Constant.*;
/**
 * @author ivannikolaev
 */

public class TablePage extends BasePage {
    /**
     * field for checking that we found a title
     */
    private boolean isTitleTable;
    /**
     * field for checking that first man and last man are correct
     */
    private boolean isFirstAndLastPlace;
    public TablePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isFirstAndLastPlace() {
        return isFirstAndLastPlace;
    }


    public boolean isTitleTable() {
        return isTitleTable;
    }

    public void openPage(String url) {
        webDriver.get(url);
    }
    /**
     * search input element add send word there
     * @return this - object of the class for making a chain
     */
    public TablePage enter() {
        openPage(GOOGLE_URL);
        WebElement search = waitElementIsVisible(webDriver.findElement(searchField));
        search.click();
        search.sendKeys(FIND_WORD_TABLE);
        search.submit();
        return this;
    }
    /**
     * check that this page has cite with title from arg
     * @param title for check
     * @return this - object of the class for making a chain
     */
    public TablePage checkTitle(String title) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        List<WebElement> webElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(TITLE_OF_TABLE));
        this.isTitleTable = webElements.stream().anyMatch(x -> x.getText().equals(title));
        return this;
    }
    /**
     * check that two persons have correct place on the table
     * @param firstMan  is first person for checking the place
     * @param lastMan  is second person for checking the place
     * @return this - object of the class for making a chain
     */
    public TablePage checkTable(String firstMan, String lastMan) {
        openPage("https://ru.wikipedia.org/wiki/%D0%A2%D0%B0%D0%B1%D0%BB%D0%B8%D1%86%D0%B0");
        List<WebElement> webElements = webDriver.findElements(TABLE);
        for(WebElement webElement : webElements) {
            List<WebElement> webElementList = webElement.findElements(By.xpath(".//tr"));
            String first = webElementList.get(1).getText();
            String last = webElementList.get(webElementList.size() - 1).getText();
            String[] tmp1 = first.split(" ");
            String[] tmp2 = last.split(" ");
            String firstPerson = tmp1[1] + " " + tmp1[2];
            String secondPerson = tmp2[1] + " " + tmp2[2];
            this.isFirstAndLastPlace =  firstPerson.equals(firstMan) && secondPerson.equals(lastMan);
            }
        return this;
    }

}
