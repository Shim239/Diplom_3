package PageObject;

import TestModel.UserModel;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    final public static String URL = MainPage.URL + "login";

    // локатор ссылки <Восстановить пароль>
    @FindBy(how = How.XPATH,using = ("//a[text()='Восстановить пароль']"))
    private SelenideElement restorePasswordLink;

    // локатор ссылки <Зарегистрироваться>
    @FindBy(how = How.XPATH,using = ("//a[text()='Зарегистрироваться']"))
    private SelenideElement registerLink;

    // локатор кнопки <Войти>
    @FindBy(how = How.XPATH,using = ("//button[text()='Войти']"))
    private SelenideElement loginButton;

    // локатор поля для ввода email
    @FindBy(how = How.XPATH,using =("//label[@class='input__placeholder text noselect text_type_main-default'][text()" +
            "='Email']/parent::div/input"))
    private SelenideElement emailInputField;

    // локатор поля для ввода пароля
    @FindBy(how = How.XPATH,using =("//label[@class='input__placeholder text noselect text_type_main-default'][text()" +
            "='Пароль']/parent::div/input"))
    private SelenideElement passwordInputField;

    // локатор текстового элемента <Вход>
    @FindBy(how = How.XPATH,using = ("//h2[text()='Вход']"))
    private SelenideElement userLoginText;

    // Метод клика по ссылке <Зарегистрироваться>
    public RegisterPage clickRegisterLink() {
        registerLink.shouldBe(visible).click();
        return Selenide.page(RegisterPage.class);
    }

    // Метод клика по ссылке <Восстановить пароль>
    public ForgotPasswordPage clickRestorePasswordLink() {
        restorePasswordLink.click();
        return Selenide.page(ForgotPasswordPage.class);
    }

    // Метод клика по кнопке <Войти>
    public MainPage clickLoginButton() {
        loginButton.click();
        return Selenide.page(MainPage.class);
    }

    // метод заполнения поля ввода email
    public LoginPage inputEmail(String email) {
        emailInputField.sendKeys(email);
        return this;
    }

    // метод заполнения поля ввода пароля
    public LoginPage inputPassword(String password) {
        passwordInputField.sendKeys(password);
        return this;    }


    // метод заполнения полей входа пользователя
    public MainPage userLogin(UserModel user) {
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        clickLoginButton();
        return Selenide.page(MainPage.class);
    }

    // Метод проверки видимости текстового элемента <Вход>
    public boolean isUserLoginTextDisplayed() {
        return userLoginText.shouldBe(visible).isDisplayed();
    }
}
