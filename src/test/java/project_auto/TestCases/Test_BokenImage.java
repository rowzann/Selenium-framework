package project_auto.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import project_auto.PageEvents.BrokenImagesEvents;
import project_auto.baseTestClass;

public class Test_BokenImage extends baseTestClass {

    BrokenImagesEvents be;
    @Test
    public void isimageBroken(){
        be=new BrokenImagesEvents(driver);
        driver.findElement(By.xpath("//a[normalize-space()='Broken Images']")).click();
          if(be.isImageBroken()){
              Assert.assertTrue(true);
          }else  Assert.assertTrue(false);


    }

}
