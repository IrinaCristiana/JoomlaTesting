package com.endava.joomlaTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = ".//input[@id='modlgn-username']")
    private WebElement usernameField;

    @FindBy(xpath = ".//input[@id='modlgn-passwd']")
    private WebElement passwordField;

    @FindBy(xpath = ".//div[@id='form-login-submit']/div[@class='controls']/button[@name='Submit']")
    private WebElement logInButton;

    private WebDriver webDriver;
    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //Insert the credentials and log in
    public AdminHomePage goToAdminHomePage(String username, String password){
        usernameField.clear();
        usernameField.sendKeys("icristea");
        passwordField.clear();
        passwordField.sendKeys("Password1");
        logInButton.click();

        AdminHomePage adminHomePage = PageFactory.initElements(webDriver, AdminHomePage.class);
        return adminHomePage;
    }
}
