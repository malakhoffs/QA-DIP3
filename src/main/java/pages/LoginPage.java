package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;
    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    private final By enterLabel = By.xpath("//h2[contains(text(), 'Вход')]");
    private final By inputEmailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By inputPasswordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By logInButton = By.xpath("//button[contains(text(), 'Войти')]");
    private final By registerButton = By.xpath("//a[contains(text(), 'Зарегистрироваться')]");
    private final By recoverPasswordButton = By.xpath("//a[contains(text(), 'Восстановить пароль')]");
    private final By recoverLoginButton = By.xpath("//a[contains(text(), 'Войти')]");

    @Step("Filling email field")
    public void fillEmailField(String login) {
        driver.findElement(inputEmailField).sendKeys(login);
    }
    @Step("Filling password field")
    public void fillPasswordField(String password) {
        driver.findElement(inputPasswordField).sendKeys(password);
    }
    @Step("Waiting for login page is visible")
    public void waitForLoginPageIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(inputEmailField));
    }
    @Step("Log in button click")
    public void logInButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logInButton));
        driver.findElement(logInButton).click();
    }
    @Step("Entering label View")
    public String enterLabelView() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterLabel));
        return driver.findElement(enterLabel).getText();
    }
    @Step("Recover password button click")
    public void recoverPasswordButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(recoverPasswordButton));
        driver.findElement(recoverPasswordButton).click();
    }
    @Step("Enter button click")
    public void recoverLoginButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.elementToBeClickable(recoverLoginButton));
        driver.findElement(recoverLoginButton).click();
    }
    @Step("Registration button click")
    public void registerButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }


}

