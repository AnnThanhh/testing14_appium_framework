package Pages.IOS;

import Pages.abstracts.LoginPage;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IOSLoginPage extends LoginPage {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"User Name\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField")
    WebElement txtUsername;

    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    WebElement txtPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Login\"`]")
    WebElement btnLogin;

    public IOSLoginPage(WebDriver driver) {
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
