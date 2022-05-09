package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractTestForMyProject extends AbstractTests {

    @Step("Открытие страницы www.saucedemo.com")
    @BeforeEach
    void initMainPage(){
        String url = "https://www.saucedemo.com/",
                errMsg = "Страница не доступна";
        Assertions.assertDoesNotThrow(()-> getDriver().navigate().to(url), errMsg);
        Assertions.assertTrue(true);
    }
}
