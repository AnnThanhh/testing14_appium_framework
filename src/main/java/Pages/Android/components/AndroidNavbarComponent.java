package Pages.Android.components;

import Constants.TimeOutConstant;
import Pages.abstracts.components.NavbarComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidNavbarComponent extends NavbarComponent {
    @AndroidFindBy(accessibility = "View menu")
    WebElement menuButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log In\")")
    WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log Out\")")
    WebElement logoutButton;

    public AndroidNavbarComponent(WebDriver driver) {
        super(driver);
        //1 cơ chế để khởi tạo các phần tử được định nghĩa bởi @AndroidFindBy
        //AppiumFieleDecorator giúp Appium hiểu và sử dụng các annotation (cho Android, IOS)
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void NavigateMainMenu() {
        clickBtn(menuButton);
    }

    @Override
    public void NavigateToLoginPage() {
        clickBtn(loginButton);
    }

    @Override
    public void NavigateToLogout() {
        clickBtn(logoutButton);
    }

    @Override
    public boolean isLogoutBtnDisplayed() {
       try {
           return waitVisibilityOf(logoutButton, TimeOutConstant.TIME_OUT_DEFAULT).isDisplayed();
       } catch (Exception e) {
           return false;
       }
    }
}
