package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    @FindBy(css = ".example h3")
    WebElement pageTitle;

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public String getTitleText () {
        return pageTitle.getText();
    }

    public void openDropDown(){dropdown.click();}

    public void selectOptions(String option){
        Select opt= new Select(dropdown);
        opt.selectByVisibleText(option);

    }

    public String returnDropdownValue(){
        Select opt= new Select(dropdown);
        WebElement dropdownx= opt.getFirstSelectedOption();
        String value= dropdownx.getText();
         return value;
    }
}
