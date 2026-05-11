package Pages.abstracts;

import org.openqa.selenium.WebDriver;

public abstract class HomePage extends CommonPage {

    public HomePage (WebDriver driver){
        super(driver);
    }

    public abstract String getTitleHomePage();
}
