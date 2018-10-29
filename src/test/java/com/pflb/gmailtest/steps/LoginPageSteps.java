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
        loginPage = new LoginPage(driver); //Инстанс страницы лучше создать здесь

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
//        if (!btnName.equals("Далее")) {
//            throw new IllegalArgumentException("Invalid button name :" + btnName); //Это еще зачем???
//        }

        loginPage.submit();

    }
    @И("^пользователь вводит \"Введите пароль\" значение \"([^\"]*)\"$")//Передается две переменных, а используется только одна!
    public void setPassword(String value) {
        loginPage.fillPassword(value);
//        throw new IllegalArgumentException("Invalid password:" + value);//У тебя этот эксепшн кидается каждый раз вне зависимости от хода теста. Нахрена? Это рушит весь тест
    }

//Зачем дважды писать один и тот же код с одним и тем же функционалом?????
//    @Тогда("^нажимает снова кнопку \"([^\"]*)\"$")
//    public void pressButton2(String btn) {
//        if (!btn.equals("Далее")) {
//            throw new IllegalArgumentException("Invalid button name :" + btn);
//        }
//        loginPage.submit();
//    }


//    @Тогда("^открылась страница Gmail$")
//    public void pageOpened() { //Это, блин, вообще что?
//        mainPage = new MainPage(driver);
//    }



}

