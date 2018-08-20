package com.tsystems.cvsselenium.testcases;

import com.tsystems.cvsselenium.pageobjects.LoginForm;
import com.tsystems.cvsselenium.pageobjects.portalindex.MainMenuTable;
import com.tsystems.cvsselenium.pageobjects.portalindex.PortalIndex;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {

    private WebDriver driver;
    private LoginForm loginForm;
    private PortalIndex portalIndex;

    @Test
    public void testMainMenuClickHome() {
        portalIndex = loginForm.loginAs("tester", "1");
        new MainMenuTable(driver).clickHome();
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
