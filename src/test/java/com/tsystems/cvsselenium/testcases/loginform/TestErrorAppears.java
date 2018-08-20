package com.tsystems.cvsselenium.testcases.loginform;

import com.tsystems.cvsselenium.pageobjects.LoginForm;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class TestErrorAppears {

    private WebDriver driver;
    private LoginForm loginForm;

    @Test (description = "Testing, that it is possible to login")
    public void testLogin() {
        loginForm.typeUsername("tester");
        loginForm.typePassword("1");
        loginForm.submitLogin();
    }

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
