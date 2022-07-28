package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    final public static String URL = MainPage.URL + "forgot-password";

    // локатор ссылки <Войти>
    @FindBy(how = How.XPATH,using = ("//a[text()='Войти']"))
    private SelenideElement loginLink;

    // Метод клика по ссылке <Войти>
    public LoginPage clickLoginLink() {
        loginLink.click();
        return Selenide.page(LoginPage.class);
    }
}
