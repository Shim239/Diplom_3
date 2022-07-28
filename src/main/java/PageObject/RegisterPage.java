package PageObject;

import TestModel.UserModel;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {

    final public static String URL = MainPage.URL + "register";

    // локатор поля для ввода имени
    @FindBy(how = How.XPATH,using =("//label[text()='Имя']//following-sibling::input"))
    private SelenideElement nameInputField;

    // локатор поля для ввода email
    @FindBy(how = How.XPATH,using =("//label[text()='Email']//following-sibling::input"))
    private SelenideElement emailInputField;

    // локатор поля для ввода пароля
    @FindBy(how = How.XPATH,using =("//input[@type='password']"))
    private SelenideElement passwordInputField;

    // локатор кнопки <зарегистрироваться>
    @FindBy(how = How.XPATH,using = ("//button[text()='Зарегистрироваться']"))
    private SelenideElement registerButton;

    // локатор текстового элемента <Некорректный пароль>
    @FindBy(how = How.XPATH,using = ("//p[text()='Некорректный пароль']"))
    private SelenideElement incorrectPasswordWarning;

    // локатор ссылки <Войти>
    @FindBy(how = How.XPATH,using = ("//a[text()='Войти']"))
    private SelenideElement loginLink;

    // метод заполнения поля ввода имени
    public RegisterPage inputName(String name) {
        nameInputField.sendKeys(name);
        return this;
    }

    // метод заполнения поля ввода email
    public RegisterPage inputEmail(String email) {
        emailInputField.sendKeys(email);
        return this;
    }

    // метод заполнения поля ввода пароля
    public RegisterPage inputPassword(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    // Метод клика по кнопке <Зарегистрироваться>
    public LoginPage clickRegisterButton() {
        registerButton.click();
        return Selenide.page(LoginPage.class);
    }

    // метод регистрации нового пользователя
    public LoginPage registerNewUser(UserModel user) {
        inputName(user.getName());
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        clickRegisterButton();
        return Selenide.page(LoginPage.class);
    }

    // метод регистрации нового пользователя с неверным паролем
    public RegisterPage registerNewUserWithIncorrectPass(UserModel user) {
        inputName(user.getName());
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        clickRegisterButton();
        return this;
    }

    // метод проверки видимости элемента <Некорректный пароль>
    public boolean isIncorrectPassDisplayed() {
        return incorrectPasswordWarning.shouldBe(visible).isDisplayed();
    }

    // Метод клика по ссылке <Войти>
    public LoginPage clickLoginLink() {
        loginLink.click();
        return Selenide.page(LoginPage.class);
    }
}
