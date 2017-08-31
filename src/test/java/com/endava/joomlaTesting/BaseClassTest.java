package com.endava.joomlaTesting;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseClassTest {

    protected static HomePage homePage;
    protected static AdminHomePage adminHomePage;
    private static WebDriver webDriver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("geckodriver.exe", "C:/Users/icristea/Downloads/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        //Navigate to “http://localhost:81/joomla/index.php”
        webDriver.get("http://localhost:81/joomla/index.php");
        homePage = PageFactory.initElements(webDriver, HomePage.class);
        adminHomePage = homePage.goToAdminHomePage("icristea", "Password1");
    }

    @AfterClass
    public static void afterClass(){
        adminHomePage.logout();
        webDriver.quit();
    }
}