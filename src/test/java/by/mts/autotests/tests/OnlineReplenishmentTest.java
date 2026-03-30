package by.mts.autotests.tests;

import by.mts.autotests.pages.MainPage;
import by.mts.autotests.utils.DriverManager;
import org.openqa.selenium.WebDriver;
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
    }

    @Test
    public void testBlockTitle() {
        mainPage.open();
        String title = mainPage.getBlockTitle();
        assert title.contains("Онлайн пополнение") || title.contains("Пополнение без комиссии") : "Заголовок блока не совпадает";
    }

    @Test
    public void testPaymentLogos() {
        mainPage.open();
        assert mainPage.arePaymentLogosDisplayed() : "Логотипы платёжных систем не отображаются";
    }

    @Test
    public void testDetailsLink() {
        mainPage.open();
        mainPage.clickDetailsLink();
        // Можно добавить проверку URL или заголовка новой страницы, если нужно
    }

    @Test
    public void testContinueButton() {
        mainPage.open();
        mainPage.fillPhoneForServices("297777777");
        mainPage.clickContinue();
        mainPage.verifyPaymentModal("297777777", "50");
    }

    @Test
    public void testServicesPaymentFlow() {
        System.out.println("=== Проверка полного flow оплаты услуг связи ===");
        mainPage.open();
        mainPage.fillPhoneForServices("297777777");
        mainPage.clickContinue();
        mainPage.verifyPaymentModal("297777777", "50");
        System.out.println("Тест flow завершён (модальное окно может не открываться на текущей версии сайта)");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}