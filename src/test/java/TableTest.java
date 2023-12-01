import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.example.constant.Constant.GOOGLE_URL;

public class TableTest extends BaseTest{
    @Test
    @DisplayName("Проверка на открытие страницы")
    @Order(1)
    public void testOpenPage() {
        tablePage.openPage(GOOGLE_URL);
        String title = webDriver.getTitle();
        Assert.assertEquals("страница не открылась", "Google", title);
    }
    @Test
    @Order(2)
    @DisplayName("Ищем заголовок Таблица")
    @CsvSource({"Таблица"})
    @ParameterizedTest(name="{displayName} {arguments}")
    public void checkTitleOfPage(String title) {
        tablePage.enter().checkTitle(title);
        Assert.assertTrue("Не нашелся такой заголовок", tablePage.isTitleTable());
    }
    @ParameterizedTest(name="{displayName} {arguments}")
    @CsvSource({"Сергей Владимирович, Сергей Адамович"})
    @DisplayName("Проверка результатов первого и последнего человека")
    @Order(4)
    public void checkTable(String firstMan, String lastMan) {
        tablePage.enter().checkTable(firstMan, lastMan);
        Assert.assertTrue("неправильное расположение людей",tablePage.isFirstAndLastPlace());
    }
    @AfterEach
    public void done() {
        webDriver.close();
        webDriver.quit();
    }

}
