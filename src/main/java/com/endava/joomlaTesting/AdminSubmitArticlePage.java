package com.endava.joomlaTesting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSubmitArticlePage {

    @FindBy(xpath = ".//div[@id='system-message']/div/div/div[@class='alert-message']")
    private WebElement errorMessage;

    @FindBy(xpath = ".//input[@id='jform_title']")
    private WebElement articleTitleBox;

    @FindBy(xpath = ".//div[@id='mceu_95-0']")
    private WebElement outsideWebElement;

    @FindBy(xpath = ".//div[@id='mceu_93']/iframe[@id='jform_articletext_ifr']")
    private WebElement articleContent;

    @FindBy(xpath = ".//div[@class='btn-group']/button[@class='btn btn-primary']")
    private WebElement saveButton;

    private WebDriver webDriver;

    public AdminSubmitArticlePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String submitArticle(String title){
        articleTitleBox.sendKeys(title);
        saveButton.click();
        return errorMessage.getText();
    }

    public AdminHomePage submitArticle(String title, String content){
        articleTitleBox.sendKeys(title);
        outsideWebElement.click();
        articleContent.click();
        articleContent.sendKeys(content);
        articleContent.sendKeys(Keys.ENTER);
        saveButton.click();

        return PageFactory.initElements(webDriver, AdminHomePage.class);
    }


}
