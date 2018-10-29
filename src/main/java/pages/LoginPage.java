package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@autocomplete = 'username']")
    public WebElement inputUsername;



    @FindBy(xpath = "//span[text()='Далее']")
    public WebElement pressContinue;

    @FindBy(xpath = "//input[@autocomplete = 'current-password']")
    public WebElement inputPassword;

    public void open (String url) {
        driver.get(url);
    }

    public LoginPage fillUserName(String text) {
        inputUsername.sendKeys(text);
        return this;
    }

    public LoginPage fillPassword (String text) {
        inputPassword.sendKeys(text);
        return this;
    }

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void submit() throws InterruptedException {
        Thread.sleep(1000); //TODO Пиши эксплисид вэйт
        pressContinue.click();
    }

}
