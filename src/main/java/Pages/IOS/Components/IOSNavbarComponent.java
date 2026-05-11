package Pages.IOS.Components;

import Constants.TimeOutConstant;
import Pages.abstracts.components.NavbarComponent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IOSNavbarComponent extends NavbarComponent {
    @iOSXCUITFindBy(accessibility = "More-tab-item")
    WebElement btnMainMenu;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    WebElement loginBtn;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    WebElement logoutBtn;

    public IOSNavbarComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void NavigateMainMenu() {
        clickBtn(btnMainMenu);
    }

    @Override
    public void NavigateToLoginPage() {
        clickBtn(loginBtn);
    }

    @Override
    public void NavigateToLogout() {
        clickBtn(logoutBtn);
    }

    @Override
    public boolean isLogoutBtnDisplayed() {
        try {
            return waitVisibilityOf(logoutBtn, TimeOutConstant.TIME_OUT_DEFAULT).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
