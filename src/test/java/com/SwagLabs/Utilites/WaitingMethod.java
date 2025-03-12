package com.SwagLabs.Utilites;

import com.SwagLabs.Utilites.DataDriven.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitingMethod extends TestingMethod {

    public static void explicitWaitForClickable(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(Long.parseLong(PropertiesFile.getConfigValue("waits","Explicit"))))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void explicitWaitForVisibilityOfElementLocated(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(Long.parseLong(PropertiesFile.getConfigValue("waits","Explicit"))))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement explicitWaitForPresenceOfElementLocated(By locator) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(Long.parseLong(PropertiesFile.getConfigValue("waits","Explicit"))))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }



}

