package com.SwagLabs.Utilites;

import com.SwagLabs.Utilites.Actions.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class FindingElements extends BrowserActions {

    /// LoginComp --> LoginWebElement --> FindingElements --> Browser Action --> Element Action --> Waiting Method
    ///  --> Testing Method --> SettingUpWebDriver



    public WebElement findElementById(String id, String elementName) {
        try {
            return explicitWaitForPresenceOfElementLocated(By.id(id));
        } catch (TimeoutException e) {
            throw new AssertionError("Timeout: Element [" + elementName + "] with ID [" + id + "] was not found within 10 seconds.");
        }
    }

    public WebElement findElementByClassName(String className, String elementName) {
        try {
            return explicitWaitForPresenceOfElementLocated(By.className(className));
        } catch (TimeoutException e) {
            throw new AssertionError("Timeout: Element [" + elementName + "] with className [" + className + "] was not found within 10 seconds.");
        }
    }







}
