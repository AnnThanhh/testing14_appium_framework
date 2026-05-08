package Driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    //thuộc tính
    protected AppiumDriver driver;

    public AppiumDriver getDriver(){
        return this.driver;
    }

    public abstract void createWebDriver();
}
