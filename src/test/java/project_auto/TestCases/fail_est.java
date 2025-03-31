package project_auto.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import project_auto.baseTestClass;

public class fail_est extends baseTestClass {
    @Test
    public void todo(){
        driver.get("https://the-internet.herokuapp.com/");
        Assert.assertFalse(true);
    }
}
