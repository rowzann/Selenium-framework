package project_auto;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import project_auto.Utils.waits;

import java.io.File;
import java.util.concurrent.TimeUnit;
@Listeners(SuitListeners.class)
public class baseTestClass {
    public static WebDriver driver;
    public ExtentSparkReporter htmlReporter;
    public static ExtentReports extentReport;
    public static ExtentTest logger;
    public project_auto.Utils.waits waits;
String browsername=null;

    @BeforeClass
   // @Parameters(value={"browserName"})
    public void setup( ){
        String browsername="chrome";
        setDriver(browsername);
      driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
      waits=new waits(driver);
    }
    @BeforeTest
    public void before() {
//        htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator+"Report"+File.separator+"test.html");
//        htmlReporter.config().setEncoding("utf-8");
//        htmlReporter.config().setDocumentTitle("Selenium Test practice");
//        htmlReporter.config().setReportName("The Internet hookup");
//        htmlReporter.config().setTheme(Theme.DARK);
//        extentReport=new ExtentReports();
//        extentReport.attachReporter(htmlReporter);
//        extentReport.setSystemInfo("Tester","Rojan Dhakal");
//        logger=extentReport.createTest("My test");
    }



    @AfterMethod
    public void aftermethodTest(ITestResult result) {

//        if(result.getStatus()==ITestResult.SUCCESS) {
//            String methodName = result.getMethod().getMethodName();
//            String logText="Test case:"+methodName+"Passed";
//            Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//            logger.log(Status.PASS,m);
//        }else if (result.getStatus()==ITestResult.FAILURE){
//            String methodName = result.getMethod().getMethodName();
//            String logText="Test case:"+methodName+"Failed";
//            Markup m= MarkupHelper.createLabel(logText,ExtentColor.RED);
//            logger.log(Status.FAIL,m);
//        }

    }


    @AfterTest
    public void after() {
        extentReport.flush();

    }
    @AfterClass
    public void afterclass(){
        driver.quit();
    }

    public void setDriver(String browserName) {
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().clearDriverCache().setup();
            ChromeOptions options = new ChromeOptions();
         //   options.addArguments("--headless"); // Enables headless mode
            options.addArguments("--disable-gpu"); // Fixes potential rendering issues
            options.addArguments("--window-size=1920,1080"); // Ensures proper screen size for elements
            driver= new ChromeDriver(options);
        }
        else if( browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

            else if( browserName.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
        }else {
            throw new IllegalArgumentException("Unsopprted browser" + browserName);
        }


}
}
