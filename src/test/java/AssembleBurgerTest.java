import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;


public class AssembleBurgerTest extends BaseTest {

    @Test
    @DisplayName("Burger parts scroll")
    @Description("Checking that burger parts scrolls when clicking on sections")
    public void burgerPartsScrollTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.logoButtonClick();
        mainPage.sauceButtonClick();
        Assert.assertEquals(mainPage.sauceView(),"Соусы");
        mainPage.fillingButtonClick();
        Assert.assertEquals(mainPage.fillingView(),"Начинки");
        mainPage.bunButtonClick();
        Assert.assertEquals(mainPage.bunsView(),"Булки");
    }
}
