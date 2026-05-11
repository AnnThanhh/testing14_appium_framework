package Pages.abstracts.components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class NavbarComponent extends BasePage {

    public NavbarComponent(WebDriver driver){
        super(driver);
    }

    public abstract void NavigateMainMenu();

    public abstract void NavigateToLoginPage();

    public abstract void NavigateToLogout();

    public abstract boolean isLogoutBtnDisplayed();
}
