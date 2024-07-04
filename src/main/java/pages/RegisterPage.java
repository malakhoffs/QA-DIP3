package pages;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    public RegisterPage (WebDriver driver){
        this.driver = driver;
    }
    protected static String randomName = RandomStringUtils.randomAlphabetic(8);
    protected static String randomMail = RandomStringUtils.randomAlphabetic(8) + "@some.com";
    protected static String randomPassword = RandomStringUtils.randomAlphabetic(8);
    public String getRandomMail(){
        return randomMail;
    }
    public String getRandomPassword(){
        return randomPassword;
    }

    private final By registerNameInput = By.xpath("//label[text()= 'Имя']/following-sibling::input");
    private final By registerEmailInput = By.xpath("//label[text()= 'Email']/following-sibling::input");
    private final By registerPasswordInput = By.xpath("//label[text()= 'Пароль']/following-sibling::input");
    private final By registerButton = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");
    private final By incorrectPassword = By.xpath("//*[contains(text() , 'Некорректный пароль')]");

    @Step("Filling new user name")
    public void fillRegisterNameInput() {
        driver.findElement(registerNameInput).sendKeys(randomName);
    }
    @Step("Filling new user email")
    public void fillRegisterEmailInput() {
        driver.findElement(registerEmailInput).sendKeys(randomMail);
    }
    @Step("Filling new user password")
    public void fillRegisterPasswordInput() {
        driver.findElement(registerPasswordInput).sendKeys(randomPassword);
    }
    @Step("Filling  short new user password")
    public void fillRegisterShortPasswordInput() {
        driver.findElement(registerPasswordInput).sendKeys("12345");
    }
    @Step("Clicking register button")
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }
    @Step("Message of incorrect password")
    public String incorrectPasswordView() {
        return driver.findElement(incorrectPassword).getText();
    }
}
