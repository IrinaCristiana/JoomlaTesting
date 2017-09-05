package com.endava.joomlaTesting;

import org.junit.Assert;
import org.junit.Test;

public class JoomlaTest extends BaseClassTest {

    @Test
    public void adminHomePageTest(){
        Assert.assertEquals("Home", adminHomePage.getPageLocation());
        System.out.println("You are here: "+ adminHomePage.getPageLocation());
    }

     @Test
    public void searchTest(){
        SearchResultsPage searchResultsPage = adminHomePage.goToSearchResultsPage("site");
        String totalResultsFound = searchResultsPage.getTotalResultsFound();
        System.out.println("Total Results Found: "+ totalResultsFound);
        searchResultsPage.goToAdminHomePage();
        Assert.assertEquals("26", totalResultsFound);

    }

    @Test
    public void adminEditHomePageTest(){
        AdminEditHomePage adminEditHomePage = (AdminEditHomePage) adminHomePage.goToPage(Page.AdminEditHomePage);
        Assert.assertEquals("448", adminEditHomePage.getTheNumberOfWords().toString());
        System.out.println("Number of words: " + adminEditHomePage.getTheNumberOfWords());
    }

    @Test
    public void adminProfilePageTest(){
        AdminProfilePage adminProfilePage = (AdminProfilePage) adminHomePage.goToPage(Page.AdminProfilePage);
        Assert.assertEquals("Your Profile", adminProfilePage.getPageLocation());
        System.out.println("You are here: "+ adminProfilePage.getPageLocation());
    }

    @Test
    public void AdminSubmitArticlePageTest(){
        AdminSubmitArticlePage adminSubmitArticlePage = (AdminSubmitArticlePage) adminHomePage.goToPage(Page.AdminSubmitArticlePage);
        Assert.assertTrue(adminSubmitArticlePage.submitArticle(" ").contains("error"));
        adminHomePage = adminSubmitArticlePage.submitArticle("Test Tile", "Content Test ");
        Assert.assertTrue("Article submitted", adminHomePage.submittedMessageIsDisplayed());
    }

    @Test
    public void AdminTemplatePageTest(){
        AdminTemplatePage adminTemplatePage = (AdminTemplatePage) adminHomePage.goToPage(Page.AdminTemplatePage);
        Assert.assertEquals("Template Settings", adminTemplatePage.getPageLocation());
        System.out.println("You are here: "+ adminTemplatePage.getPageLocation());
    }
}
