package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy (id = "content")
    static WebElement optionsContent;

    public static void clickOption(String optionText) {
        optionsContent.findElement(By.linkText(optionText)).click();
    }
}
