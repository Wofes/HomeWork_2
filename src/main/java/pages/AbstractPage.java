package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public abstract class AbstractPage {

    WebDriver driver;
    Logger logger;
    WebDriverWait wait;


    AbstractPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void open(String url, WebDriver driver){
        driver.get(url);
    }
}
