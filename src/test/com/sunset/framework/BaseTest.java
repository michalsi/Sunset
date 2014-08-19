package com.sunset.framework;

import com.sunset.pages.BasePage;
import com.sunset.pages.IssuesAdvancedSearch;
import com.sunset.pages.IssuesList;
import com.sunset.pages.SupportPage;

public class BaseTest {

    private DriverFactory driverFactory;
    protected Browser browser;
    private DriverConfiguration driverCfg;

    public BasePage basePage;
    public SupportPage supportPage;
    public IssuesAdvancedSearch issuesAdvancedSearch;
    public IssuesList issuesList;




    public void setupBaseTest() {
        this.driverFactory = new DriverFactory();
        this.browser = new Browser(driverFactory.getDriver());
        this.basePage = new BasePage(driverFactory.getDriver());
        this.supportPage = new SupportPage(driverFactory.getDriver());

        this.issuesAdvancedSearch = new IssuesAdvancedSearch(driverFactory.getDriver());
        this.issuesList = new IssuesList(driverFactory.getDriver());
        this.driverCfg = new DriverConfiguration();


        browser.goToLandingPage(driverCfg);
    }


    public void  endSession(){
        browser.quit();
    }
}
