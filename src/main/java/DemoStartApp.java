import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoStartApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //khởi tạo và cấu hình các tùy chọn cho trình điều khiển Android
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName("Android");
        androidOptions.setAutomationName("UiAutomator2");
        androidOptions.setUdid("emulator-5554");
        androidOptions.setDeviceName("Pixel 9");
        androidOptions.setPlatformVersion("15");
        androidOptions.setAppPackage("com.saucelabs.mydemoapp.android");
        androidOptions.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), androidOptions);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String username = "bod@example.com";
            String password = "10203040";
        //bước 1: click menu
        By byMenuButton = AppiumBy.accessibilityId("View menu");
        WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(byMenuButton));
        menuButton.click();
        //bước 2: click login
        By byLoginButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginButton));
        loginButton.click();
        //bước 3: nhập username
        By byUsernameField = AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/nameET\")");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(byUsernameField));
        usernameField.sendKeys(username);
        //bước 4: nhập password
        By byPasswordField = AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/passwordET\")");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(byPasswordField));
        passwordField.sendKeys(password);
        //bước 5: click login button
        By byLoginSubmitButton = AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/loginBtn\")");
        WebElement loginSubmitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginSubmitButton));
        loginSubmitButton.click();
        //bước 6: xác nhận login thành công
        //vp1: kiểm tra có điều hướng về product page
        By byProductPageTitle = AppiumBy.accessibilityId("title");
        WebElement productPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(byProductPageTitle));
        String recordedTitle = productPageTitle.getText();
        Assert.assertEquals(recordedTitle, "Products", "Login không thành công - không điều hướng về trang sản phẩm");

        //vp2: logout menu hiển thị
        menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(byMenuButton));
        menuButton.click();
        By byLogoutButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log Out\")");
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(byLogoutButton));
        Assert.assertTrue(logoutButton.isDisplayed(), "Login không thành công - menu logout không hiển thị");
        driver.quit();
    }
}
