package Pages.Android;

import Pages.abstracts.HomePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidHomePage extends HomePage {
    @AndroidFindBy(accessibility = "title")
    WebElement titleHomePage;

    public AndroidHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public String getTitleHomePage() {
        return getTextElement(titleHomePage);
    }
}
