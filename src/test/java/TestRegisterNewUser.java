import PageObject.MainPage;
import TestModel.UserClient;
import TestModel.UserCredentials;
import TestModel.UserModel;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestRegisterNewUser extends BaseTest {

    private UserClient userClient;
    private UserCredentials creds;
    private UserModel userModel;
    private boolean afterToBeLaunched;

    @Before
    public void setUp() {
        afterToBeLaunched = true;
        userClient = new UserClient();
        userModel = UserModel.getRandom();
        creds = UserCredentials.from(userModel);
    }

    @After
    public void teardown() {
        if (!afterToBeLaunched) {
            return;
        }
        String bearerToken = userClient.login(creds)
                .then().log().all()
                .extract()
                .path("accessToken");
        userClient.delete(userModel.getEmail(), bearerToken);
    }

    /**
     * открывается главная страница и создаётся экземпляр класса страницы
     * клик по кнопке 'Войти в аккаунт'
     * клик по ссылке 'Зарегистрироваться'
     * проверяем наличие кнопки 'Оформить заказ'
     */
    @Test
    @DisplayName("Check successfully registering a new user")
    public void successfullyRegisterNewUser() {
        final boolean orderButtonDisplayed = Selenide.open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegisterLink()
                .registerNewUser(userModel)
                .userLogin(userModel)
                .isOrderButtonDisplayed();
        assertTrue(orderButtonDisplayed);
    }

    /**
     * открывается главная страница и создаётся экземпляр класса страницы
     * клик по кнопке 'Войти в аккаунт'
     * клик по ссылке 'Зарегистрироваться'
     * проверяем видимость элемента 'Некорректный пароль'
     */
    @Test
    @DisplayName("Check registering a new user with an incorrect pass, with less than 6 symbols, fails")
    public void registerNewUserWithIncorrectPassFails() {
        userModel.setPassword("five");
        final boolean incorrectPasswordWarningDisplayed = Selenide.open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegisterLink()
                .registerNewUserWithIncorrectPass(userModel)
                .isIncorrectPassDisplayed();
        assertTrue(incorrectPasswordWarningDisplayed);
        afterToBeLaunched = false;
    }
}