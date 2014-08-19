package com.sunset.pages;

import com.sunset.framework.PageInteractionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuesList extends PageInteractionHelper {
   public static final By ADVANCED_SEARCH_LINK  = By.xpath("/html/body/table/tbody/tr/td[1]/div/div/span[3]/a");
   public static final By NUMBER_OF_ISSUES  = By.cssSelector("#colcontrol > div.list > div.pagination");


    public IssuesList(WebDriver driver) {
        super(driver);
    }

    public void clickOnAdvancedSearchLink(){
        clickOnElement(ADVANCED_SEARCH_LINK);
    }

    public String  getNumberOfIssues(){
        return getText(NUMBER_OF_ISSUES);
    }
}
