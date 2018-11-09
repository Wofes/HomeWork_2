package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//div[@role = 'button'][text () = 'Отправить']") //[@role = 'button'][1]"
    public WebElement pressSendBtn;

//    @FindBy(xpath = "//span[text () = 'Письмо отправлено.']")
//    public WebElement messageSend;

    @FindBy(xpath = "//*[contains (@href, 'sent')]")
    public WebElement sendingMesg;

    @FindBy(xpath ="//span [@email = 'aleksandr.barov13@gmail.com']")
    public WebElement adrMes;

    @FindBy(xpath = "//*[@aria-label = 'Тема']")
    public WebElement themeMes;

//    @FindBy(xpath = "//")

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

    public LoginPage fillTextMessage(String test) {
        try {
            WebElement waitTextMessage = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(inputTextMessage));
        } finally {
            inputTextMessage.sendKeys(test);
            return this;
        }
    }

    public void submit() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pressContinue.click();

    }

    public void write() {
        WebElement writingButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(buttonWrite));
        buttonWrite.click();
    }

    public void closeAndSave() {
        try {
            WebElement waittCaS = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Сохранено']")));
        } finally {
            closeAndSave.click();
        }
    }

    public void pressDraft() {

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@class = 'qj qr']"))).click().build().perform();
        try {
            WebElement waitDraft = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(pressDraft));
        } finally {
            pressDraft.click();

        }
    }

    public void pressThemeText() throws AssertionError {
        try {
            WebElement explicitWait = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(pressThemeText));
        } finally {
            pressThemeText.click();
        }
    }

    public void pressSendBtn() throws AssertionError {

//        driver.manage().timeouts().implicitlyWait(10, SECONDS);
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@role = 'button'][text () = 'Отправить']"))).build().perform();
//
        try {
            WebElement waitButton = (new WebDriverWait(driver, 10))
                    .until(elementToBeClickable(pressSendBtn));


        } finally {
            pressSendBtn.click();
        }
    }

    private void assertTrue(boolean equals) {
    }

    public void sendMessageOrNot() {

        try {
            WebElement waittSendingMessage = (new WebDriverWait(driver, 8))
                    .until(new ExpectedCondition<WebElement>() {
                        @Nullable
                        @Override
                        public WebElement apply(@Nullable WebDriver driver) {
                            return driver.findElement(By.xpath("//span[text()='Письмо отправлено.']"));
                        }
                    });

            assertTrue(waittSendingMessage.getText().equals("Письмо отправлено."));
        } catch (NoSuchElementException e) {
            System.out.println("Sorry, I lost it");
            e.printStackTrace();
        } finally {
            System.out.println("Message is send");
        }}
    public void sendsMessage () {
        try {
            WebElement sendsMesg = (new WebDriverWait(driver, 6))
                    .until(ExpectedConditions.elementToBeClickable(sendingMesg));
        } finally {
            sendingMesg.click();
        }
    }
    public void themeSendMessg () {
        try {
            WebElement waitTheme = (new WebDriverWait(driver, 6))
                    .until(ExpectedConditions.elementToBeClickable(pressThemeText));
        } finally {
            pressThemeText.click();
        }
    }
    public void rightOrNotTheme () {
        try {
            WebElement waitTheme = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(themeMes));
            assertTrue(themeMes.getText().equals("Test text"));
        }catch (NoSuchElementException e){
            System.out.println("It's not that message");
            e.printStackTrace();
//            wait.until(ExpectedConditions.elementToBeClickable(inputTextMessage));
//            wait.until(ExpectedConditions.elementToBeClickable(inputAdress));
    }}

    public void rightOrNotAdr () {
        try {WebElement waitAdr = (new WebDriverWait(driver, 6))
                .until(ExpectedConditions.elementToBeClickable(adrMes));
            assertTrue(adrMes.getText().equals("aleksandr.barov13@gmail.com"));
        }catch (NoSuchElementException e){
            System.out.println("It's not that message");
            e.printStackTrace();}}

    public void rightOrNotText(){
        try {WebElement waitText = (new WebDriverWait(driver, 6))
                .until(ExpectedConditions.elementToBeClickable(inputTextMessage));
            assertTrue(inputTextMessage.getText().equals("Hello"));
    }catch (NoSuchElementException e){
            System.out.println("It's not that message");
            e.printStackTrace();}
    }
    public LoginPage(WebDriver driver) {super(driver);}

    }