package com.endava.joomlaTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminTemplatePage {

   // @FindBy(xpath = ".//div[@id='page-site']/div/fieldset/div[3]/div[2]/div/div[2]/a[1]")
    @FindBy(xpath = ".//fieldset/div[3]/div[2]/div/div[2]/a[1]")
    private WebElement selectButton;

    @FindBy(xpath = ".//button[@class='btn btn-primary']")
    private WebElement saveButton;

    @FindBy(xpath = ".//li[@class='active']/span[@itemprop='name']")
    private WebElement pageLocationText;

    private WebDriver webDriver;

    public AdminTemplatePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //Page location
    public String getPageLocation(){
        return pageLocationText.getText();
    }
}
