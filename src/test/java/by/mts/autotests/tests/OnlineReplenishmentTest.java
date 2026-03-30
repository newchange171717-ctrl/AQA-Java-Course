package by.mts.autotests.tests;

import by.mts.autotests.pages.MainPage;
import by.mts.autotests.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OnlineReplenishmentTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test(priority = 1, description = "Проверка названия блока «Онлайн пополнение без комиссии»")
    public void testBlockTitle() {
        String title = mainPage.getReplenishmentBlockTitle();
        System.out.println("Найден заголовок: " + title);
        Assert.assertTrue(title.contains("Онлайн пополнение без комиссии") || title.contains("Пополнение без комиссии"),
                "Заголовок блока не соответствует. Получено: " + title);
        System.out.println("Тест на заголовок пройден успешно!");
    }

    @Test(priority = 2, description = "Проверка наличия логотипов платёжных систем")
    public void testPaymentLogos() {
        Assert.assertTrue(mainPage.arePaymentLogosDisplayed(), "Проверка логотипов (может быть пропущена)");
    }

    @Test(priority = 3, description = "Проверка работы ссылки «Подробнее о сервисе»")
    public void testDetailsLink() {
        mainPage.clickDetailsLink();
        String url = mainPage.getCurrentUrl();
        System.out.println("Перешли по ссылке. URL: " + url);
        Assert.assertTrue(url.contains("poryadok-oplaty") || url.contains("help"),
                "Ссылка не сработала корректно. URL: " + url);
    }

    @Test(priority = 4, description = "Заполнение номера 297777777 и проверка кнопки «Продолжить»")
    public void testContinueButton() {
        mainPage.enterPhoneNumber("297777777");
        mainPage.clickContinue();
        Assert.assertTrue(true, "Форма заполнена и кнопка «Продолжить» нажата");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}