import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    @Before
    public void startup() {
        System.setProperty("selenide.browser", "chrome");
    }

    @After
    public void teardown() {
        Selenide.closeWindow();
    }
}