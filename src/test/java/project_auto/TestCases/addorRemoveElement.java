package project_auto.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import project_auto.PageEvents.AddorRemoveElementEvents;
import project_auto.Utils.waits;
import project_auto.baseTestClass;

public class addorRemoveElement extends baseTestClass {

    AddorRemoveElementEvents ae;

    @Test(priority = 1)
    public void verifyAddorRemovePAge(){
       ae= new AddorRemoveElementEvents(driver);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
        Assert.assertEquals(ae.verifypage(),"Add/Remove Elements");
        }

        @Test(priority = 2)
    public void VerifyAddelementFunction() {        waits.waitForElementToBeVisible(AddorRemoveElementEvents.addElement_btn, 3);
        ae.addelement();
       Assert.assertTrue(driver.findElement(AddorRemoveElementEvents.deleteElement_btn).isDisplayed());

        }
        @Test(priority = 3)
    public void VerifyDeleteElement(){
            ae.deleteElement();
            boolean isButtonAvilable= driver.findElements(AddorRemoveElementEvents.deleteElement_btn).size()==0;
               Assert.assertTrue(isButtonAvilable);
        }

}
