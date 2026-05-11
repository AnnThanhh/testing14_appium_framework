package Base;

import Driver.*;
import ExtentReport.ExtentReportManager;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import util.ConfigManager;

import java.lang.reflect.Method;


public class BaseTest {
    protected final Logger LOG = LogManager.getLogger(getClass());
    @BeforeSuite
    public void beforeSuite() {
        LOG.info("Starting berfore suite - initialize extent report");
        //khởi tạo report
        ExtentReportManager.initializeExtentReports();
        //load các thông tin từ file cấu hình properties
        ConfigManager.loadProperties();
    }
    
    @BeforeClass
    public void beforeClass() {
        LOG.info("Starting before class - initialize web driver");
        //khởi tạo chrome driver
//        DriverManager driverManager = new AndroidDriverManager();
//        DriverManager driverManager = new IOSDriverManger();
        String platform = ConfigManager.getProperty("platform");
        DriverManager driverManager = DriverManagerFactory.getDriverManager(platform);
        driverManager.createWebDriver();
        //lấy driver từ driver manager và set vào ThreadLocal
        AppiumDriver driver = driverManager.getDriver();
        DriverFactory.setDriverThreadLocal(driver);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        LOG.info("Starting before method - create test in extent report for method: " + method.getName());
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        LOG.info("Starting after method - capture screenshot if test failed for method: " + testResult.getName());
        if(testResult.getStatus() == ITestResult.FAILURE){
            ExtentReportManager.captureScreenshot(DriverFactory.getDriverThreadLocal(), testResult.getTestName());
            //ghi log lỗi vào report
            ExtentReportManager.fail(testResult.getThrowable().toString());
        }
    }

    @AfterClass
    public void afterClass() {
        LOG.info("Starting after class - quit web driver");
        WebDriver driver = DriverFactory.getDriverThreadLocal();
        if (driver != null) {
            driver.quit();
        }
        DriverFactory.removeDriverThreadLocal();
    }

    @AfterSuite
    public void afterSuite() {
        LOG.info("Starting after suite - flush extent report");
        //đóng report
        ExtentReportManager.flushReports();
    }
}
