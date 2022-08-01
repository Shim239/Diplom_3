import PageObject.LoginPage;
import TestModel.UserClient;
import TestModel.UserCredentials;
import TestModel.UserModel;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestUserProfile extends BaseTest {

    private UserClient userClient;
    private UserModel userModel;
    private String bearerToken;

    @Before
    public void setUp() {
        userClient = new UserClient();
        userModel = UserModel.getRandom();
        UserCredentials creds = UserCredentials.from(userModel);
        userClient.registerNewUser(userModel);
        bearerToken = userClient.login(creds)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    @After
    public void teardown() {
        userClient.delete(userModel.getEmail(), bearerToken);
    }

    /**
     * открывается страница для входа и создаётся экземпляр класса страницы
     * вход пользователя
     * переход в Личный Кабинет
     * проверяем наличие текстового элемента <В этом разделе вы можете изменить свои персональные данные>
     */
    @Test
    @DisplayName("Check user is able to get into the user profile successfully")
    public void successfullyDisplayUserProfile() {
        final boolean profileTextDisplayed = Selenide.open(LoginPage.URL, LoginPage.class)
                .userLogin(userModel)
                .clickProfileLinkUserLogged()
                .isProfileTextDisplayed();
        assertTrue(profileTextDisplayed);
    }

    /**
     * открывается страница для входа и создаётся экземпляр класса страницы
     * вход пользователя
     * переход в Личный Кабинет
     * переход по ссылке 'Конструктор'
     * проверяем наличие текстового элемента 'Соберите бургер'
     */
    @Test
    @DisplayName("Check user is able to click the create burger link from the user profile page")
    public void successfullyDisplayCreateBurgerTextByClickingTheCreateBurgerLink() {
        final boolean createBurgerTextDisplayed = Selenide.open(LoginPage.URL, LoginPage.class)
                .userLogin(userModel)
                .clickProfileLinkUserLogged()
                .clickCreateBurger()
                .isCreateBurgerTextDisplayed();
        assertTrue(createBurgerTextDisplayed);
    }

    /**
     * открывается страница для входа и создаётся экземпляр класса страницы
     * вход пользователя
     * переход в Личный Кабинет
     * переход по ссылке из логотипа 'Stellar Burgers'
     * проверяем наличие текстового элемента 'Соберите бургер'
     */
    @Test
    @DisplayName("Check user is able to click the stellar burger logo from the user profile page")
    public void successfullyDisplayCreateBurgerTextByClickingTheBurgerLogo() {
        final boolean createBurgerTextDisplayed = Selenide.open(LoginPage.URL, LoginPage.class)
                .userLogin(userModel)
                .clickProfileLinkUserLogged()
                .clickBurgerLogo()
                .isCreateBurgerTextDisplayed();
        assertTrue(createBurgerTextDisplayed);
    }

    /**
     * открывается страница для входа и создаётся экземпляр класса страницы
     * вход пользователя
     * клик по кнопке 'Личный Кабинет'
     * клик по кнопке 'Выход'
     * проверяем наличие текстового элемента 'Вход'
     */
    @Test
    @DisplayName("Check user is able to logout successfully")
    public void successfullyLogoutUser() {
        final boolean userLoginTextDisplayed = Selenide.open(LoginPage.URL, LoginPage.class)
                .userLogin(userModel)
                .clickProfileLinkUserLogged()
                .clickLogoutButton()
                .isUserLoginTextDisplayed();
        assertTrue(userLoginTextDisplayed);
    }
}