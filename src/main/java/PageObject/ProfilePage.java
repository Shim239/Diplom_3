package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {

    final public static String URL = MainPage.URL + "profile";

    // локатор текстового элемента <В этом разделе вы можете изменить свои персональные данные>
    @FindBy(how = How.XPATH,using = ("//p[text()='В этом разделе вы можете изменить свои персональные данные']"))
    private SelenideElement profileText;

    // локатор элемента <Конструктор>
    @FindBy(how = How.XPATH,using = ("//p[text()='Конструктор']"))
    private SelenideElement createBurger;

    // локатор элемента логотип <Stellar Burgers>
    @FindBy(how = How.XPATH,using =("//div[@class='AppHeader_header__logo__2D0X2']/a"))
    private SelenideElement burgerLogo;

    // локатор кнопки <Выход>
    @FindBy(how = How.XPATH,using = ("//button[text()='Выход']"))
    private SelenideElement logoutButton;

    // Метод проверки видимости текстового элемента <В этом разделе вы можете изменить свои персональные данные>
    public boolean isProfileTextDisplayed() {
        return profileText.shouldBe(visible).isDisplayed();
    }

    // Метод клика по элементу <Конструктор>
    public MainPage clickCreateBurger() {
        createBurger.click();
        return Selenide.page(MainPage.class);
    }

    // Метод клика по элементу логотип <Stellar Burgers>
    public MainPage clickBurgerLogo() {
        createBurger.click();
        return Selenide.page(MainPage.class);
    }

    // Метод клика по кнопке <Выход>
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return Selenide.page(LoginPage.class);
    }
}
