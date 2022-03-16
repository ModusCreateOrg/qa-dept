import org.openqa.selenium.Keys;
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
    InputNumPage inputpage;
    KeyPress keypress;

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
        inputpage=PageFactory.initElements(driver, InputNumPage.class);
        keypress=PageFactory.initElements(driver, KeyPress.class);
    }
    public void navigateBackHome(){
        driver.get("http://the-internet.herokuapp.com/");
    }


    @Test
    public void testNavigationToABtestPage () {
        navigateBackHome();
        homePage.clickOption("A/B Testing");
        Assert.assertEquals("A/B Test Control", abTestPage.getTitleText());

    }



    @Test
    public void testNavigationToCheckboxesPage () throws InterruptedException {
        navigateBackHome();
        homePage.clickOption("Checkboxes");
        Assert.assertEquals("Checkboxes", checkboxesPage.getTitleText());
        Thread.sleep(1000);
        checkboxesPage.clickCheckbox();
        Assert.assertTrue(checkboxesPage.getCheckboxState1());
        checkboxesPage.unclickSecondCheckbox();
        Assert.assertFalse(checkboxesPage.getCheckboxState2());
    }


    @Test
    public void testNavigationToDropdownPage ()  {
        navigateBackHome();
        homePage.clickOption("Dropdown");
        Assert.assertEquals("Dropdown List", dropdownpage.getTitleText());
        dropdownpage.selectOptions("Option 2");
        Assert.assertEquals("Option 2", dropdownpage.returnDropdownValue());

    }
    @Test
    public void testNavigationToHoverPage () throws InterruptedException {
        navigateBackHome();
        homePage.clickOption("Hovers");
        Assert.assertEquals("Hovers", hoverpage.getTitleText());
        Thread.sleep(1000);
        hoverpage.hoveractionOne(driver);
        hoverpage.clickuser1();
    }
    @Test
    public void testInputPage()  {
        navigateBackHome();
        homePage.clickOption("Inputs");
        Assert.assertEquals("Inputs", inputpage.getTitleText());
       inputpage.enterNumber("99.9");
       Assert.assertEquals("99.9", inputpage.getEnteredValue());
    }

    @Test
    public void testKeyPress()  {
        navigateBackHome();
        homePage.clickOption("Key Presses");
        Assert.assertEquals("Key Presses", keypress.getTitleText());
        keypress.enterKey(Keys.SPACE);
        Assert.assertEquals("SPACE",keypress.getEnteredText());
    }


    @AfterClass
    public void afterClass () {
       driver.quit();
    }
}
