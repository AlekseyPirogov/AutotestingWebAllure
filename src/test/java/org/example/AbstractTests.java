package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

public abstract class AbstractTests {

    // Переменная типа WebDriver для экземпляра драйвера:
    private static WebDriver driver;

    // Задержки для теста:
    private static Integer delayAfterTest = 300;

    // -------------- Набор методов для организации работы основных тестов:
    // Метод для инициализации драйвера браузера Google Chrome
    @Step("Инициализация драйвера")
    @BeforeEach
    void initWebDriver() {
        WebDriverManager.chromedriver().setup();        // Набор настроек для браузера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");            // Режим инкогнито
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);             // Инициализация объекта типа WebDriver опциями
        // Установка стандартной задержки (неявное ожидание) для браузера:
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Step("Закрытие страницы")
    @AfterEach
    void closeThisPage() throws InterruptedException {
        getBrowserLog();
        Thread.sleep(getDelayAfterTest());
        if(getDriver() != null) getDriver().close();    // <-- закрытие страницы
    }

    // Метод для получения экземпляра класса
    public static WebDriver getDriver() {
        return driver;
    }

    // Методы для работы с задержкой в тесте
    public static int getDelayAfterTest() {
        return delayAfterTest;
    }

    // Метод для получения скриншота экрана после выполнения теста

    public static void getScreeshot(String nameTest) throws IOException {
        File file = Utils.makeScreenshot(getDriver(),nameTest + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
    }

    @Step("Сохранение скриншота после шага")
    @Attachment(value = "Screenshots attachment ", type = "image/png")
    public static byte[] saveScreenshot(byte[] resultScreenshot) {
        return resultScreenshot;
    }

    public static void getBrowserLog() {
        LogEntries browserLogs = getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size() > 0 ) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });
        }
    }
}
