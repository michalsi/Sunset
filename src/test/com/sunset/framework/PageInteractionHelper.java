package com.sunset.framework;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sunset.framework.HardWait.*;

public abstract class PageInteractionHelper {

    public WebDriver driver;

    public PageInteractionHelper(WebDriver driver) {
        this.driver = driver;
    }



    /**
     * Waits
     */

    private WebDriverWait driverWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new WebDriverWait(driver, 30);
    }

    private WebDriverWait driverWaitZeroTimeout() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        return new WebDriverWait(driver, 0);
    }

    public List<WebElement> getChildren(By parentSelector, By childrenSelector) {
        WebElement parent = getElement(parentSelector);
        return parent.findElements(childrenSelector);
    }

    public WebElement waitUntilPresent(By locator) {
        return driverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public WebElement waitUntilClickable(final By locator) {
        return driverWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitUntilVisible(final By locator) {
        return driverWait().until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
    }

    public boolean waitUntilInvisible(final By locator) {
        return driverWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitUntilText(final By locator, final String text) {
        return driverWait().until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return getText(locator).trim().equals(text);
            }
        });
    }

    public boolean waitUntilRemoved(final By locator, final Optional<WebElement> parent) {
        return driverWait().until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                if (parent.isPresent()) {
                    driverWaitZeroTimeout();
                    Boolean res = parent.get().findElements(locator).size() == 0;
                    driverWait();
                    return res;
                } else {
                    driverWaitZeroTimeout();
                    Boolean res = driver.findElements(locator).size() == 0;
                    driverWait();
                    return res;
                }
            }
        });
    }

    public boolean isElementPresent(final By locator) {
        try {
            return driverWait().until(ExpectedConditions.presenceOfElementLocated(locator)) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrappers
     */

    public WebElement getElement(By locator) {
        return waitUntilPresent(locator);
    }

    public List<WebElement> getElements(By locator) {
        return waitUntilPresent(locator).findElements(locator);
    }

    public void clickOnElement(By locator) {
        waitUntilClickable(locator).click();
    }

    public String getText(By locator) {
        try {
            return getElement(locator).getText();
        } catch (StaleElementReferenceException sere) {
            midSleep();
            return getElement(locator).getText();
        }
    }

    public String getValue(By locator) {
        return getElement(locator).getAttribute("value");
    }

    public List<String> getTexts(By locator) {
        List<String> texts = new ArrayList<>();
        waitUntilPresent(locator).findElements(locator);
        for (WebElement element : waitUntilPresent(locator).findElements(locator)) {
            texts.add(element.getText());
        }
        return texts;
    }

    /**
     * @param locator to locate on page
     * @param text    to type into locator
     */
    public void typeText(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    /**
     * @param locator to locate on page
     * @param text    to type into locator
     */
    public void typeTextWithClear(By locator, String text) {
        clearText(locator);
        typeText(locator, text);
    }

    public void typeTextCharByChar(By locator, String text) {
        clickOnElement(locator);
        int numberOfChars = text.length();
        for (int i = 0; i < numberOfChars; i++) {
            try {
                getElement(locator).sendKeys(String.valueOf(text.charAt(i)));
            } catch (NoSuchElementException nsee) {
                // Handle VERY slow async content reload
                midSleep();
                getElement(locator).sendKeys(String.valueOf(text.charAt(i)));
            }
            veryVeryShortSleep();
        }
        midSleep();
    }

    public void clearText(By locator) {
        // hard wait to prevent random issues on heavily loaded system
        midSleep();
        clickOnElement(locator);
        int numberOfChars = getValue(locator).length();

        // When clicking on an element, sometimes the cursor is
        // not at the right most position. Make sure the cursor
        // is far right before removing each character.
        for (int i = 0; i < numberOfChars; i++) {
            getElement(locator).sendKeys(Keys.ARROW_RIGHT);
            veryVeryShortSleep();
        }

        for (int i = 0; i < numberOfChars; i++) {
            getElement(locator).sendKeys(Keys.BACK_SPACE);
            veryVeryShortSleep();
        }

        getElement(locator).clear();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (TimeoutException te) {
            return false;
        } catch (StaleElementReferenceException sere) {
            midSleep();
            return getElement(locator).isDisplayed();
        } catch (NoSuchElementException nsee) {
            midSleep();
            return getElement(locator).isDisplayed();
        }
    }

    public boolean isElementEnabled(By locator) {
        try {
            WebElement element = getElement(locator);
            return element.isEnabled() && element.isDisplayed();
        } catch (TimeoutException te) {
            return false;
        }
    }

    public void selectDropdownItem(By locator, String item) {

        Select dropDownList = new Select(getElement(locator));
        dropDownList.selectByVisibleText(item);
        veryShortSleep(); //required by chrome
    }

    public String getSelectedDropdownItem(By locator) {
        Select dropDownList = new Select(getElement(locator));
        return dropDownList.getFirstSelectedOption().getText();
    }

    public List<String> getDropdownItems(By locator) {
        Select dropDownList = new Select(getElement(locator));
        List<WebElement> webElementList = dropDownList.getOptions();
        List<String> dropDownListItems = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            dropDownListItems.add(webElement.getText());
        }
        return dropDownListItems;
    }

}

