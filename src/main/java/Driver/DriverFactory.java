package Driver;

import io.appium.java_client.AppiumDriver;

public class DriverFactory {
    //race condition

    private static ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();
    //ThreadLocal: mỗi thread sẽ có một bản sao của biến này,
    //đảm bảo rằng mỗi thread sẽ có một instance riêng biệt của WebDriver, tránh xung đột khi nhiều thread cùng truy cập và sử dụng WebDriver.

    public static AppiumDriver getDriverThreadLocal(){
        return driverThreadLocal.get();
    }

    public static void setDriverThreadLocal(AppiumDriver driver){
        driverThreadLocal.set(driver);
    }

    public static void removeDriverThreadLocal(){
        driverThreadLocal.remove();
    }
}
