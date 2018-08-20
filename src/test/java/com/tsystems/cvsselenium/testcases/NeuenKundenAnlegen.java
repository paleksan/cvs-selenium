package com.tsystems.cvsselenium.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class NeuenKundenAnlegen {

    private WebDriver driver;
    @Test
    public void testEasy() {

        driver.get("http://localhost:8081/CVS_Application/Portal/portalindex.jsp");

        // Einloggen
        driver.findElement(By.name("j_username")).sendKeys("tester");
        WebElement element = driver.findElement(By.name("j_password"));
        element.sendKeys("1");
        element.submit();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        element = driver.findElement(By.linkText("Kundenanlage/-suche"));
        element.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().frame("mainframe");
        WebElement button = driver.findElement(By.cssSelector("#create_customer_button"));
        button.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kundenname*
        driver.findElement(By.cssSelector("html body div form div ul li input")).sendKeys("Testkunde");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Vertiebskanal*
        WebElement selectElement = driver.findElement(By.cssSelector("html body div form div ul li select"));
        Select select = new Select(selectElement);
        select.selectByIndex(2); // 1 - T-Systems International GmbH; 2 - Telekom Deutschland GmbH.

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // "Neu" klicken
        driver.findElement(By.cssSelector("html body div form div div div div div div input")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        selectElement = driver.findElement(By.cssSelector("html body div form div div div div div table tbody tr td div select"));
        select = new Select(selectElement);
        select.selectByIndex(3);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("html body div form div div div div div table tbody tr td div div input")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        selectElement = driver.findElement(By.cssSelector("html body div form div div div div div table tbody tr td div select"));
        select = new Select(selectElement);
        select.selectByIndex(3);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //driver.findElement(By.cssSelector("html body div form div div div div div table tbody tr td div span input"))
        driver.findElement(By.cssSelector("#tkonf_Vertragsbeginn > span:nth-child(1) > input"))
                .sendKeys(new SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("html body div form div div div div div table tbody tr td div div input")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        selectElement = driver.findElement(By.cssSelector("html body div form div div div div select"));
        select = new Select(selectElement);
        select.selectByIndex(2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("html body div form div div div ul li input")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("html body div form div div div ul li input")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("html body div form div div div ul li input")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("html body div form div div div ul li input")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("html body div form div ul.tkonf_attributelist li:nth-child(4) input")).sendKeys("123456");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("html body div form div ul.tkonf_attributelist li:nth-child(5) input")).sendKeys("12345678");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String firstWindow = driver.getWindowHandle();

        driver.findElement(By.cssSelector("html body div form div div div ul li input")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows.size());
        windows.remove(firstWindow);
        driver.switchTo().window(windows.iterator().next());




        System.out.println("New window title: " + driver.getTitle());
        driver.close();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.switchTo().window(firstWindow);
        System.out.println("Old window title: " + driver.getTitle());

        driver.findElement(By.cssSelector("html body div form div div div ul li input")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("html body div form div div div ul li input")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.linkText("TMO !")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date currentDate = new Date();
        Date nextDate = new Date();
        nextDate.setDate(currentDate.getDate() + 15);

        driver.findElement(By.cssSelector("html body div form div div div div div ul.tkonf_attributelist li span input"))
                .sendKeys(new SimpleDateFormat("dd.MM.yyyy").format(currentDate));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.cssSelector("html body div form div div div div div ul.tkonf_attributelist li:nth-child(2) span input"))
                .sendKeys(new SimpleDateFormat("dd.MM.yyyy").format(nextDate));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //driver.findElement(By.cssSelector("input:contains('TMO generieren (-> generiert)')")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(new SimpleDateFormat("dd.MM.yyyy").format(currentDate));
        System.out.println(new SimpleDateFormat("dd.MM.yyyy").format(nextDate));
    }
    @BeforeTest
    public void beforeTest() {
        //String PROXY = "proxy.t-systems.ru:3128";
        //String PROXY = "localhost:8081";
        //Proxy proxy = new Proxy();
        //proxy.setHttpProxy(PROXY);
        //DesiredCapabilities capability = new DesiredCapabilities();
        //capability.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
        //capability.setCapability(CapabilityType.PROXY, proxy);
        //driver=new InternetExplorerDriver(capability);*/
/*
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions
                .setProxy(new Proxy("proxy.t-systems.ru:3128")
                .requireWindowFocus().usePerProcessProxy().enableNativeEvents()
                .introduceFlakinessByIgnoringSecurityDomains().ignoreZoomSettings()
                .setUnhandledPromptBehaviour()
                .enablePersistentHovering().setPageLoadStrategy(PageLoadStrategy.EAGER)
                .elementScrollTo(ElementScrollBehavior.TOP).setCapability(InternetExplorerDriver.SILENT, true);
        System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriver\\IEDriverServer.exe");
        //System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");*/
        driver = new FirefoxDriver();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
