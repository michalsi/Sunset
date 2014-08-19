package com.sunset.pages;

import com.sunset.framework.PageInteractionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class IssuesAdvancedSearch extends PageInteractionHelper {
    public static final By SEARCH_WITHIN  = By.xpath("//*[@id=\"maincol\"]/form/table/tbody/tr[1]/td[3]/select");
    public static final By WITH_WORDS_FIELD  = By.name("words");
    public static final By WITHOUT_WORDS_FIELD  = By.name("without");
    public static final By LABEL_FIELD  = By.name("labels");
    public static final By STATUSES_FIELD  = By.name("statuses");
    public static final By REPORTERS_FIELD  = By.name("reporters");
    public static final By OWNERS_FIELD  = By.name("owners");
    public static final By CC_FIELD  = By.name("cc");
    public static final By COMMENTED_BY_FIELD  = By.name("cc");
    public static final By SEARCH_BUTTON  = By.name("btn");


public IssuesAdvancedSearch(WebDriver driver) {
        super(driver);
    }

    public IssuesAdvancedSearch selectSearchWithin(String value) {
        Select selectBox = new Select(getElement(SEARCH_WITHIN));
        selectBox.selectByVisibleText(" "+value);
        return this;
    }

    public IssuesAdvancedSearch enterWithWords(String words) {
        typeText(WITH_WORDS_FIELD, words);
               return this;
    }
    
    public IssuesAdvancedSearch enterWithoutWords(String words) {
        typeText(WITHOUT_WORDS_FIELD, words);
               return this;
    }


    public IssuesAdvancedSearch enterOwners(String owner){
        typeText(OWNERS_FIELD,owner);
        return this;
    }

    public IssuesAdvancedSearch enterLabels(String label){
        typeText(LABEL_FIELD,label);
        return this;
    }

    public IssuesAdvancedSearch enterStatuses(String status){
        typeText(STATUSES_FIELD,status);
        return this;
    }

    public IssuesAdvancedSearch enterReporters(String reporters){
        typeText(REPORTERS_FIELD,reporters);
        return this;
    }

    public IssuesAdvancedSearch enterCc(String cc){
        typeText(CC_FIELD,cc);
        return this;
    }

    public IssuesAdvancedSearch enterCommentedBy(String commentBy){
        typeText(COMMENTED_BY_FIELD,commentBy);
        return this;
    }


    public void clickSearch(){
        clickOnElement(SEARCH_BUTTON);
    }

}
