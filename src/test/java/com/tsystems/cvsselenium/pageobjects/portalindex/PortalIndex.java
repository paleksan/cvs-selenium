package com.tsystems.cvsselenium.pageobjects.portalindex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalIndex {

    private final WebDriver driver;

    public PortalIndex(WebDriver driver){
        this.driver = driver;

        //Check that we're on the right page.
        if (!"Login".equals(driver.getTitle())){
           // throw new IllegalAccessException("This is not the login page");
        }
    }
}
