package project_auto;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SuitListeners extends baseTestClass implements ITestListener {
private ExtentTest test;
    @Override
    public void onStart(ITestContext context) {
        htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator+"Report"+File.separator+"test.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Selenium Test practice");
        htmlReporter.config().setReportName("Functional Testing Report");
        htmlReporter.config().setTheme(Theme.DARK);
        extentReport=new ExtentReports();
        extentReport.attachReporter(htmlReporter);
        extentReport.setSystemInfo("Tester","Rojan Dhakal");
        extentReport.setSystemInfo("Browser",browsername);
        ITestListener.super.onStart(context);
    }
    @Override
    public void onTestStart(ITestResult result) {
      test=  extentReport.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
          test.pass("Test Pass");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getMethod().getMethodName() + " failed");
        String path=captureScreenshot(driver,result.getMethod().getMethodName());
        MediaEntityBuilder.createScreenCaptureFromPath(path).build();
        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }



    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }


    public static String captureScreenshot(WebDriver driver, String testName) {
        // Generate a timestamped filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "screenshots/" + testName +timestamp + ".png";

        // Take Screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("📸 Screenshot Captured: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }
}
