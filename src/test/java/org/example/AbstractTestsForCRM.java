package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;

abstract class AbstractTestsForCRM extends AbstractTests {

    @Step("Открытие страницы www.globalsqa.com")
    @BeforeEach
    void initMainPage(){
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login",
               errMsg = "Страница не доступна";
        Assertions.assertDoesNotThrow(()-> getDriver().navigate().to(url), errMsg);
        Assertions.assertTrue(true);
    }
}
