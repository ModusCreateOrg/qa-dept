import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ABtestPage;
import pageObjects.HomePage;

public class SeleniumTests {

    WebDriver driver;

    HomePage homePage;
    ABtestPage abTestPage;

    @BeforeClass
    public void beforeClass () {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        homePage = PageFactory.initElements(driver, HomePage.class);
        abTestPage = PageFactory.initElements(driver, ABtestPage.class);
    }

    @Test
    public void testNavigationToABtestPage () {
        homePage.clickOption("A/B Testing");
        Assert.assertEquals("A/B Test Control", abTestPage.getTitleText());
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
