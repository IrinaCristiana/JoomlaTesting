package com.endava.joomlaTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminEditHomePage {

    @FindBy(xpath = ".//div[@id='mceu_94-body']/span[@id='mceu_97']")
    private WebElement wordsNumber;

    private WebDriver webDriver;

    public AdminEditHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Get only the integers from a text
    public Integer getTheNumberOfWords(){
        return Integer.parseInt((wordsNumber.getText().replaceAll("[^0-9\\]]+","")));
    }
}
