import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverSetup {

    WebDriver driver;
    //type here what driver to use "Chrome" or "Edge"
    String usingDriver = "Chrome";
    //Main driver and URL
    @Before
    public void driverToUse() {
        if (usingDriver.equals("Chrome")) {
            driver = new ChromeDriver();
        }
        if (usingDriver.equals("Edge")) {
            driver = new EdgeDriver();
        }
        driver.get("https://stellarburgers.nomoreparties.site");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}