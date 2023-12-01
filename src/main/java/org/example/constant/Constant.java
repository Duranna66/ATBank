package org.example.constant;

import org.openqa.selenium.By;

public class Constant {
    public final static String FIND_WORD_FLOWER = "Гладиолус";
    public final static String FIND_WORD_BANK = "Открытие";
    public final static String FIND_WORD_TABLE = "таблица";
    public final static String GOOGLE_URL = "https://www.google.com/";
    public final static By searchField = By.xpath("//*[@id=\"APjFqb\"]");
    public final static By TITLE_OF_BANK = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3");
    public final static By REF_OF_BANK = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a");
    public final static By TITLE_OF_BLOCK = By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[3]/a");
    public final static By TABLE_OF_CURRENCY = By.xpath("//tr[@class='card-rates-table__row']");
    public final static By TITLE_OF_TABLE = By.xpath("//*[@id=\"rso\"]/div[@class=\"MjjYud\"]/div/div/div/div/div/span/a/h3");
    public final static By REF_OF_TABLE = By.xpath("//*[@id=\"rso\"]/div[@class=\"MjjYud\"]/div/div/div/div/div/span/a");
    public final static By TABLE = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody");
}
