package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@autocomplete = 'username']")
    public WebElement inputUsername;

    @FindBy(xpath = "//span[text() = 'Далее']")
    public WebElement pressContinue;

    @FindBy(xpath = "//input[@autocomplete = 'current-password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[text() = 'Написать']")
    public WebElement buttonWrite;

    @FindBy(xpath = "//textarea[@aria-label = 'Кому']")
    public WebElement inputAdress;

    @FindBy(xpath = "//input[@placeholder = 'Тема']")//*[@id=":pi"]
    public WebElement inputTheme;

    @FindBy(xpath = "//div[@aria-label = 'Тело письма']")
    public WebElement inputTextMessage;

    @FindBy(xpath = "//img[@aria-label = 'Сохранить и закрыть']")
    public WebElement closeAndSave;

    @FindBy(xpath = "//*[text()='Черновики']")
    public WebElement pressDraft;

    @FindBy(xpath = "//tr[@class = 'bog'][text() = 'Test text']")//(text(),'Test text')
    public WebElement pressThemeText;//*[@id=":dv"]

    @FindBy(xpath = "//div[@aria-label = 'Отправить']")
    public WebElement pressSendBtn;


    public void open(String url) {
        driver.get(url);
    }

    public LoginPage fillUserName(String text) {
        inputUsername.sendKeys(text);
        return this;
    }

    public LoginPage fillPassword(String text) {
        inputPassword.sendKeys(text);
        return this;
    }

    public LoginPage fillAdress(String text) {
        inputAdress.sendKeys(text);
        return this;
    }

    public LoginPage fillTheme(String text) {
        inputTheme.sendKeys(text);
        return this;
    }

    public LoginPage fillTextMessage(String test)  {
       inputTextMessage.sendKeys(test);
        return this;
    }


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void submit() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pressContinue.click();

    }

    public void write() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        buttonWrite.click();
    }

    public void closeAndSave() throws InterruptedException {

        closeAndSave.click();
    }

    public void pressDraft() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        pressDraft.click();
    }

    public void pressThemeText() throws InterruptedException  {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pressThemeText.click();
        }

    public void pressSendBtn() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pressSendBtn.click();
    }


}