package org.example.firstTestCase;
import org.example.basePage.BasePage;
import org.example.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.google.gson.internal.bind.TypeAdapters.URL;
import static org.example.constant.Constant.*;
/**
 * @author ivannikolaev
 *
 */

public class ChromePage extends BasePage {
    public ChromePage(WebDriver webDriver) {
        super(webDriver);
    }
    /**
     * search input element add send word there
     * @return this - object of the class for making a chain
     */

public ChromePage enter() {
        openPage(Constant.GOOGLE_URL);
        WebElement search =  webDriver.findElement(searchField);
        search.click();
        search.sendKeys(FIND_WORD_FLOWER);
        search.submit();
        return this;
}
    /**
     * check that this page has ref on wiki
     * @return this - object of the class for making a chain
     */
public List<WebElement> checkRefs() {
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
    List<WebElement> webElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//cite")));
    return webElements;
}
}