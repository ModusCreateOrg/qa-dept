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
import pageObjects.CheckboxesPage;
import pageObjects.HomePage;

public class SeleniumTests {

    WebDriver driver;

    HomePage homePage;
    ABtestPage abTestPage;
    CheckboxesPage checkboxesPage;

    @BeforeClass
    public void beforeClass () {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        homePage = PageFactory.initElements(driver, HomePage.class);
        abTestPage = PageFactory.initElements(driver, ABtestPage.class);
        checkboxesPage = PageFactory.initElements(driver, CheckboxesPage.class);
    }
    public void navigateBackHome(){
        driver.get("http://the-internet.herokuapp.com/");
    }


    @Test(priority = 0)
    public void testNavigationToABtestPage () {
        homePage.clickOption("A/B Testing");
        Assert.assertEquals("A/B Test Control", abTestPage.getTitleText());

    }



    @Test(priority = 1)
    public void testNavigationToCheckboxesPage () throws InterruptedException {
        navigateBackHome();
        homePage.clickOption("Checkboxes");
        Assert.assertEquals("Checkboxes", checkboxesPage.getTitleText());
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void clickCheckboxes(){

        checkboxesPage.clickCheckbox();
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
