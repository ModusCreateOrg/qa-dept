package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABtestPage {

    @FindBy (css = ".example h3")
    WebElement pageTitle;

    public String getTitleText () {
        return pageTitle.getText();
    }
}
