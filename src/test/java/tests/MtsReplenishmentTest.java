package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.PaymentModal;
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
    public void testPlaceholdersAllTabs_2_10() {
        mainPage.open();

        System.out.println("=== Начало проверки надписей во всех вкладках (пункт 1 2.10) ===");

        mainPage.checkAllTabsPlaceholders();

        System.out.println("✅ Пункт 1 задания 2.10 успешно выполнен!");
    }

    @Test
    public void testPaymentModal_2_10() throws InterruptedException {
        mainPage.open();

        System.out.println("=== Проверка модального окна (пункт 2) ===");

        mainPage.fillServicesTab("297777777", "50");
        mainPage.clickContinue();

        PaymentModal paymentModal = new PaymentModal(driver);
        paymentModal.waitForModal();
        paymentModal.switchToPaymentFrame();   // ← самое важное

        String sum = paymentModal.getPaySum();
        String phone = paymentModal.getPhoneNumber();

        System.out.println("Найденная сумма: [" + sum + "]");
        System.out.println("Найденный номер телефона: [" + phone + "]");

        assertTrue(sum.contains("50.00"), "Сумма не содержит 50.00. Найдено: " + sum);
        assertTrue(phone.contains("297777777") || phone.contains("375297777777"), "Номер телефона не найден. Найдено: " + phone);

        System.out.println("Базовые проверки прошли");

        Thread.sleep(10000);
    }
}