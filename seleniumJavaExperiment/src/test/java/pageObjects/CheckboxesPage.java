package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage {

    @FindBy(css = ".example h3")
    WebElement pageTitle;
    @FindBy(xpath = "/html/body/div[2]/div/div/form/input[1]")
    WebElement check1;
    @FindBy(xpath = "/html/body/div[2]/div/div/form/input[2]")
    WebElement check2;

    public String getTitleText () {
        return pageTitle.getText();
    }


    public void clickCheckbox(){
    check1.click();
    }

    public boolean getCheckboxState1(){return check1.isSelected();}

    public void unclickSecondCheckbox(){check2.click();}

    public boolean getCheckboxState2(){return check2.isSelected();}


}
