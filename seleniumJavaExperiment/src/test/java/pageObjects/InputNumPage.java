package pageObjects;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputNumPage {

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/h3")
    WebElement pageTitle;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/input")
    WebElement numberField;

    public String getTitleText () {
        return pageTitle.getText();
    }

    public void enterNumber(String num){
    numberField.sendKeys(num);
    }

    public String getEnteredValue(){
        return numberField.getAttribute("value");
    }

}
