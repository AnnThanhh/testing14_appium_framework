package Pages.Android;

import Pages.abstracts.LoginPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidLoginPage extends LoginPage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/nameET\")")
    WebElement txtUsername;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/passwordET\")")
    WebElement txtPassword;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/loginBtn\")")
    WebElement btnLogin;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void inputLoginUserName(String username) {
        inputText(txtUsername, username);
    }

    @Override
    public void inputLoginPassword(String password) {
        inputText(txtPassword, password);
    }

    @Override
    public void clickBtnLogin() {
        clickBtn(btnLogin);
    }
}
