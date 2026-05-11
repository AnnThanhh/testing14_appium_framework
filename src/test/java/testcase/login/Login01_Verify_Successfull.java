package testcase.login;

import Base.BaseTest;
import Driver.DriverFactory;
import ExtentReport.ExtentReportManager;
import Pages.PageFactory;
import Pages.abstracts.CommonDialog;
import Pages.abstracts.HomePage;
import Pages.abstracts.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login01_Verify_Successfull extends BaseTest {
    @Test(description = "Verify that user can login successfully with valid credentials")
    public void testValidLogin() {
        String username = "testing141";
        String password = "Carson2309";

        //khởi tạo page
        HomePage homePage = PageFactory.getHomePage();
        LoginPage loginPage = PageFactory.getLoginPage();

        ExtentReportManager.info("Step 1: Click main menu");
        LOG.info("Step 1: Click main menu");
        homePage.getNavbarComponent().NavigateMainMenu();

        ExtentReportManager.info("Step 2: Click login button");
        LOG.info("Step 2: Click login button");
        homePage.getNavbarComponent().NavigateToLoginPage();

        ExtentReportManager.info("Step 3: Input username and password");
        LOG.info("Step 3: Input username and password");
        loginPage.inputLoginUserName(username);
        loginPage.inputLoginPassword(password);

        ExtentReportManager.info("Step 4: Click login button");
        LOG.info("Step 4: Click login button");
        loginPage.clickBtnLogin();

        ExtentReportManager.info("VP1: Verify login successfully");
        LOG.info("VP1: Verify login successfully");
        String actualMessage = homePage.getTitleHomePage();
        Assert.assertEquals(actualMessage, "Products", "Product title not display");

        ExtentReportManager.info("VP2: Verify logout button display");
        LOG.info("VP2: Verify logout button display");
        homePage.getNavbarComponent().NavigateMainMenu();
        boolean isLogoutBtnDisplayed = homePage.getNavbarComponent().isLogoutBtnDisplayed();
        Assert.assertTrue(isLogoutBtnDisplayed, "Logout button is not displayed");
    }
}
