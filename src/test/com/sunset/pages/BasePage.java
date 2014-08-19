package com.sunset.pages;

import com.sunset.framework.PageInteractionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends PageInteractionHelper {

    private static final By PROJECTS = By.cssSelector("#menu_projects > a");
    private static final By SUPPORT = By.cssSelector("#menu_support > a");



    public BasePage(WebDriver driver) {
        super(driver);
    }

    public BasePage clickProjectsTab(){
        clickOnElement(PROJECTS);
        return this;
    }

    public BasePage clickSupportTab(){
        clickOnElement(SUPPORT);
        return this;
    }

}
