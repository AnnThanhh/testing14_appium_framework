package Pages.abstracts;

import Base.BasePage;
import Pages.abstracts.components.FooterComponent;
import Pages.abstracts.components.NavbarComponent;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage {
    private NavbarComponent navbarComponent;
    private FooterComponent footerComponent;

    //khơi tạo constructor
    public CommonPage (WebDriver driver){
        super(driver);
        this.navbarComponent = new NavbarComponent(driver);
    }

    //khởi tạo component
    public NavbarComponent getNavbarComponent(){
        return navbarComponent;
    }

    public FooterComponent getFooterComponent(){
        return footerComponent;
    }
}
