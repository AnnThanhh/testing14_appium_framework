package Pages.abstracts;

import Base.BasePage;
import Pages.PageFactory;
import Pages.abstracts.components.NavbarComponent;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage {
    private NavbarComponent navbarComponent;

    //khơi tạo constructor
    public CommonPage (WebDriver driver){
        super(driver);
        this.navbarComponent = PageFactory.getNavigatePage();
    }

    //khởi tạo component
    public NavbarComponent getNavbarComponent(){
        return navbarComponent;
    }

}
