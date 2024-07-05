import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class IncorrectRegistrationTest extends BaseTest {

    @Test
    @DisplayName("Register with short password")
    @Description("Checking that user can not be created with password less than 6 chars")
    public void shortPasswordTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.accountUpperButtonClick();
        loginPage.registerButtonClick();
        registerPage.fillRegisterNameInput();
        registerPage.fillRegisterEmailInput();
        registerPage.fillRegisterShortPasswordInput();
        registerPage.clickRegisterButton();
        Assert.assertEquals(registerPage.incorrectPasswordView(), "Некорректный пароль");
    }
}
