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
        switch(fidelName){
            case "имя пользователя":
                loginPage.fillUserName(value);
                break;

        default:
        throw new IllegalArgumentException("Invalid name:" + fidelName);
    }}

    @Тогда("^нажимает кнопку \"([^\"]*)\"$")
    public void pressButton1(String btnName) throws InterruptedException {

        loginPage.submit();

    }
    @И("^пользователь вводит \"Введите пароль\" значение \"([^\"]*)\"$")
    public void setPassword(String value) {
        loginPage.fillPassword(value);
    }


}

