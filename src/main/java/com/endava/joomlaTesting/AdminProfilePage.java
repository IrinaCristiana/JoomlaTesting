package com.endava.joomlaTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminProfilePage {

    @FindBy(xpath = ".//main[@id='content']/ul/li[@class='active']/span[@itemprop='name']")
    private WebElement pageLocationText;

    private WebDriver webDriver;

    public AdminProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //Page location
    public String getPageLocation(){
        String pageLocation = pageLocationText.getText();
        return pageLocation;
    }

}
