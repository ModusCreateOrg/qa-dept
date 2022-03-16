package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class KeyPress {
    @FindBy(css = ".example h3")
    WebElement pageTitle;

    @FindBy(id = "target")
    WebElement textbox;

    @FindBy(id = "result")
    WebElement resultText;


    public String getTitleText () {
        return pageTitle.getText();
    }

    public void enterKey(Keys temp){
        textbox.sendKeys(temp);
    }
    public String getEnteredText(){
        String val=resultText.getText();
        String[] arrOfStr= val.split(Pattern.quote(":"));
        String part1=arrOfStr[1];
        val= part1.trim();
        return  val;
    }

}
