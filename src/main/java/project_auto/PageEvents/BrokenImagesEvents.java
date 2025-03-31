package project_auto.PageEvents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project_auto.PageObject.BorkenImagepage;

import java.util.List;

public class BrokenImagesEvents implements BorkenImagepage {
WebDriver driver;
    public BrokenImagesEvents(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isImageBroken() {
        List<WebElement> element = driver.findElements(imagesElemet);
        System.out.println("Total images found: " + element.size());

        for (WebElement el : element) {
            Boolean isImageLoaded = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalWidth > 0;", el);
        }
         return false;
    }

}
