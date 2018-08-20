package com.tsystems.cvsselenium.pageobjects.portalindex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainMenuTable{

    private WebDriver driver;

    @FindBy(id = "mainMenutable")
    @CacheLookup
    private List<WebElement> mainMenuItems;

    public MainMenuTable(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickHome(){
        mainMenuItems.get(0).click();
    }

    public void clickKundenanlageSuche(){

    }

    public void clickVorgangssuche(){

    }

    public void clickVertragssuche(){

    }
}
