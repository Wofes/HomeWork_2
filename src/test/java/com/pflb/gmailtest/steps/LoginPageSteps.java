package com.pflb.gmailtest.steps;

import com.pflb.gmailtest.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import helpers.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;


public class LoginPageSteps {
    private WebDriver driver = null;
    private MainPage mainPage = null;
    private LoginPage loginPage = null;


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
    public void pressButton(String btnName) throws InterruptedException {
        loginPage.submit();
    }

    @И("^пользователь вводит \"Введите пароль\" значение \"([^\"]*)\"$")
    public void setPassword(String value) {
        loginPage.fillPassword(value);
    }

    @Тогда("^снова нажимает кнопку \"([^\"]*)\"$")
    public void pressButton1(String btnName) throws InterruptedException {
        loginPage.submit();
    }

    @И("^пользлователь нажимает кнопку \"([^\"]*)\" для создания письма$")
    public void pressWritingButton(String btnName) throws InterruptedException {
        loginPage.write();
    }

    @Тогда("^в строке получателя вводится адресат \"([^\"]*)\"$")
    public void writtingAddresat(String value) {
        loginPage.fillAdress(value);
    }

    @И("^в теме вводит \"([^\"]*)\"$")
    public void themeWriting(String value) {
        loginPage.fillTheme(value);
    }


    @И("^в теле письма вводится \"([^\"]*)\"$")
    public void writingHello(String value) throws InterruptedException {
        loginPage.fillTextMessage(value);
    }

    @И("^нажимается кнопка \"([^\"]*)\"$")
    public void pressCloseAndSave(String closeSave) throws InterruptedException {
        synchronized (loginPage.closeAndSave) {
            loginPage.closeAndSave.wait(5000);
        }
        loginPage.closeAndSave();
    }


    @Тогда("^нажимает пользователь нажимает \"([^\"]*)\"$")
    public void pressDraft(String draft) throws InterruptedException {
        loginPage.pressDraft();
        synchronized (loginPage.pressDraft) {
            loginPage.pressDraft.wait(3000);
        }
    }

    @И("^нажимает на последений черновик с надписью \"([^\"]*)\"$")
    public void pressThemeOfDraft(String theme) throws InterruptedException {
        synchronized (loginPage.themeText) {
            loginPage.themeText.wait(5500);
            loginPage.themeText();
        }
    }

    @И("^нажимается кнопку \"([^\"]*)\"$")
    public void sendingToAdr(String sendbtn) throws InterruptedException {
        loginPage.pressSendBtn();
    }
}

