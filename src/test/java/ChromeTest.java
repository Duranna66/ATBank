import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChromeTest extends BaseTest{

@Test
@DisplayName("Проверка результатов открытия страницы гугл")
    public void openTest() {
            basePage.openPage("https://www.google.com/");
            String title =  webDriver.getTitle();
        Assert.assertEquals("страница гугла не открылась",title, "Google");
    }
    @Test
    @DisplayName("Проверяем содержится ли ссылка на вики на этой странице")
    public void checkRef() {
        List<WebElement> elementList = chromePage.enter().checkRefs();
        boolean res =  elementList.stream().anyMatch(x -> x.getText().contains("https://ru.wikipedia.org"));
        Assert.assertTrue("Нет википедии на первой странице",res);
    }
    @AfterEach
    public void done() {
        webDriver.close();
        webDriver.quit();
    }
}
