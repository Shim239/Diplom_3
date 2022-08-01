package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    // локатор кнопки <Войти в аккаунт>
    @FindBy(how = How.XPATH,using = ("//button[text()='Войти в аккаунт']"))
    private SelenideElement loginButton;

    // локатор кнопки <Оформить заказ>
    @FindBy(how = How.XPATH,using = ("//button[text()='Оформить заказ']"))
    private SelenideElement orderButton;

    // локатор ссылки для входа <Личный Кабинет>
    @FindBy(how = How.XPATH,using = ("//p[text()='Личный Кабинет']"))
    private SelenideElement profileLink;

    // локатор элемента <Соберите бургер>
    @FindBy(how = How.XPATH,using = ("//h1[text()='Соберите бургер']"))
    private SelenideElement createBurgerText;

    // локатор раздела <Булки>
    @FindBy(how = How.XPATH,using = ("//span[text()='Булки']//parent::div"))
    private SelenideElement bunsTab;

    // локатор раздела <Соусы>
    @FindBy(how = How.XPATH,using = ("//span[text()='Соусы']//parent::div"))
    private SelenideElement saucesTab;

    // локатор раздела <Начинки>
    @FindBy(how = How.XPATH,using = ("//span[text()='Начинки']//parent::div"))
    private SelenideElement fillingsTab;

    // локатор для списка ингредиентов
    @FindBy(how = How.CLASS_NAME,using = "BurgerIngredients_ingredients__list__2A-mT")
    private SelenideElement ingredientsScrollDown;

    // метод клика по кнопке <Войти в аккаунт>
    public LoginPage clickLoginButton() {
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }

    // метод клика по кнопке <Оформить заказ>
    public LoginPage clickOrderButton() {
        orderButton.click();
        return Selenide.page(LoginPage.class);
    }

    // метод проверки видимости кнопки <Оформить заказ>
    public boolean isOrderButtonDisplayed() {
        return orderButton.shouldBe(visible).isDisplayed();
    }

    // метод клика по ссылке <Личный Кабинет>
    public LoginPage clickProfileLink() {
        profileLink.click();
        return Selenide.page(LoginPage.class);
    }

    // метод клика по ссылке <Личный Кабинет> при залогиненом пользователе
    public ProfilePage clickProfileLinkUserLogged() {
        profileLink.click();
        return Selenide.page(ProfilePage.class);
    }

    // метод проверки видимости текстового элемента <Соберите бургер>
    public boolean isCreateBurgerTextDisplayed() {
        return createBurgerText.shouldBe(visible).isDisplayed();
    }

    // метод клика по ссылке <Булки>
    public MainPage displayAvailableBuns() {
        bunsTab.click();
        Selenide.sleep(3000);
        return this;
    }

    // метод клика по ссылке <Соусы>
    public MainPage displayAvailableSauces() {
        saucesTab.click();
        Selenide.sleep(3000);
        return this;
    }

    // метод клика по ссылке <Начинки>
    public MainPage displayAvailableFillings() {
        fillingsTab.click();
        Selenide.sleep(3000);
        return this;
    }

    // метод проверки, что вкладка <Булки> является активной
    public String getBunsTabClassValue() {
        return bunsTab.getAttribute("class");
    }

    // метод проверки, что вкладка <Соусы> является активной
    public String getSaucesTabClassValue() {
        return saucesTab.getAttribute("class");
    }

    // метод проверки, что вкладка <Начинки> является активной
    public String getFillingsTabClassValue() {
        return fillingsTab.getAttribute("class");
    }
}
