package Driver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSDriverManger extends DriverManager {
    @Override
    public void createWebDriver() {
        XCUITestOptions iosOptions = new XCUITestOptions();
        iosOptions.setPlatformName("ios");
        iosOptions.setAutomationName("XCUITest");
        iosOptions.setDeviceName("iPhone 17 Pro Simulator");
        iosOptions.setUdid("87F8DA42-F0F6-4C6F-85C9-84646D59A10B");
        //bundle: lấy từ dev hoặc lấy qua cmd:
        //xcodebuild -workspace "My Demo App.xcworkspace" -scheme "My Demo Demo App" -showBuildSettings | grep PRODUCT_BUNDLE_IDENTIFIER
        iosOptions.setBundleId("com.saucelabs.mydemo.app.ios");
        iosOptions.setNewCommandTimeout(Duration.ofSeconds(300));

        try {
            this.driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), iosOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
