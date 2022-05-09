package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.example.TestForCRM.AddAccountInCRM;
import org.example.TestForCRM.AddUserInCRM;
import org.example.TestForCRM.DelUserInCRM;
import com.beust.jcommander.Parameter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import java.io.IOException;

/**
 * Тесты для https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
 */

@Story("Набор тестов для CRM")
public class AppTestForCRM extends AbstractTestsForCRM {

    public static int delay = 200;

    public static int getDelay() {
        return delay;
    }

    // #CRM1.1.Добавление нового пользователя в CRM (валидные данные)
    @Test
    @DisplayName("#CRM1.1.Добавление нового пользователя в CRM (валидные данные)")
    @Description("#CRM1.1.Добавление нового пользователя в CRM (валидные данные)")
    @Link("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("localhost")
    @Tag("addUserInCRM")
    @Severity(SeverityLevel.CRITICAL)
    void addUserInCRM() throws InterruptedException, IOException {
        AddUserInCRM addUserInCRM = new AddUserInCRM(getDriver());
        addUserInCRM
                .clickBtnBankManagerLogin()     // Переход в меню "Bank Manager Login"
                .sleep(getDelay())
                .clickBtnCustomer()             // На странице "Bank Manager Login" переход в меню "Customers" для просмотра информации о пользователях
                .sleep(getDelay())
                .clickBtnAddCustomer()          // На странице "Bank Manager Login" переход в меню "Add Customer" для добавления нового пользователя
                .sleep(getDelay())
                .inputFistName("Ivan")            // Заполнение текстовых полей информацией о новом пользователе
                .inputLastName("Ivanov")
                .inputPostCode("E77777")
                .sleep(getDelay())
                .clickBtnAddCustomerForm()     // Добавление пользователя: нажатие кнопки 'Add Customer'
                .sleep(getDelay())
                .acceptJavaScript()            // Подтверждение сообщения
                .sleep(getDelay())
                .clickBtnCustomer()            // На странице "Bank Manager Login" переход в меню "Customers" для просмотра информации о пользователях
                .sleep(getDelay())
                .inputInSearchField("Ivan")     // Выбор поля для поиска: поиск по значению "name", просмотр переченя клиентов
                .sleep(getDelay() * 4);

        getScreeshot("#CRM1.1.CRM_");

        // Пример assertions по url
        String resUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }

    // #CRM1.2.Повторное добавление уже имеющегося пользователя пользователя в CRM (валидные данные)
    @Test
    @DisplayName("#CRM1.2.Повторное добавление уже имеющегося пользователя в CRM")
    @Description("#CRM1.2.Повторное добавление уже имеющегося пользователя в CRM")
    @Link("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("localhost")
    @Tag("addUserInCRM")
    @Severity(SeverityLevel.CRITICAL)
    void repeatAddUserInCRM() throws InterruptedException, IOException {
        AddUserInCRM repeatAddUserInCRM = new AddUserInCRM(getDriver());
        repeatAddUserInCRM
                .clickBtnBankManagerLogin()     // Переход в меню "Bank Manager Login"
                .sleep(getDelay())
                .clickBtnCustomer()            // На странице "Bank Manager Login" переход в меню "Customers"
                .sleep(getDelay());                 // для просмотра информации о пользователях

        for(int i=0; i < 2; i++)
            repeatAddUserInCRM
                    .clickBtnAddCustomer()          // На странице "Bank Manager Login" переход в меню "Add Customer" для добавления нового пользователя
                    .sleep(getDelay())
                    .inputFistName("Ivan")            // Заполнение текстовых полей информацией о новом пользователе
                    .inputLastName("Ivanov")
                    .inputPostCode("E77777")
                    .sleep(getDelay())
                    .clickBtnAddCustomerForm()     // Добавление пользователя: нажатие кнопки 'Add Customer'
                    .sleep(getDelay())
                    .acceptJavaScript()            // Подтверждение сообщения
                    .sleep(getDelay())
                    .clickBtnCustomer()            // На странице "Bank Manager Login" переход в меню "Customers" для просмотра информации о пользователях
                    .sleep(getDelay())
                    .inputInSearchField("Ivan")    // Выбор поля для поиска: поиск по значению "name", просмотр переченя клиентов
                    .sleep(getDelay());

        getScreeshot("#CRM1.2.CRM_");

        // Пример assertions по url
        String resUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }

    // #CRM1.3.Добавление нового пользователя в CRM (невалидные данные по каждому полей)
    @ParameterizedTest
    @DisplayName("#CRM1.3. Добавление нового пользователя в CRM (невалидные данные по каждому из полей)")
    @Description("#CRM1.3. Добавление нового пользователя в CRM (невалидные данные по каждому из полей)")
    //@Feature("#CRM1.3. Добавление нового пользователя в CRM (невалидные данные по каждому из полей)")
    @Link("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("localhost")
    @Tag("addUserInCRMWithInvalidData")
    @Parameter
    @CsvSource({"1, Ivanov, E77777",
                "Ivan, 2, E77777",
                "Ivan, Ivanov, 3",
                "0, 0, 0"})
    @Severity(SeverityLevel.CRITICAL)
    void addUserInCRMWithInvalidData(Object name, Object surname, Object postcode) throws InterruptedException, IOException {
        AddUserInCRM addUserInCRM = new AddUserInCRM(getDriver());
        addUserInCRM
                .clickBtnBankManagerLogin()     // Переход в меню "Bank Manager Login"
                .clickBtnCustomer()             // На странице "Bank Manager Login" переход в меню "Customers" для просмотра информации о пользователях
                .clickBtnAddCustomer()          // На странице "Bank Manager Login" переход в меню "Add Customer" для добавления нового пользователя
                .inputFistName(name.toString())            // Заполнение текстовых полей информацией о новом пользователе
                .inputLastName(surname.toString())
                .inputPostCode(postcode.toString())
                .clickBtnAddCustomerForm()     // Добавление пользователя: нажатие кнопки 'Add Customer'
                .acceptJavaScript()            // Подтверждение сообщения
                .clickBtnCustomer()            // На странице "Bank Manager Login" переход в меню "Customers" для просмотра информации о пользователях
                .inputInSearchField(name.toString())     // Выбор поля для поиска: поиск по значению "name", просмотр переченя клиентов
                .sleep(getDelay() * 2);

        getScreeshot("#CRM1.3.CRM_");

        // Пример assertions для элемента
        boolean resultTest = getDriver().findElement(By.xpath("//tr[contains(.,'" + name + "')]")).getText().contains(name.toString()) ||
                             getDriver().findElement(By.xpath("//tr[contains(.,'" + name + "')]")).getText().contains(surname.toString()) ||
                             getDriver().findElement(By.xpath("//tr[contains(.,'" + name + "')]")).getText().contains(postcode.toString());

        Assertions.assertFalse(resultTest);
    }

    // #CRM2.Добавление банковского счета для пользователя
    @Test
    @DisplayName("#CRM2.Добавление банковского счета для пользователя")
    @Description("#CRM2.Добавление банковского счета для пользователя")
    @Link("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("localhost")
    @Tag("addAccountInCRM")
    @Severity(SeverityLevel.BLOCKER)
    void addAccountInCRM() throws InterruptedException, IOException {
        AddAccountInCRM addAccountInCRM = new AddAccountInCRM(getDriver());
        addAccountInCRM
                .clickBtnBankManagerLogin()     // Переход в меню "Bank Manager Login"
                .clickBtnCustomer()             // На странице "Bank Manager Login" переход в меню "Customers" для просмотра информации о пользователях
                .sleep(getDelay())
                .clickBtnAddCustomer()          // На странице "Bank Manager Login" переход в меню "Add Customer" для добавления нового пользователя
                .sleep(getDelay())
                .inputFistName("Ivan")            // Заполнение текстовых полей информацией о новом пользователе
                .inputLastName("Ivanov")
                .inputPostCode("E77777")
                .sleep(getDelay())
                .clickBtnAddCustomerForm()      // Добавление пользователя: нажатие кнопки 'Add Customer'
                .sleep(getDelay())
                .acceptJavaScript()             // Подтверждение сообщения
                .openAccount()                  // Переход в меню "Customers" для открытия счёта ("Open Account")
                .selectUser()                   // Выбор поля для поиска: просмотр переченя клинетов, выбор клиента
                .selectCurrency()               // Просмотр типов валютных счётов
                .sleep(getDelay())
                .clickBtnProcess()              // Открытие счёта
                .acceptJavaScript()             // Обработка исключения после появления окна c сообщением на странице
                .sleep(getDelay())
                .clickBtnCustomer()             // На странице "Bank Manager Login" переход в меню "Customers" для просмотра информации о пользователях
                .sleep(getDelay())
                .inputInSearchField("Ivan")    // Выбор поля для поиска: поиск по значению "name", просмотр переченя клиентов
                .sleep(getDelay() * 3);

        getScreeshot("#CRM2.CRM_");

        // Пример assertions по url
        String resUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }

    // #CRM3. Удаление пользователя
    @Test
    @DisplayName("#CRM3. Удаление пользователя")
    @Description("#CRM3. Удаление пользователя")
    @Link("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("localhost")
    @Tag("delUserInCRM")
    @Severity(SeverityLevel.NORMAL)
    void delUserInCRM() throws InterruptedException, IOException {
        DelUserInCRM delUserInCRM = new DelUserInCRM(getDriver());
        delUserInCRM
                .clickBtnBankManagerLogin()     // Переход в меню "Bank Manager Login"
                .clickBtnCustomer()
                .sleep(getDelay() * 3);

        getScreeshot("#CRM3.CRM_");

        delUserInCRM
                .deleteUser("Neville")
                .sleep(getDelay() * 3)
                .deleteUser("Ron")
                .sleep(getDelay() * 3)
                .deleteUser("Harry")         // На странице "Bank Manager Login" переход в меню "Customers"
                .sleep(getDelay() * 3);

        getScreeshot("#CRM3.CRM_");

        // Пример assertions по url
        String resUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";
        Assertions.assertEquals(resUrl, getDriver().getCurrentUrl());
    }
}
