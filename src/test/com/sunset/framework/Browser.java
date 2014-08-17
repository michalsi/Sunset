package com.sunset.framework;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Wrapper class for browser-related functionalities
 */
public class Browser {

    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Get page title
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Get current URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Click browser back button
     */
    public void back() {
        driver.navigate().back();
    }

    /**
     * Click browser forward button
     */
    public void forward() {
        driver.navigate().forward();
    }

    /**
     * Click browser refresh button
     */
    public void refresh() {
        driver.navigate().refresh();
    }

    /**
     * Delete browser cookies
     */
    public Browser deleteCookies() {
        driver.manage().deleteAllCookies();
        return this;
    }

    /**
     * Quit browser
     */
    public void quit() {
        driver.quit();
    }

    /**
     * Maximize browser window
     */
    public void maximize() {
        driver.manage().window().maximize();
    }

    /**
     * Method to switch to another browser window
     */
    public void switchWindow() {
        Set<String> windows = driver.getWindowHandles();
        if (!(windows.size() >= 1)) {
            return;
        }
        for (String window : windows) {
            driver.switchTo().window(window);
        }
    }


    /**
     * Navigate to CAP landing page
     */
    public void goToLandingPage(DriverConfiguration driverConf) {
        goToUrl(driverConf.getBaseUrl());
    }

    /**
     * Navigate to URL, e.g. http://google.com
     *
     * @param url
     */
    public void goToUrl(String url) {
        driver.get(url);
    }



}
