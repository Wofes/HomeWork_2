package com.pflb.gmailtest.steps;

import com.pflb.gmailtest.MainPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import helpers.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.support.ui.ExpectedCondition;


public class LoginPageSteps {
    private WebDriver driver = null;
    private MainPage mainPage = null;
    private LoginPage loginPage;


    @Before
    public void getDriver() {
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);

    }

    @After
    public void closeDriver() {
        DriverManager.closeDriver();
    }


    @Пусть("^открыта страница входа на сайт \"(.+)\"$")
    public void openLoginPage(String url) {
        loginPage.open(url);
    }

    @И("^пользователь вводит в поле \"([^\"]*)\" значение \"([^\"]*)\"$")
    public void setTextToInput(String fidelName, String value) {
        switch (fidelName) {
            case "имя пользователя":
                loginPage.fillUserName(value);
                break;

            default:
                throw new IllegalArgumentException("Invalid name:" + fidelName);
        }
    }

    @Тогда("^нажимает кнопку \"([^\"]*)\"$")
    public void pressButton(String btnName)  {
        loginPage.submit();
    }

    @И("^пользователь вводит \"Введите пароль\" значение \"([^\"]*)\"$")
    public void setPassword(String value) {
        loginPage.fillPassword(value);
    }

    @Тогда("^снова нажимает кнопку \"([^\"]*)\"$")
    public void pressButton1(String btnName) {
        loginPage.submit();
    }

    @И("^пользлователь нажимает кнопку \"([^\"]*)\" для создания письма$")
    public void pressWritingButton(String btnName)  {
        loginPage.write();
    }

    @Тогда("^в строке получателя вводится адресат \"([^\"]*)\"$")
    public void writtingAddresat(String adr) {
        loginPage.fillAdress(adr);
    }

    @И("^в теме вводит \"([^\"]*)\"$")
    public void themeWriting(String theme) {
        loginPage.fillTheme(theme);
    }


    @И("^в теле письма вводится \"([^\"]*)\"$")
    public void writingHello(String text) {
        loginPage.fillTextMessage(text);
    }

    @И("^нажимается кнопка \"([^\"]*)\"$")
    public void pressCloseAndSave(String closeSave) {
        loginPage.closeAndSave();
            System.out.println( "Message is save" );

        }

    @Тогда("^нажимает пользователь нажимает \"([^\"]*)\"$")
    public void pressDraft(String draft){
        loginPage.pressDraft();
    }

    @И("^нажимает на последений черновик с надписью \"([^\"]*)\"$")
    public void pressThemeOfDraft(String theme) {
            loginPage.pressThemeText();
        System.out.println( "I found message!" );

    }

    @И("^нажимается кнопку \"([^\"]*)\"$")
    public void sendingToAdr(String sendbtn) {
        loginPage.pressSendBtn();
        System.out.println( "I send your massage" );
    }
}

