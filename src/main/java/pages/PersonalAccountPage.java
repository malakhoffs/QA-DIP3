package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    WebDriver driver;
        public PersonalAccountPage (WebDriver driver){
            this.driver = driver;
        }
        private final By accountQuitButton = By.xpath("//button[contains(text(), 'Выход')]");
    @Step("Quiting personal account")
    public void quitPersonalAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(accountQuitButton));
        driver.findElement(accountQuitButton).click();
    }
}
