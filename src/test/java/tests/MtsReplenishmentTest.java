package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

public class MtsReplenishmentTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    void setUp() {
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
    }

    @AfterEach
    void tearDown() {
        DriverManager.quitDriver();
    }

    @Test
    public void testReplenishmentBlock_2_9() throws InterruptedException {
        mainPage.open();

        // 1. Проверка названия блока
        String title = mainPage.getBlockTitle();
        assertTrue(title.contains("Онлайн пополнение") && title.contains("без комиссии"),
                "Название блока неверное. Получено: " + title);

        // 2. Проверка логотипов
        assertTrue(mainPage.isVisaLogoDisplayed(), "Логотип Visa не найден");
        assertTrue(mainPage.isMastercardLogoDisplayed(), "Логотип MasterCard не найден");
        assertTrue(mainPage.isBelkartLogoDisplayed(), "Логотип Белкарт не найден");

        System.out.println("Пункты 1 и 2 пройдены");

        // 3. Проверка ссылки «Подробнее о сервисе»
        mainPage.clickMoreLink();
        assertTrue(driver.getCurrentUrl().contains("mts.by"),
                "Ссылка 'Подробнее о сервисе' ведёт не на сайт MTS");

        driver.navigate().back();

        System.out.println("Пункт 3 пройден");

        // 4. Заполнение полей и проверка работы кнопки «Продолжить»
        mainPage.selectServicesTab();
        mainPage.fillPhoneAndAmount("297777777", "50");
        mainPage.clickContinue();

        // Явная проверка появления модального окна
        assertTrue(mainPage.isModalWindowDisplayed(),
                "Модальное окно не появилось после нажатия кнопки «Продолжить»");

        System.out.println("Модальное окно успешно открылось после нажатия 'Продолжить'");

        // Держим браузер открытым 5 секунд для визуальной проверки
        System.out.println("Ожидаем 5 секунд для визуальной проверки модального окна...");
        Thread.sleep(5000);

        System.out.println("Задание 2.9 полностью выполнено!");
    }
}