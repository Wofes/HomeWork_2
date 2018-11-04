package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webriver.chromedriver.driver", "src/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(5, SECONDS);
            driver.quit();

    }
}}
