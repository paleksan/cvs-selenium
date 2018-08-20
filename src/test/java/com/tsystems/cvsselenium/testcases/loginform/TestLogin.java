package com.tsystems.cvsselenium.testcases.loginform;

import com.tsystems.cvsselenium.pageobjects.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin {

    private WebDriver driver;
    private LoginForm loginForm;

//    @Test
//    public void testLoginForm1() {
//        loginForm.typeUsername("tester");
//        loginForm.typePassword("1");
//        loginForm.submitLogin();
//    }
//   @Test
//    public void testLoginForm2() {
//        loginForm.loginAs("tester", "1");
//    }
    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();

        loginForm = new LoginForm(driver);
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
