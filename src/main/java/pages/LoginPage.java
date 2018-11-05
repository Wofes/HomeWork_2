package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


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


    @FindBy(xpath = "//*[contains (@href, '#drafts')]")    //a@href= 'https://mail.google.com/mail/#drafts
    public WebElement pressDraft;

    @FindBy(xpath = "//*[@class = 'bog']//*[text() = 'Test text'][1]")//(text(),'Test text')
    public WebElement pressThemeText;

    @FindBy(xpath = "//div[@role = 'button' and text () = 'Отрправить']") //[@role = 'button'][1]"
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

    public void submit() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pressContinue.click();

    }

    public void write()  {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonWrite.click();
    }

    public void closeAndSave()  {
        try {
            WebElement explicitWait = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Сохранено']")));
        } finally {
        closeAndSave.click();
    }}

    public void pressDraft()  {

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@class = 'qj qr']"))).click().build().perform();
        try {
            WebElement explicitWait = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(pressDraft));
        } finally {
        pressDraft.click();

    }}

    public void pressThemeText() throws AssertionError  {
        try {
            WebElement explicitWait = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(pressThemeText));
        } finally {
        pressThemeText.click();
        }}

    public void pressSendBtn() throws AssertionError {

//        driver.manage().timeouts().implicitlyWait(10, SECONDS);
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@class = 'gU Up']"))).click().build().perform();
//
//        try {
//            WebElement explicitWait = (new WebDriverWait(driver, 10))
//                    .until(elementToBeClickable(By.xpath("//div[text() = 'Отправить']")));
//        } finally {
       pressSendBtn.click();



}}