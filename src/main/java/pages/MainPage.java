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

    // Cookie-баннер
    private final By cookieAccept = By.xpath("//button[contains(text(), 'Принять')]");

    // Основные элементы блока
    private final By blockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");
    private final By visaLogo = By.xpath("//img[contains(@src, 'visa')]");
    private final By mastercardLogo = By.xpath("//img[contains(@src, 'mastercard')]");
    private final By belkartLogo = By.xpath("//img[contains(@src, 'belkart')]");

    // Ссылка «Подробнее о сервисе» — более стабильный локатор
    private final By moreLink = By.xpath("//a[contains(text(), 'Подробнее о сервисе') or contains(@href, 'service')]");

    private final By tabServices = By.xpath("//option[contains(text(), 'Услуги связи')]");

    private final By phoneField = By.id("connection-phone");
    private final By amountField = By.id("connection-sum");
    private final By continueButton = By.xpath("//button[contains(text(),'Продолжить')]");

    private final By modalContainer = By.cssSelector("div.payment-widget-app, div.payment-widget-app__container");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void open() {
        driver.get("https://www.mts.by/");
        closeCookie();
    }

    private void closeCookie() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(cookieAccept));
            btn.click();
            Thread.sleep(1500);
            System.out.println("Cookie баннер закрыт");
        } catch (Exception e) {
            System.out.println("Cookie баннер не найден");
        }
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText();
    }

    public boolean isVisaLogoDisplayed() {
        return driver.findElements(visaLogo).size() > 0;
    }

    public boolean isMastercardLogoDisplayed() {
        return driver.findElements(mastercardLogo).size() > 0;
    }

    public boolean isBelkartLogoDisplayed() {
        return driver.findElements(belkartLogo).size() > 0;
    }

    public void clickMoreLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(moreLink));
        link.click();
    }

    public void selectServicesTab() {
        driver.findElement(tabServices).click();
    }

    public void fillPhoneAndAmount(String phone, String amount) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);

        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys(amount);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isModalWindowDisplayed() {
        return driver.findElements(modalContainer).size() > 0;
    }
}