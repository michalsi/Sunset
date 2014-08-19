package com.sunset.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupportPage extends BasePage {

    private static final By BUG_TRACKER_LINK = By.xpath("//*[@id='mainContent']/p[4]/a");
    public SupportPage(WebDriver driver) {
        super(driver);
    }

    public SupportPage clickBugTrackerLink(){
        clickOnElement(BUG_TRACKER_LINK);
        return this;
    }


}
