package com.sunset.framework;

public class BaseTest {

    private DriverFactory driverFactory;
    protected Browser browser;
    private DriverConfiguration driverCfg;


    public void setupBaseTest() {
        this.driverFactory = new DriverFactory();
        this.browser = new Browser(driverFactory.getDriver());
        this.driverCfg = new DriverConfiguration();

        browser.goToLandingPage(driverCfg);
    }


    public void  endSession(){
        browser.quit();
    }
}
