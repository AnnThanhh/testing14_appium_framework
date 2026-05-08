package Driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager extends DriverManager{
    @Override
    public void createWebDriver() {
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName("Android");
        androidOptions.setAutomationName("UiAutomator2");
        androidOptions.setUdid("emulator-5554");
        androidOptions.setDeviceName("Pixel 9");
        androidOptions.setPlatformVersion("15");
        androidOptions.setAppPackage("com.saucelabs.mydemoapp.android");
        androidOptions.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

       try{
           this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), androidOptions);
       }catch (MalformedURLException e){
           throw new RuntimeException(e);
       }
    }
}
