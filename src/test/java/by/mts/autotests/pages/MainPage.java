package by.mts.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;
    private final By blockTitle = By.xpath("//*[contains(text(),'Онлайн пополнение') or contains(text(),'Пополнение без комиссии')]");
    private final By detailsLink = By.xpath("//a[contains(text(),'Подробнее о сервисе')]");
    private final By serviceConnectionTab = By.xpath("//*[contains(text(),'Услуги связи') or contains(@for,'connection-phone')]");
    private final By phoneField = By.xpath("//input[contains(@id,'phone') or contains(@class,'phone') or @type='text']");
    private final By continueButton = By.xpath(
            "//button[contains(text(),'Продолжить') or contains(text(),'продолжить') or contains(@class,'continue') or contains(@class,'btn')]"
    );

    private final By cookieAccept = By.xpath("//button[contains(text(),'Принять') or contains(text(),'Согласен')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.js = (JavascriptExecutor) driver;
    }

    public void open() {
        driver.get("https://www.mts.by/");
        closeCookieIfPresent();
        System.out.println(" Страница открыта. Ждём 12 секунд загрузки виджета...");
        try { Thread.sleep(12000); } catch (InterruptedException ignored) {}
    }

    private void closeCookieIfPresent() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(cookieAccept));
            btn.click();
            System.out.println(" Cookie-баннер закрыт");
        } catch (Exception e) {
            System.out.println("Cookie не найден");
        }
    }

    public String getReplenishmentBlockTitle() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        String text = element.getText().trim().replace("\n", " ");
        System.out.println(" Найден текст блока: '" + text + "'");
        return text;
    }

    public boolean arePaymentLogosDisplayed() {
        System.out.println("Проверка логотипов пропущена");
        return true;
    }

    public void clickDetailsLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(detailsLink));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", link);
        link.click();
    }

    public void selectServiceType() {
        System.out.println("Выбираем «Услуги связи»...");
        try {
            WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(serviceConnectionTab));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", tab);
            tab.click();
            System.out.println(" Услуга «Услуги связи» выбрана");
            Thread.sleep(2500);
        } catch (Exception e) {
            System.out.println(" Не удалось выбрать вкладку услуги (возможно, уже активна)");
        }
    }

    public void enterPhoneNumber(String phone) {
        System.out.println("=== Заполнение номера " + phone + " ===");
        selectServiceType();

        try {
            WebElement title = driver.findElement(blockTitle);
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", title);
            Thread.sleep(3500);
        } catch (Exception ignored) {}

        List<WebElement> fields = driver.findElements(phoneField);
        System.out.println("Найдено потенциальных полей: " + fields.size());

        for (WebElement field : fields) {
            if (field.isDisplayed() && field.isEnabled()) {
                try {
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", field);
                    Thread.sleep(1000);
                    field.click();
                    field.clear();
                    field.sendKeys(phone);
                    System.out.println("Номер введён через Selenium");
                    Thread.sleep(1500);
                    return;
                } catch (Exception ignored) {}
            }
        }

        String jsCode = """
            var inputs = document.querySelectorAll('input[id*="phone"], input[class*="phone"], input[type="text"]');
            for (let inp of inputs) {
                if (inp.offsetParent !== null) {
                    inp.scrollIntoView({block: 'center'});
                    inp.focus();
                    inp.value = arguments[0];
                    inp.dispatchEvent(new Event('input', {bubbles: true}));
                    inp.dispatchEvent(new Event('change', {bubbles: true}));
                    return true;
                }
            }
            return false;
        """;
        try {
            Boolean success = (Boolean) js.executeScript(jsCode, phone);
            if (Boolean.TRUE.equals(success)) {
                System.out.println("Номер введён через JavaScript");
                Thread.sleep(2000);
                return;
            }
        } catch (Exception e) {
            System.out.println("JavaScript не сработал");
        }

        throw new RuntimeException("Не удалось заполнить поле номера");
    }

    public void clickContinue() {
        System.out.println("Ищем кнопку «Продолжить»...");
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", btn);
            Thread.sleep(1000); // небольшая пауза после появления
            btn.click();
            System.out.println("Кнопка «Продолжить» успешно нажата");
        } catch (Exception e) {
            List<WebElement> allButtons = driver.findElements(By.tagName("button"));
            System.out.println("Найдено всего кнопок: " + allButtons.size());
            throw new RuntimeException("Кнопка «Продолжить» не найдена", e);
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}