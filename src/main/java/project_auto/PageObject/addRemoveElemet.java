package project_auto.PageObject;

import org.openqa.selenium.By;

public interface addRemoveElemet {
    By addElement_btn= By.xpath("//*[@id=\"content\"]/div/button");
    By deleteElement_btn= By.xpath("//button[normalize-space()='Delete']");

    By title= By.xpath("//h3[normalize-space()='Add/Remove Elements']");

}
