package com.endava.joomlaTesting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminHomePage{

    @FindBy(xpath = ".//input[@id='mod-search-searchword94']")
    private WebElement searchBox;

    @FindBy(xpath = ".//form[@id='login-form']/div[@class='logout-button']/input[@class='btn btn-primary']")
    private WebElement logoutButton;

    @FindBy(xpath = ".//main[@id='content']/ul/li[@class='active']/span[@itemprop='name']")
    private WebElement pageLocationText;

    @FindBy(xpath = ".//div[@id='aside']/div[2]/ul[@class='nav menu']/li[@class='item-102']/a")
    private WebElement profileItemMenuItem;

    @FindBy(xpath = ".//div[@id='aside']/div[2]/ul[@class='nav menu']/li[@class='item-104']/a")
    private WebElement submitArticleMenuItem;

    @FindBy(xpath = ".//div[@id='system-message']/div/div/div[@class='alert-message']")
    private WebElement articleSubmittedMessage;

    @FindBy(xpath = ".//main[@id='content']/div[@class='item-page']/div[@class='icons']/div/a[@class='btn dropdown-toggle']")
    private WebElement settingsButton;

    @FindBy(xpath = ".//main[@id='content']/div[@class='item-page']/div[2]/div/ul[@class='dropdown-menu']/li/a[@title='Edit article']")
    private WebElement editButton;

    @FindBy(xpath = ".//div[@id='aside']/div[2]/ul[@class='nav menu']/li[@class='item-106']/a")
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

                AdminSubmitArticlePage adminSubmitArticlePage = PageFactory.initElements(webDriver, AdminSubmitArticlePage.class);
                return adminSubmitArticlePage;

            //Go to "Profile" page
            case AdminProfilePage:
                profileItemMenuItem.click();

                AdminProfilePage adminProfilePage = PageFactory.initElements(webDriver, AdminProfilePage.class);
                return adminProfilePage;

            //Go to "Admin edit home page"
            case AdminEditHomePage:
                settingsButton.click();
                editButton.click();

                AdminEditHomePage adminEditHomePage = PageFactory.initElements(webDriver, AdminEditHomePage.class);
                return adminEditHomePage;

            //Go to "Template Settings" page
            case AdminTemplatePage:
                templateMenuItem.click();

                AdminTemplatePage adminTemplatePage = PageFactory.initElements(webDriver, AdminTemplatePage.class);
                return adminTemplatePage;
        }
        return null;
    }

    //Search
    public SearchResultsPage goToSearchResultsPage(String string){
        searchBox.click();
        searchBox.sendKeys(string);
        searchBox.sendKeys(Keys.ENTER);

        SearchResultsPage searchResultsPage = PageFactory.initElements(webDriver, SearchResultsPage.class);
        return searchResultsPage;
    }

    //Page location
    public String getPageLocation(){
        String pageLocation = pageLocationText.getText();
        return pageLocation;
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
