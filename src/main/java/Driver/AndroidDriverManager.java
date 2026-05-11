package Driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import util.ConfigManager;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager extends DriverManager{

    @Override
    public void createWebDriver() {
        ConfigManager.loadProperties();
        String platformName = ConfigManager.getProperty("platform");
        String automationName = "UiAutomator2";
        String deviceName = ConfigManager.getProperty("android.deviceName");
        String platformVersion = ConfigManager.getProperty("android.platformVersion");
        String udid = ConfigManager.getProperty("android.udid");
        String appPackage = ConfigManager.getProperty("android.package");
        String appActivity = ConfigManager.getProperty("android.startActivity");
        String host = ConfigManager.getProperty("appium.host");
        String port = ConfigManager.getProperty("appium.port");

        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName(platformName);
        androidOptions.setAutomationName(automationName);
        androidOptions.setUdid(udid);
        androidOptions.setDeviceName(deviceName);
        androidOptions.setPlatformVersion(platformVersion);
        androidOptions.setAppPackage(appPackage);
        androidOptions.setAppActivity(appActivity);

       try{
           this.driver = new AndroidDriver(new URL("http://" + host + ":" + port + "/"), androidOptions);
       }catch (MalformedURLException e){
           throw new RuntimeException(e);
       }
    }
}
