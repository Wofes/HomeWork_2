package com.pflb.gmailtest;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;

@CucumberOptions(
        strict = true,
        features = {"src/test/java/com/pflb/gmailtest/features/gmail.feature"},
        glue = "com/pflb/gmailtest/steps"
)
public class MainPage extends AbstractTestNGCucumberTests {

    public MainPage() {
    }
}

