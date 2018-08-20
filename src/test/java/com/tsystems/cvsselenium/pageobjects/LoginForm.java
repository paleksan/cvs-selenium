package com.tsystems.cvsselenium.pageobjects;

import com.tsystems.cvsselenium.pageobjects.portalindex.PortalIndex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginForm {

    private final WebDriver driver;
    @FindBy(name = "j_username")
    private WebElement username;
    @FindBy(name = "j_password")
    private WebElement password;
    @FindBy(css = ".buttons > input:nth-child(2)")
    private WebElement loginButton;
    @FindBy(css = ".msg_box")
    private WebElement errorMessage;

    public LoginForm(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8081/CVS_Application/Portal/loginform.jsp");
        //Check that we're on the right page.
        PageFactory.initElements(driver, this);
        if (!"Loginn".equals(driver.getTitle())){
            //throw new IllegalAccessException("This is not the login page");
            System.out.println(driver.getTitle());
        }
    }

    //By usernameLocator = By.name("j_username");
    //By passwordLocator = By.name("j_password");
    //By loginForm = By.cssSelector(".buttons input:nth-child(2)");
    //By loginButtonLocator = By.xpath("/html/body/form/div/div/div/div/div[1]/div/div[2]/div[5]/input[2]");

    // The login page allows the user to type their username into the username field
    public LoginForm typeUsername(String username) {
        // This is the only place that "knows" how to enter a username
        this.username.sendKeys(username);
        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;
    }
    // The login page allows the user to type their password into the password field
    public LoginForm typePassword(String password) {
        // This is the only place that "knows" how to enter a password
        this.password.sendKeys(password);
        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;
    }
    // The login page allows the user to submit the login form
    public PortalIndex submitLogin() {
        // This is the only place that submits the login form and expects the destination to be the home page.
        // A seperate method should be created for the instance of clicking login whilst expecting a login failure.
        loginButton.submit();
        // Return a new page object representing the destination. Should the login page ever
        // go somewhere else (for example, a legal disclaimer) then changing the method signature
        // for this method will mean that all tests that rely on this behaviour won't compile.
        return new PortalIndex(driver);
    }
    // Conceptually, the login page offers the user the service of being able to "log into"
    // the application using a user name and password.
    public PortalIndex loginAs(String username, String password) {
        // The PageObject methods that enter username, password & submit login have already defined and should not be repeated here.
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
    // The login page allows the user to submit the login form knowing that an invalid username and / or password were entered
    public LoginForm loginExpectingFailure() {
        // This is the only place that submits the login form and expects the destination to be the login page due to login failure.
        loginAs("falsch!", "falsch!");
        //Waiting, till error message appears
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".msg_box")));
        // Return a new page object representing the destination. Should the user ever be navigated to the home page after submiting a login with credentials
        // expected to fail login, the script will fail when it attempts to instantiate the LoginPage PageObject.
        return this;
    }

    public LoginForm getErrorMessage() {
        Assert.assertTrue(errorMessage.getText()
                .contains("Login fehlgeschlagen: Benutzername oder Passwort falsch!"));
        return this;
    }
}
