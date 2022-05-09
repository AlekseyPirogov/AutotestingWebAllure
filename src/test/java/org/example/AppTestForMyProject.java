package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.example.TestForMyProject.WorkWithApp;

import java.io.IOException;

/**
 * Тесты для https://www.saucedemo.com
 */

@Story("Набор тестов для MyProject")
public class AppTestForMyProject extends AbstractTestForMyProject {

    public static int delay = 200;

    public static int getDelay() {
        return delay;
    }

    // #MyProject_1.Добавление пользователя (заблокированный и отсутствующий пользователь)
    @Test
    @Description("#MyProject_1 Добавление пользователя (заблокированный и отсутствующий пользователь)")
    @DisplayName("#MyProject_1 Добавление пользователя (заблокированный и отсутствующий пользователь)")
    @Link("https://www.saucedemo.com/")
    @Issue("localhost")
    @Tag("userRegistration")
    @Tag("#MyProject_1")
    @Severity(SeverityLevel.CRITICAL)
    void userRegistration() throws InterruptedException, IOException {
        WorkWithApp workWithApp = new WorkWithApp(getDriver());
        workWithApp                                // Ввод данных
                .inputUsername("locked_out_user")
                .inputPassword("secret_sauce")
                .sleep(getDelay())
                .clickLoginButton()                 // Аутентификация пользователя
                .sleep(getDelay() * 2);

        getScreeshot("#MyProject_1_");
        workWithApp.clickReloadAuth();             // Нажатие кнопки с ошибкой для сброса аутентификации

        getScreeshot("#MyProject_1_");

        // Пример assertions по url
        String resUrl = "https://www.saucedemo.com/";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());

        workWithApp
                .inputUsername("nobody")
                .inputPassword("zero")
                .sleep(getDelay())
                .clickLoginButton()                // Аутентификация пользователя
                .sleep(getDelay() * 5);

        getScreeshot("#MyProject_1_");

        // Результат работы теста assertions по url
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }

    // #MyProject_2.Регистрация пользователя и выход из витрины (низкая производительность)
    @Test
    @Description("#MyProject_2 Регистрация пользователя и выход из витрины (низкая производительность)")
    @DisplayName("#MyProject_2 Регистрация пользователя и выход из витрины (низкая производительность)")
    @Link("https://www.saucedemo.com/")
    @Issue("localhost")
    @Tag("userRegistrationAndExit")
    @Tag("#MyProject_2")
    @Severity(SeverityLevel.NORMAL)
    void userRegistrationAndExit() throws InterruptedException, IOException {
        WorkWithApp workWithApp = new WorkWithApp(getDriver());
        workWithApp                                // Ввод данных
                .inputUsername("performance_glitch_user")
                .inputPassword("secret_sauce")
                .sleep(getDelay())
                .clickLoginButton()                 // Аутентификация пользователя
                .sleep(getDelay())
                .openMainMenu()                     // Открытие верхнего левого меню
                .sleep(getDelay())
                .loguot()                           // Выход из витрины
                .sleep(getDelay() * 5);

        getScreeshot("#MyProject_2_");

        // Результат работы теста assertions по url
        String resUrl = "https://www.saucedemo.com/";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }

    // #MyProject_3.Работа с пользовательским интерфейсом
    @Test
    @Description("#MyProject_3 Работа с пользовательским интерфейсом")
    @DisplayName("#MyProject_3 Работа с пользовательским интерфейсом")
    @Link("https://www.saucedemo.com/")
    @Issue("localhost")
    @Tag("workWithUI")
    @Tag("#MyProject_3")
    @Severity(SeverityLevel.CRITICAL)
    void workWithUI() throws InterruptedException, IOException {
        WorkWithApp workWithApp = new WorkWithApp(getDriver());
        workWithApp                         // Ввод данных
                .inputUsername("standard_user")
                .inputPassword("secret_sauce")
                .clickLoginButton()         // Аутентификация пользователя
                .sleep(getDelay())
                .goToFotter()               // Скролл странцы: переход в футер
                .sleep(getDelay())
                .openMainMenu()             // Переход в главное меню
                .sleep(getDelay())
                .closeMainMenu()            // Закрытие главного меню
                .sleep(getDelay())
                .selectFieldSort()          // Проверка доступности меню сортировки товаров на странице витрины
                .sleep(getDelay())
                .sortByAZ()                 // Сортировка в прямом алфавитном порядке
                .sleep(getDelay())
                .sortByZA()                 // Сортировка в обратном алфавитном порядке
                .sleep(getDelay())
                .openShoppingCart()         // Переход в корзину
                .sleep(getDelay())
                .closeShoppingCart()        // Выход из корзины
                .sleep(getDelay() * 6)
                .viewItem(4)                // Просмотр товара
                .sleep(getDelay() * 6)
                .backToProducts()           // Возврат к покупкам
                .sleep(getDelay() * 3)
                .viewItem(3)                // Просмотр товара
                .sleep(getDelay() * 6)
                .openShoppingCart()         // Переход в корзину
                .openMainMenu()             // Открытие верхнего левого меню
                .loguot()                  // Выход из витрины
                .sleep(getDelay() * 5);

        getScreeshot("#MyProject_3_");

        // Результат работы теста assertions по url
        String resUrl = "https://www.saucedemo.com/";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }

    // #MyProject_4.Сортировка товаров витрины
    @Test
    @Description("#MyProject_4 Сортировка товаров витрины")
    @DisplayName("#MyProject_4 Сортировка товаров витрины")
    @Link("https://www.saucedemo.com/")
    @Issue("localhost")
    @Tag("sortItem")
    @Tag("#MyProject_4")
    @Severity(SeverityLevel.NORMAL)
    void sortItem() throws InterruptedException, IOException {
        WorkWithApp workWithApp = new WorkWithApp(getDriver());
        workWithApp                     // Ввод данных
                .inputUsername("standard_user")
                .inputPassword("secret_sauce")
                .clickLoginButton()     // Аутентификация пользователя
                .sleep(getDelay())
                .selectFieldSort()      // Проверка доступности меню сортировки товаров на странице витрины
                .sleep(getDelay() * 4);

        getScreeshot("#MyProject_4_");
        workWithApp
                .sortByAZ()             // Сортировка в прямом алфавитном порядке
                .sleep(getDelay() * 4);

        getScreeshot("#MyProject_4_");
        workWithApp
                .sortByZA()             // Сортировка в обратном алфавитном порядке
                .sleep(getDelay() * 4);

        getScreeshot("#MyProject_4_");
        workWithApp
                .sortByHilo()           // Сортировка в порядке убывания цены
                .sleep(getDelay() * 4);

        getScreeshot("#MyProject_4_");
        workWithApp
                .sortByLohi()          // Сортировка в порядке возрастания цены
                .sleep(getDelay() * 5);

        getScreeshot("#MyProject_4_");

        // Результат работы теста assertions по url
        String resUrl = "https://www.saucedemo.com/inventory.html";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }

    // #MyProject_5.Добавление товаров в корзину
    @Test
    @Description("#MyProject_5 Добавление товаров в корзину")
    @DisplayName("#MyProject_5 Добавление товаров в корзину")
    @Link("https://www.saucedemo.com/")
    @Issue("localhost")
    @Tag("aadItemInBasket")
    @Tag("#MyProject_5")
    @Severity(SeverityLevel.CRITICAL)
    void aadItemInBasket() throws InterruptedException, IOException {
        WorkWithApp workWithApp = new WorkWithApp(getDriver());
        workWithApp                     // Ввод данных
                .inputUsername("standard_user")
                .inputPassword("secret_sauce")
                .clickLoginButton()     // Аутентификация пользователя
                .sleep(getDelay() * 3)
                .addToCartItem("sauce-labs-backpack")   // Добавление товаров витрины в корзину
                .addToCartItem("sauce-labs-onesie")
                .addToCartItem("sauce-labs-fleece-jacket")
                .sleep(getDelay() * 2)
                .openShoppingCart()     // Переход в корзину
                .sleep(getDelay() * 4)
                .removeItemInCart("sauce-labs-onesie")
                .removeItemInCart("sauce-labs-backpack")
                .continueShopping()    // Возврат к покупкам
                .sleep(getDelay() * 3)
                .addToCartItem("sauce-labs-bike-light")
                .openShoppingCart()     // Переход в корзину
                .sleep(getDelay() * 4)
                .openMainMenu()         // Переход в главное меню
                .sleep(getDelay() * 2)
                .loguot()               // Выход из витрины
                .sleep(getDelay() * 5)
                .inputUsername("standard_user")     // Ввод данных
                .inputPassword("secret_sauce")
                .clickLoginButton()     // Аутентификация пользователя
                .openShoppingCart()
                .sleep(getDelay() * 3)
                .removeItemInCart("sauce-labs-fleece-jacket")
                .removeItemInCart("sauce-labs-bike-light")
                .sleep(getDelay() * 5);

        getScreeshot("#MyProject_5_");

        // Результат работы теста assertions по url
        String resUrl = "https://www.saucedemo.com/cart.html";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }

    // #MyProject_6.Оформление заказа
    @Test
    @Description("#MyProject_6 Оформление заказа")
    @DisplayName("#MyProject_6 Оформление заказа")
    @Link("https://www.saucedemo.com/")
    @Issue("localhost")
    @Tag("createOrder")
    @Tag("#MyProject_6")
    @Severity(SeverityLevel.CRITICAL)
    void createOrder() throws InterruptedException, IOException {
        WorkWithApp workWithApp = new WorkWithApp(getDriver());
        workWithApp                     // Ввод данных
                .inputUsername("standard_user")
                .inputPassword("secret_sauce")
                .clickLoginButton()     // Аутентификация пользователя
                .sleep(getDelay())
                .addToCartItem("sauce-labs-onesie")         // Добавление товаров витрины в корзину
                .addToCartItem("sauce-labs-fleece-jacket")
                .sleep(getDelay() * 2)
                .openShoppingCart()                         // Переход в корзину
                .sleep(getDelay() * 2)
                .checkout()             // Переход к оформлению заказа
                .sleep(getDelay() * 3)
                .inputFirstName("Ivan")   // Заполнить тектовые поля с информацией о новом пользователе:
                .inputLastName("Ivanov")
                .inputPostCode("E77777")
                .sleep(getDelay())
                .continueProc()
                .sleep(getDelay() * 4)
                .goToFotter()           // Переход в футер: cкролл странцы
                .finishProc()
                .goToHeader()
                .sleep(getDelay() * 4)
                .backToProducts()       // Назад к покупкам
                .sleep(getDelay() * 5);

        getScreeshot("#MyProject_6_");

        // Результат работы теста assertions по url
        String resUrl = "https://www.saucedemo.com/inventory.html";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }

    // #MyProject_7.Проверка работы кнопки главного меню "Reset App State"
    @Test
    @Description("#MyProject_7 Проверка работы кнопки главного меню \"Reset App State\"")
    @DisplayName("#MyProject_7 Проверка работы кнопки главного меню \"Reset App State\"")
    @Link("https://www.saucedemo.com/")
    @Issue("localhost")
    @Tag("resetAppState")
    @Tag("#MyProject_7")
    @Severity(SeverityLevel.MINOR)
    void resetAppState() throws InterruptedException, IOException {
        WorkWithApp workWithApp = new WorkWithApp(getDriver());
        workWithApp                         // Ввод данных
                .inputUsername("standard_user")
                .inputPassword("secret_sauce")
                .sleep(getDelay())
                .clickLoginButton()         // Аутентификация пользователя
                .openShoppingCart()         // Переход в корзину
                .sleep(getDelay() * 3)
                .closeShoppingCart()        // Возврат к покупкам
                .sleep(getDelay() * 3)
                .addToCartItem("sauce-labs-backpack")       // Добавление товаров витрины в корзину
                .sleep(getDelay() * 3)
                .addToCartItem("sauce-labs-onesie")
                .sleep(getDelay() * 3)
                .addToCartItem("sauce-labs-fleece-jacket")
                .sleep(getDelay() * 5)
                .openMainMenu()             // Переход в главное меню
                .sleep(getDelay() * 5)
                .resetUI()                  // Сброс приложения
                .openShoppingCart()         // Переход в корзину
                .sleep(getDelay() * 6);

        getScreeshot("#MyProject_7_");

        // Результат работы теста assertions по url
        String resUrl = "https://www.saucedemo.com/cart.html";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }
}
