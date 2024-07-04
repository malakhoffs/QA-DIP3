import API.UserWipeStep;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

public class AuthorizationTest extends WebDriverSetup {

 String accessToken;

 @Before
 @DisplayName("Creating new user")
 @Description("Creating new user for log in tests")
 public void sectionTest() {
  RegisterPage registerPage = new RegisterPage(driver);
  MainPage mainPage = new MainPage(driver);
  LoginPage loginPage = new LoginPage(driver);

  mainPage.accountUpperButtonClick();
  loginPage.registerButtonClick();
  registerPage.fillRegisterNameInput();
  registerPage.fillRegisterEmailInput();
  registerPage.fillRegisterPasswordInput();
  registerPage.clickRegisterButton();
 }

 @Test
 @DisplayName("Log in from upper button and logout")
 @Description("Logging in by clicking the upper button then logout")
 public void upperButtonLogInTest() {
  MainPage mainPage = new MainPage(driver);
  RegisterPage registerPage = new RegisterPage(driver);
  LoginPage loginPage = new LoginPage(driver);
  PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

  //clicking logo button
  mainPage.logoButtonClick();

  //logging in
  mainPage.accountUpperButtonClick();
  loginPage.waitForLoginPageIsVisible();
  loginPage.fillEmailField(registerPage.getRandomMail());
  loginPage.fillPasswordField(registerPage.getRandomPassword());
  loginPage.logInButtonClick();

  //logging out
  mainPage.accountUpperButtonClick();
  personalAccountPage.quitPersonalAccount();
  Assert.assertEquals(loginPage.enterLabelView(), "Вход");
 }

 @Test
 @DisplayName("Log in from bottom button")
 @Description("Logging in by clicking button at the bottom")

 public void bottomButtonLogInTest() {
  MainPage mainPage = new MainPage(driver);
  RegisterPage registerPage = new RegisterPage(driver);
  LoginPage loginPage = new LoginPage(driver);

  //clicking logo button
  mainPage.logoButtonClick();

  //logging in
  mainPage.accountBottomButtonClick();
  loginPage.waitForLoginPageIsVisible();
  loginPage.fillEmailField(registerPage.getRandomMail());
  loginPage.fillPasswordField(registerPage.getRandomPassword());
  loginPage.logInButtonClick();
  Assert.assertEquals(mainPage.enteringLabelView(), "Соберите бургер");
 }

 @Test
 @DisplayName("Log in from recover password button")
 @Description("Logging in by clicking recover password button at authorization form also going to main page by clicking on constructor")

 public void recoverPasswordLogInTest() {
  MainPage mainPage = new MainPage(driver);
  RegisterPage registerPage = new RegisterPage(driver);
  LoginPage loginPage = new LoginPage(driver);

  //clicking constructor button
  mainPage.constructorButton();

  //logging in
  mainPage.accountUpperButtonClick();
  loginPage.waitForLoginPageIsVisible();
  loginPage.recoverPasswordButtonClick();
  loginPage.recoverLoginButtonClick();
  loginPage.fillEmailField(registerPage.getRandomMail());
  loginPage.fillPasswordField(registerPage.getRandomPassword());
  loginPage.logInButtonClick();
  Assert.assertEquals(mainPage.enteringLabelView(), "Соберите бургер");
 }

 @Test
 @DisplayName("Log in from registration page")
 @Description("Logging in by clicking authorization button at registration form also going to main page by clicking on logo")

 public void registrationFormLogInTest() {
  MainPage mainPage = new MainPage(driver);
  RegisterPage registerPage = new RegisterPage(driver);
  LoginPage loginPage = new LoginPage(driver);

  //clicking logo button
  mainPage.logoButtonClick();

  //logging in
  mainPage.accountUpperButtonClick();
  loginPage.waitForLoginPageIsVisible();
  loginPage.registerButtonClick();
  loginPage.recoverLoginButtonClick();
  loginPage.fillEmailField(registerPage.getRandomMail());
  loginPage.fillPasswordField(registerPage.getRandomPassword());
  loginPage.logInButtonClick();
  Assert.assertEquals(mainPage.enteringLabelView(), "Соберите бургер");
 }

 @After
 public void userRemove() {
  RegisterPage registerPage = new RegisterPage(driver);
  Response response = UserWipeStep.userCatchToken(registerPage.getRandomMail(),registerPage.getRandomPassword());
  accessToken = response.path("accessToken");
  UserWipeStep.userWipe(accessToken);
 }
}
