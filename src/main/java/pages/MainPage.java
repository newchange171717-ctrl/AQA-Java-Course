package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Cookie
    private final By cookieAccept = By.xpath("//button[contains(text(), 'Принять')]");

    // Открытие селекта
    private final By selectHeader = By.cssSelector("button.select__header");

    // Конкретные поля по id
    private final By servicesPhone = By.id("connection-phone");
    private final By servicesSum = By.id("connection-sum");
    private final By servicesEmail = By.id("connection-email");

    private final By internetPhone = By.id("internet-phone");
    private final By internetSum = By.id("internet-sum");
    private final By internetEmail = By.id("internet-email");

    private final By instalmentScore = By.id("score-instalment");
    private final By instalmentSum = By.id("instalment-sum");

    private final By arrearsScore = By.id("score-arrears");
    private final By arrearsSum = By.id("arrears-sum");
    private final By arrearsEmail = By.id("arrears-email");
    private final By continueButton = By.xpath("//button[contains(text(),'Продолжить')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void open() {
        driver.get("https://www.mts.by/");
        closeCookieBanner();
    }

    private void closeCookieBanner() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(cookieAccept));
            btn.click();
            Thread.sleep(1500);
        } catch (Exception ignored) {}
    }

    public void switchToTab(String tabName) {
        System.out.println("→ Переключаемся на: " + tabName);

        // Открываем селект
        WebElement header = wait.until(ExpectedConditions.elementToBeClickable(selectHeader));
        header.click();

        // Кликаем по нужной опции
        String optionXpath;
        switch (tabName) {
            case "Услуги связи":    optionXpath = "//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"; break;
            case "Домашний интернет": optionXpath = "//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p"; break;
            case "Рассрочка":       optionXpath = "//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p"; break;
            case "Задолженность":   optionXpath = "//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p"; break;
            default: throw new IllegalArgumentException("Неизвестная вкладка");
        }

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        option.click();

        // Большая пауза + ожидание обновления формы
        try { Thread.sleep(4500); } catch (InterruptedException ignored) {}

        System.out.println("✓ Переключено на: " + tabName);
    }

    public void checkPlaceholder(By locator, String expectedText, String fieldDescription) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String actual = element.getAttribute("placeholder");

        assert actual != null && actual.contains(expectedText) :
                fieldDescription + ": ожидалось '" + expectedText + "', получено '" + actual + "'";
    }

    // Пункт 1 задания 2.10
    public void checkAllTabsPlaceholders() {
        checkServicesTabPlaceholders();
        checkInternetTabPlaceholders();
        checkInstallmentTabPlaceholders();
        checkDebtTabPlaceholders();
    }

    public void checkServicesTabPlaceholders() {
        switchToTab("Услуги связи");
        checkPlaceholder(servicesPhone, "Номер телефона", "Поле телефона (Услуги связи)");
        checkPlaceholder(servicesSum, "Сумма", "Поле суммы (Услуги связи)");
        checkPlaceholder(servicesEmail, "E-mail для отправки чека", "Поле email (Услуги связи)");
    }

    public void checkInternetTabPlaceholders() {
        switchToTab("Домашний интернет");
        checkPlaceholder(internetPhone, "Номер абонента", "Поле абонента (Домашний интернет)");
        checkPlaceholder(internetSum, "Сумма", "Поле суммы (Домашний интернет)");
        checkPlaceholder(internetEmail, "E-mail для отправки чека", "Поле email (Домашний интернет)");
    }

    public void checkInstallmentTabPlaceholders() {
        switchToTab("Рассрочка");
        checkPlaceholder(instalmentScore, "Номер счета на 44", "Поле счета (Рассрочка)");
        checkPlaceholder(instalmentSum, "Сумма", "Поле суммы (Рассрочка)");
    }

    public void checkDebtTabPlaceholders() {
        switchToTab("Задолженность");
        checkPlaceholder(arrearsScore, "Номер счета на 2073", "Поле счета (Задолженность)");
        checkPlaceholder(arrearsSum, "Сумма", "Поле суммы (Задолженность)");
        checkPlaceholder(arrearsEmail, "E-mail для отправки чека", "Поле email (Задолженность)");
    }

    public void fillServicesTab(String phone, String amount) {
        switchToTab("Услуги связи");
        driver.findElement(servicesPhone).clear();
        driver.findElement(servicesPhone).sendKeys(phone);
        driver.findElement(servicesSum).clear();
        driver.findElement(servicesSum).sendKeys(amount);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}