package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    @FindBy(css = "#profile span")
    private WebElement profileContainer;

    public MainPage(WebDriver driver) {
        super(driver);
        wait.until(drv-> {return profileContainer.isDisplayed();});
    }

    public String getCurrentUser () {
        return profileContainer.getText();
    }
}
