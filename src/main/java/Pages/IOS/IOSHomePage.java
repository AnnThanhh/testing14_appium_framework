package Pages.IOS;

import Pages.abstracts.HomePage;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
public class IOSHomePage extends HomePage {

    @iOSXCUITFindBy(accessibility = "title")
    WebElement element;

    public IOSHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Override
    public String getTitleHomePage() {
        return getTextElement(element);
    }
}
