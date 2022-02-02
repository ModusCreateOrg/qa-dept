package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage {

    @FindBy(css = ".example h3")
    WebElement pageTitle;
    @FindBy(xpath = "/html/body/div[2]/div/div/form/input[1]")
    WebElement check1;

    public String getTitleText () {
        return pageTitle.getText();
    }


    public void clickCheckbox(){
    check1.click();
    }

}
