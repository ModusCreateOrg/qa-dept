import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.PrintStream;

public class SeleniumTests {

    WebDriver driver;

    HomePage homePage;
    ABtestPage abTestPage;
    CheckboxesPage checkboxesPage;
    DropDownPage dropdownpage;
    HoverPage hoverpage;

    @BeforeClass
    public void beforeClass () {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        homePage = PageFactory.initElements(driver, HomePage.class);
        abTestPage = PageFactory.initElements(driver, ABtestPage.class);
        checkboxesPage = PageFactory.initElements(driver, CheckboxesPage.class);
        dropdownpage = PageFactory.initElements(driver, DropDownPage.class);
        hoverpage = PageFactory.initElements(driver, HoverPage.class);
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
        Assert.assertTrue(checkboxesPage.getCheckboxState1());
    }
    @Test(priority = 3)
    public void unclickCheckbox2(){
        checkboxesPage.unclickSecondCheckbox();
        Assert.assertFalse(checkboxesPage.getCheckboxState2());
    }
    @Test(priority = 4)
    public void testNavigationToDropdownPage ()  {
        navigateBackHome();
        homePage.clickOption("Dropdown");
        Assert.assertEquals("Dropdown List", dropdownpage.getTitleText());
        dropdownpage.openDropDown();
        dropdownpage.selectOptions("Option 2");
        dropdownpage.openDropDown();
        System.out.println(dropdownpage.returnDropdownValue());
        Assert.assertEquals("Option 2", dropdownpage.returnDropdownValue());

    }
    @Test(priority = 5)
    public void testNavigationToHoverPage () throws InterruptedException {
        navigateBackHome();
        homePage.clickOption("Hovers");
        Assert.assertEquals("Hovers", hoverpage.getTitleText());
        Thread.sleep(1000);
        hoverpage.hoveractionOne(driver);
        hoverpage.clickuser1();
    }


    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
