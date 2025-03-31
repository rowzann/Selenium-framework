package project_auto.PageEvents;

import org.openqa.selenium.WebDriver;
import project_auto.PageObject.addRemoveElemet;

public class AddorRemoveElementEvents implements addRemoveElemet {
    public WebDriver driver;

    public AddorRemoveElementEvents(WebDriver driver) {
        this.driver = driver;
    }

    public void addelement() {
        driver.findElement(addElement_btn).click();
    }
    public void deleteElement(){
        driver.findElement(deleteElement_btn).click();
    }
      public String verifypage(){
        return  driver.findElement(title).getText();
    }
}
