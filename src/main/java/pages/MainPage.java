package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    WebDriver driver;
    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    private final By mainPageBurger = By.xpath(".//h1[text()='Соберите бургер']");
    private final By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div");
    private final By constructorButton = By.xpath("//p[text ()='Конструктор']");
    private final By upperAccountButton = By.xpath("//a[@class='AppHeader_header__link__3D_hX'][@href='/account']");
    private final By bottomAccountButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By bunButton = By.xpath("//span[contains(text(), 'Булки')]");
    private final By displayedBuns = By.xpath("//h2[contains(text(), 'Булки')]");
    private final By sauceButton = By.xpath("//span[contains(text(), 'Соусы')]");
    private final By displayedSauce = By.xpath("//h2[contains(text(), 'Соусы')]");
    private final By fillingButton = By.xpath("//span[contains(text(), 'Начинки')]");
    private final By displayedFilling = By.xpath("//h2[contains(text(), 'Начинки')]");

    @Step("Main page main view")
    public String enteringLabelView() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(mainPageBurger));
        return driver.findElement(mainPageBurger).getText();
    }
    @Step("Clicking on upper account button")
    public void accountUpperButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(upperAccountButton));
        driver.findElement(upperAccountButton).click();
    }
    @Step("Clicking on bottom account button")
    public void accountBottomButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bottomAccountButton));
        driver.findElement(bottomAccountButton).click();
    }
    @Step("Clicking on burger logo button")
    public void logoButtonClick() {
        driver.findElement(logoButton).click();
    }
    @Step("Clicking on constrictor button")
    public void constructorButton() {
        driver.findElement(constructorButton).click();
    }
    @Step("Clicking on bun button")
    public void bunButtonClick() {
        driver.findElement(bunButton).click();
    }
    @Step("Buns view")
    public String bunsView() {
        return driver.findElement(displayedBuns).getText();
    }
    @Step("Clicking on sauce button")
    public void sauceButtonClick() {
        driver.findElement(sauceButton).click();
    }
    @Step("Sauce view")
    public String sauceView() {
        return driver.findElement(displayedSauce).getText();
    }
    @Step("Clicking on filling button")
    public void fillingButtonClick() {
        driver.findElement(fillingButton).click();
    }
    @Step("Filling view")
    public String fillingView() {
        return driver.findElement(displayedFilling).getText();
    }
}
