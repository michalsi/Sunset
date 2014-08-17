package com.sunset.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverFactory {

    private WebDriver driver;

    public DriverFactory() {
        if (this.driver == null) {
            driver = getFirefox();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver getFirefox() {
        FirefoxProfile fp = new FirefoxProfile();
        fp.setPreference("getBrowser.download.manager.showWhenStarting", false);
        fp.setPreference("getBrowser.helperApps.neverAsk.saveToDisk", "application/pdf");
        return driver = new FirefoxDriver(fp);
    }

}
