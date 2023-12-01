
import org.example.basePage.BasePage;
import org.example.firstTestCase.ChromePage;
import org.example.secondTestCase.BankPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.constant.Constant.GOOGLE_URL;

public class BankTest extends BaseTest{
    @Test
    @Order(1)
    @DisplayName("Проверка на открытие страницы")
    public void testOpenPage() {
        basePage.openPage(GOOGLE_URL);
        String title = webDriver.getTitle();
        Assert.assertEquals(title, "Google");

    }
    @AfterEach
    public void done() {
        webDriver.close();
        webDriver.quit();
    }
    @Test
    @Order(2)
    @DisplayName("проверяем что заголовок ссылки корректный")
    public void testTitleRefBank() {
        bankPage.enter().checkTextOfTitle();
        String text = bankPage.getText();
        Assert.assertEquals("заголовки не совпадают",text, "Банк Открытие: кредит наличными, ипотека, кредитные и ...");
    }
    @Order(3)
    @DisplayName("проверяем что сайт открылся")
    @ParameterizedTest(name="{displayName} {arguments}")
    @CsvSource({"Открытие"})
    public void checkBankTitle(String expectedTitle) {
        bankPage.enter().clickToRef();
        String title = bankPage.getBankTitle();
        Assert.assertTrue("сайт банка не открылся",title.contains(expectedTitle));
    }
    @Test
    @Order(4)
    @DisplayName("проверяем что есть блок с валютами")
    public void checkBlock() {
        bankPage.enter().clickToRef().clickOnList().findBlock();
        Assert.assertTrue(bankPage.isBlockIsEnable());
    }
    @Order(5)
    @DisplayName("проверяем что блок с валютами открылся")
    @ParameterizedTest(name="{displayName} {arguments}")
    @CsvSource({"Курсы обмена валют"})
    public void openBlock(String title) {
        bankPage.enter().clickToRef().clickOnList().clickOnBlock();
        Assert.assertTrue(bankPage.getTitleOfBlockPage().contains(title));
    }
    @Test
    @Order(6)
    @DisplayName("проверяем что есть хотя бы 3 валюты")
    public void checkCurrency() {
        bankPage.enter().clickToRef().clickOnList().clickOnBlock().checkCountCurrency();
        Assert.assertTrue(bankPage.isThreeCurrency());
    }
    @Test
    @Order(7)
    @DisplayName("проверяем что продажа доллара больше покупки")
    public void checkSellMoreThanBuyUSD() {
        bankPage.enter().clickToRef().clickOnList().clickOnBlock().checkSellMoreBuyUSD();
        Assert.assertTrue(bankPage.isSellMoreThanBuyUSD());
    }
    @Test
    @Order(8)
    @DisplayName("проверяем что продажа Евро больше покупки")
    public void checkSellMoreThanBuyEUR() {
        bankPage.enter().clickToRef().clickOnList().clickOnBlock().checkSellMoreBuyEUR();
        Assert.assertTrue(bankPage.isSellMoreThanBuyEUR());
    }
}

