package org.example.TestForCRM;

import io.qameta.allure.Step;
import org.example.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserInCRM extends AbstractPage {

    public AddUserInCRM sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
        return this;
    }

    public AddUserInCRM(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(.,'Bank Manager Login')]")
    private WebElement btnBankManagerLogin;
    @FindBy(xpath = "//button[contains(.,'Customers')]")
    private WebElement btnCustomer;
    @FindBy(xpath = "//button[contains(.,'Add Customer')]")
    private WebElement btnAddCustomer;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement inputFistName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement inputLastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement inputPostCode;
    @FindBy(xpath = "//form/button[contains(.,'Add Customer')]")
    private WebElement btnAddCustomerForm;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchField;

    @Step("Нажатие по кнопке \"Bank Manager Login\"")
    public AddUserInCRM clickBtnBankManagerLogin() {
        this.btnBankManagerLogin.click();
        return this;
    }

    @Step("Нажатие по кнопке \"Customers\"")
    public AddUserInCRM clickBtnCustomer() {
        this.btnCustomer.click();
        return this;
    }

    @Step("Нажатие по кнопке \"Add Customer\"")
    public AddUserInCRM clickBtnAddCustomer() {
        this.btnAddCustomer.click();
        return this;
    }

    @Step("Ввод имени")
    public AddUserInCRM inputFistName(String firstName) {
        this.inputFistName.click();
        this.inputFistName.clear();
        this.inputFistName.sendKeys(firstName);
        return this;
    }

    @Step("Ввод фамилии")
    public AddUserInCRM inputLastName(String lastName) {
        this.inputLastName.click();
        this.inputLastName.clear();
        this.inputLastName.sendKeys(lastName);
        return this;
    }

    @Step("Ввод индекса")
    public AddUserInCRM inputPostCode(String postCode) {
        this.inputPostCode.click();
        this.inputPostCode.clear();
        this.inputPostCode.sendKeys(postCode);
        return this;
    }

    @Step("Нажатие по кнопке \"Add Customer\"")
    public AddUserInCRM clickBtnAddCustomerForm() {
        this.btnAddCustomerForm.click();
        return this;
    }

    @Step("Обработка javaScript")
    public AddUserInCRM acceptJavaScript() throws InterruptedException {
        actionAcceptJavaScript();
        return this;
    }

    @Step("Ввод данных в поле для поиска")
    public AddUserInCRM inputInSearchField(String firstName) {
        this.searchField.click();
        this.searchField.clear();
        this.searchField.sendKeys(firstName);
        return this;
    }

    // Пример набора заглушек вынесенных в отдельный класс AddAccountInCRM:
    @Step("Открытие аккаунта")
    public AddUserInCRM openAccount(){
        return this;
    }

    @Step("Выбор пользователя")
    public AddUserInCRM selectUser() {
        return this;
    }

    @Step("Выбор валюты")
    public AddUserInCRM selectCurrency() {
        return this;
    }

    @Step("Нажатие кнопки \"Process\"")
    public AddUserInCRM clickBtnProcess() {
        return this;
    }

    @Step("Удаление пользователя")
    public AddUserInCRM deleteUser(String firstName) {
       return this;
    }
}
