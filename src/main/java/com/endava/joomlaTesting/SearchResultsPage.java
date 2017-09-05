package com.endava.joomlaTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    @FindBy(xpath = ".//div[@class='searchintro']/p/strong/span")
    private WebElement totalResultsFound;

    @FindBy(xpath = ".//*[@id='top']/div/nav/div[@class='nav-collapse']/ul/li/a")
    private WebElement homeButton;

    private WebDriver webDriver;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getTotalResultsFound(){
       return totalResultsFound.getText();
    }

    public AdminHomePage goToAdminHomePage(){
        homeButton.click();

        return PageFactory.initElements(webDriver, AdminHomePage.class);
    }
}
