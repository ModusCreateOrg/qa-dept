package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoverPage {



    @FindBy(css = ".example h3")
    WebElement pageTitle;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]")
    WebElement Avtar1;

    @FindBy (xpath = "/html/body/div[2]/div/div/div[1]/div/a")
    WebElement userProfile1;

    public String getTitleText () {
        return pageTitle.getText();
    }

    public void hoveractionOne(WebDriver driver){
        Actions act=  new Actions(driver);
        act.moveToElement(Avtar1).perform();

    }
    public void clickuser1(){userProfile1.click();}

}
