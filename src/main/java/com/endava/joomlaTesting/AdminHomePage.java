package com.endava.joomlaTesting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminHomePage{

    @FindBy(xpath = ".//input[@id='mod-search-searchword94']")
    private WebElement searchBox;

    @FindBy(xpath = ".//input[@class='btn btn-primary']")
    private WebElement logoutButton;

    @FindBy(xpath = ".//li[@class='active']/span[@itemprop='name']")
    private WebElement pageLocationText;

    @FindBy(xpath = ".//ul[@class='nav menu']/li[@class='item-102']/a")
    private WebElement profileItemMenuItem;

    @FindBy(xpath = ".//ul[@class='nav menu']/li[@class='item-104']/a")
    private WebElement submitArticleMenuItem;

    @FindBy(xpath = ".//div[@id='system-message']/div/div/div[@class='alert-message']")
    private WebElement articleSubmittedMessage;

    @FindBy(xpath = ".//div[@class='icons']/div/a[@class='btn dropdown-toggle']")
    private WebElement settingsButton;

    @FindBy(xpath = ".//ul[@class='dropdown-menu']/li/a[@title='Edit article']")
    private WebElement editButton;

    @FindBy(xpath = ".//ul[@class='nav menu']/li[@class='item-106']/a")
    private WebElement templateMenuItem;

    private WebDriver webDriver;

    public AdminHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Object goToPage(Page page){
        switch (page){

            //Go to "Submit an article" page
            case AdminSubmitArticlePage:
                submitArticleMenuItem.click();

                return PageFactory.initElements(webDriver, AdminSubmitArticlePage.class);

            //Go to "Profile" page
            case AdminProfilePage:
                profileItemMenuItem.click();

                return PageFactory.initElements(webDriver, AdminProfilePage.class);

            //Go to "Admin edit home page"
            case AdminEditHomePage:
                settingsButton.click();
                editButton.click();

                return PageFactory.initElements(webDriver, AdminEditHomePage.class);

            //Go to "Template Settings" page
            case AdminTemplatePage:
                templateMenuItem.click();

                return PageFactory.initElements(webDriver, AdminTemplatePage.class);

        }
        return null;
    }

    //Search
    public SearchResultsPage goToSearchResultsPage(String string){
        searchBox.click();
        searchBox.sendKeys(string);
        searchBox.sendKeys(Keys.ENTER);

        return PageFactory.initElements(webDriver, SearchResultsPage.class);
    }

    //Page location
    public String getPageLocation(){
        return pageLocationText.getText();
    }

    // Verify if "Article submitted" message is displayed
    public Boolean submittedMessageIsDisplayed(){
        articleSubmittedMessage.isDisplayed();
        return true;
    }

    //Logout
    public void logout(){
        logoutButton.click();
    }
}
