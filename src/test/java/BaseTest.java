import org.example.basePage.BasePage;
import org.example.firstTestCase.ChromePage;
import org.example.secondTestCase.BankPage;
import org.example.thirdTestCase.TablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * @author ivannikolaev
 */
public class BaseTest {
    /**
     * create object of webDriver
     */
    protected WebDriver webDriver = new ChromeDriver();
    protected BasePage basePage = new BasePage(webDriver);
    protected ChromePage chromePage = new ChromePage(webDriver);
    protected BankPage bankPage = new BankPage(webDriver);
    protected TablePage tablePage = new TablePage(webDriver);
}
