package util;

import Driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class PlatformUtil {
    public static boolean isAndroid(){
        AppiumDriver driver = DriverFactory.getDriverThreadLocal();

        if(driver instanceof AndroidDriver){
            return true;
        }else {
            return false;
        }
    }
}
