package org.example.TestForMyProject;

import io.qameta.allure.Step;
import org.example.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkWithApp extends AbstractPage {

    public WorkWithApp(WebDriver driver) {
        super(driver);
    }

    // Атутентификация пользователя:
    @FindBy(xpath = "//input[@placeholder='Username']")     // Выбор поля для ввода логина
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@placeholder='Password']")     // Выбор поля для ввода пароля
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@value='Login']")              // Нажатие кнопки для входа
    private WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test='error']/button")      // Нажатие кнопки сброса после сбоя
    private WebElement reloadAuth;

    // Работа с главным меню:
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")    // Открытие главного меню
    private WebElement openMainMenu;
    @FindBy(xpath = "//button[@id='react-burger-cross-btn']")   // Закрытие главного меню
    private WebElement closeMainMenu;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")           // Выход из приложения
    private WebElement loguot;
    @FindBy(xpath = "//*[@id=\"reset_sidebar_link\"]")          // Сброс приложения
    private WebElement resetUI;

    // Работа с содержимым страницы приложения:
    @FindBy(xpath = "//div[@id='page_wrapper']/footer/div")     // Переход в футтер страницы
    private WebElement goToFotter;
    @FindBy(xpath = "//*[@id='header_container']")              // Переход в заголовок страницы
    private WebElement goToHeader;
    @FindBy(xpath = "//*[@id=\"back-to-products\"]")         // Возврат к покупкам из формы товара
    private WebElement backToProducts;
    @FindBy(xpath = "//*[@id='continue-shopping']")             // Возврат к покупкам из корзины
    private WebElement continueShopping;
    @FindBy(xpath = "//button[@id='checkout']")                 // Переход к оформлению заказа
    private WebElement checkout;
    @FindBy(xpath = "//input[@id='first-name']")                // Ввод имени при оформлении заказа
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='last-name']")                 // Ввод фамилии при оформлении заказа
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='postal-code']")               // Ввод индекса при оформлении заказа
    private WebElement postCode;
    @FindBy(xpath = "//input[@id='continue']")                  // Продолжение покупки
    private WebElement continueProc;
    @FindBy(xpath = "//button[@id='finish']")                   // Оформление заказа
    private WebElement finish;

    // Просмотр элементов:
    @FindBy(xpath = "//*[@id=\"item_4_img_link\"]/img")
    private WebElement viewItem4;
    @FindBy(xpath = "//*[@id=\"item_3_img_link\"]/img")
    private WebElement viewItem3;
    @FindBy(xpath = "//*[@id=\"item_2_img_link\"]/img")
    private WebElement viewItem2;

    // Разные варианты сортировки данных на странице:
    @FindBy(xpath = "//div[@id='header_container']/div[2]/div[2]/span/select")
    private WebElement selectFieldSort;
    @FindBy(xpath = "//*[@value='az']")
    private WebElement sortByAZ;
    @FindBy(xpath = "//*[@value='za']")
    private WebElement sortByZA;
    @FindBy(xpath = "//*[@value='lohi']")
    private WebElement sortByLohi;
    @FindBy(xpath = "//*[@value='hilo']")
    private WebElement sortByHilo;

    // Работа с корзиной:
    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")   // Открытие корзины
    private WebElement openShoppingCart;
    @FindBy(xpath = "//button[@id='continue-shopping']")        // Закрытие корзины
    private WebElement closeShoppingCart;

    // Добавление позиции в корзину:
    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartItemSauceLabsBackpack;
    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-onesie']")
    private WebElement addToCartItemSauceLabsOnesie;
    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement addToCartItemSauceLabsFleeceJacket;
    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement addToCartItemSauceLabsBikeLight;

    // Удаление позиций из корзины
    @FindBy(xpath = "//button[contains(.,'Remove') and @id='remove-sauce-labs-backpack']")
    private WebElement removeInCartSauceLabsBackpack;
    @FindBy(xpath = "//button[contains(.,'Remove') and @id='remove-sauce-labs-onesie']")
    private WebElement removeInCartSauceLabsOnesie;
    @FindBy(xpath = "//button[contains(.,'Remove') and @id='remove-sauce-labs-fleece-jacket']")
    private WebElement removeInCartSauceLabsFleeceJacket;
    @FindBy(xpath = "//button[contains(.,'Remove') and @id='remove-sauce-labs-bike-light']")
    private WebElement removeInCartSauceLabsBikeLight;

    //--------------------------------------------------------------------------------------------------------

    public WorkWithApp sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
        return this;
    }

    @Step("Ввод имени")
    // Атутентификация пользователя:
    public WorkWithApp inputUsername(String username){
        inputUsername.click();
        inputUsername.clear();
        inputUsername.sendKeys(username);
        return this;
    }

    @Step("Ввод пользователя")
    public WorkWithApp inputPassword(String password){
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки \"Login\"")
    public WorkWithApp clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Сброс аутентификации")
    public WorkWithApp clickReloadAuth() {
        reloadAuth.click();
        return this;
    }

    // Работа с главным меню:
    @Step("Открытие главного меню")
    public WorkWithApp openMainMenu() {
        openMainMenu.click();
        return this;
    }

    @Step("Закрытие главного меню")
    public WorkWithApp closeMainMenu() {
        closeMainMenu.click();
        return this;
    }

    @Step("Выход из приложения/аккаунта")
    public WorkWithApp loguot() {
        loguot.click();
        return this;
    }

    @Step("Сброс приложения")
    public WorkWithApp resetUI() {
        resetUI.click();
        return this;
    }

    @Step("Переход в футтер")
    // Работа с содержимым страницы приложения:
    public WorkWithApp goToFotter() {
        goToFotter.click();
        return this;
    }

    @Step("Переход в заголовок")
    public WorkWithApp goToHeader() {
        goToHeader.click();
        return this;
    }

    @Step("Возврат к товарам")
    public WorkWithApp backToProducts() {
        backToProducts.click();
        return this;
    }

    @Step("Продолжение покупок")
    public WorkWithApp continueShopping() {
        continueShopping.click();
        return this;
    }

    @Step("Переход к оформлению заказа")
    public WorkWithApp checkout() {
        checkout.click();
        return this;
    }

    @Step("Ввод имени")
    public WorkWithApp inputFirstName(String firstName) {
        this.firstName.click();
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        return this;
    }

    @Step("Ввод фамилии")
    public WorkWithApp inputLastName(String lastName) {
        this.lastName.click();
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        return this;
    }

    @Step("Ввод индекса")
    public WorkWithApp inputPostCode(String postCode) {
        this.postCode.click();
        this.postCode.clear();
        this.postCode.sendKeys(postCode);
        return this;
    }

    @Step("Продолжение покупок")
    public WorkWithApp continueProc() {
        continueProc.click();
        return this;
    }

    @Step("Завершение процедуры оформления заказа")
    public WorkWithApp finishProc() {
        this.finish.click();
        return this;
    }

    // Разные варианты сортировки данных на странице:
    @Step("Выбор поля для сортировки данных")
    public WorkWithApp selectFieldSort() {
        selectFieldSort.click();
        return this;
    }

    @Step("Сортировка в прямом алфавитном порядке")
    public WorkWithApp sortByAZ() {
        sortByAZ.click();
        return this;
    }

    @Step("Сортировка в обратном алфавитном порядке")
    public WorkWithApp sortByZA() {
        sortByZA.click();
        return this;
    }

    @Step("Сортировка в порядке возрастания цены")
    public WorkWithApp sortByLohi() {
        sortByLohi.click();
        return this;
    }

    @Step("Сортировка в порядке убывания цены")
    public WorkWithApp sortByHilo() {
        sortByHilo.click();
        return this;
    }

    // Работа с корзиной:
    @Step("Открытие корзины")
    public WorkWithApp openShoppingCart() {
        openShoppingCart.click();
        return this;
    }

    @Step("Закрытие корзины")
    public WorkWithApp closeShoppingCart() {
        closeShoppingCart.click();
        return this;
    }

    @Step("Добавление товара в корзину")
    public WorkWithApp addToCartItem(String item) {
        if (item.contains("sauce-labs-backpack")) addToCartItemSauceLabsBackpack.click();
        if (item.contains("sauce-labs-onesie")) addToCartItemSauceLabsOnesie.click();
        if (item.contains("sauce-labs-fleece-jacket")) addToCartItemSauceLabsFleeceJacket.click();
        if (item.contains("sauce-labs-bike-light")) addToCartItemSauceLabsBikeLight.click();
        return this;
    }

    @Step("Удаления товара из корзины")
    public WorkWithApp removeItemInCart(String item) {
        if (item.contains("sauce-labs-backpack")) removeInCartSauceLabsBackpack.click();
        if (item.contains("sauce-labs-onesie")) removeInCartSauceLabsOnesie.click();
        if (item.contains("sauce-labs-fleece-jacket")) removeInCartSauceLabsFleeceJacket.click();
        if (item.contains("sauce-labs-bike-light")) removeInCartSauceLabsBikeLight.click();
        return this;
    }

    @Step("Просмотр информации о товаре")
    public WorkWithApp viewItem(int item) {
        if (item == 2) viewItem2.click();
        if (item == 3) viewItem3.click();
        if (item == 4) viewItem4.click();
        return this;
    }
}
