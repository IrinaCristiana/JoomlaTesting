package com.endava.joomlaTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {

    @FindBy(xpath = ".//form[@id='searchForm']/div[@class='searchintro']/p/strong/span")
    private WebElement totalResultsFound;

    private WebDriver webDriver;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getTotalResultsFound(){
        String totalResults =  totalResultsFound.getText();
      return totalResults;
    }
}
