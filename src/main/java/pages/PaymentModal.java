package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentModal {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForModal() {
        try {
            Thread.sleep(4000);
            System.out.println("Ожидание модального окна завершено (4 сек)");
        } catch (InterruptedException ignored) {}
    }

    // Переключаемся в iframe (это самое важное!)
    public void switchToPaymentFrame() {
        try {
            // Пробуем разные возможные iframe
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                    By.cssSelector("iframe[src*='pay'], iframe[src*='bepaid'], iframe.gpay, iframe.payment")
            ));
            System.out.println("✓ Успешно переключились в iframe платежной формы");
        } catch (Exception e) {
            System.out.println("⚠ Не удалось переключиться в iframe, остаёмся в основном контексте");
        }
    }

    public String getPaySum() {
        return driver.findElement(By.xpath("//*[contains(text(),'50.00 BYN') or contains(text(),'50.00')]")).getText().trim();
    }

    public String getPhoneNumber() {
        return driver.findElement(By.xpath("//*[contains(text(),'375297777777') or contains(text(),'297777777') or contains(text(),'Оплата:')]")).getText().trim();
    }

    public String getCardNumberLabelText() {
        return driver.findElement(By.xpath("//label[contains(text(),'Номер карты')]")).getText().trim();
    }

    public String getExpirationDateLabelText() {
        return driver.findElement(By.xpath("//label[contains(text(),'Срок действия')]")).getText().trim();
    }

    public String getCvcLabelText() {
        return driver.findElement(By.xpath("//label[contains(text(),'CVC')]")).getText().trim();
    }

    public String getHolderNameLabelText() {
        return driver.findElement(By.xpath("//label[contains(text(),'Имя и фамилия на карте')]")).getText().trim();
    }

    public boolean isVisaLogoDisplayed() {
        return driver.findElements(By.xpath("//img[contains(@src,'visa')]")).size() > 0;
    }

    public boolean isMasterCardPDisplayed() {
        return driver.findElements(By.xpath("//img[contains(@src,'mastercard')]")).size() > 0;
    }

    public boolean isBelkartLogoPDisplayed() {
        return driver.findElements(By.xpath("//img[contains(@src,'belkart')]")).size() > 0;
    }
}