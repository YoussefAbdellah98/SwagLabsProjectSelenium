package com.SwagLabs.Utilites.Actions;

import com.SwagLabs.Utilites.Helpers.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

public class BrowserActions extends ElementActions {

    /// ***************** URL Control And Navigation *****************///
    @Step("Navigate To Url")
    public static void navigateToURL(String URL){
        getDriver().navigate().to(URL);
        LogsUtils.info("Navigate To Url: ","[",URL,"]");
    }

    @Step("Get Current Url")
    public String getCurrentURL(){
        LogsUtils.info("Navigate To Url: ","[", getDriver().getCurrentUrl(),"]");
        return getDriver().getCurrentUrl();
    }

    @Step("Get Page Title")
    public static String getPageTitle(){
        LogsUtils.info("The Page Title Is: ","[",getDriver().getTitle(),"]");
        return getDriver().getTitle();
    }

    @Step("Refresh Page")
    public void refreshPage(){
        LogsUtils.info("Refreshing The Page");
        getDriver().navigate().refresh();
    }

    @Step("Navigate Back")
    public void navigateBack(){
        LogsUtils.info("Backing The Page");
        getDriver().navigate().back();
    }

    @Step("Navigate Forward")
    public void navigateForward(){
        LogsUtils.info("Forwarding The Page");
        getDriver().navigate().forward();
    }

    /// ***************** Window Control *****************///


    @Step("Full Screen Window")
    public void fullScreenWindow(){
        LogsUtils.info("Full Screen Window");
        getDriver().manage().window().fullscreen();
    }

    @Step("Minimize Screen Window")
    public void minimizeScreenWindow(){
        LogsUtils.info("Minimizing Screen Window");
        getDriver().manage().window().minimize();
    }

    @Step("Maximize Screen Window")
    public void maximizeScreenWindow(){
        LogsUtils.info("Maximizing Screen Window");
        getDriver().manage().window().maximize();
    }

    @Step("Accept Alert")
    public static void acceptAlert(){
        LogsUtils.info("Accepting Alert");
        getDriver().switchTo().alert().accept();
    }

    @Step("Get Alert Text")
    public static void getAlertText(){
        LogsUtils.info("Get Alert Text");
        getDriver().switchTo().alert().getText();
    }

    @Step("Dismiss Alert")
    public static void dismissAlert(){
        LogsUtils.info("Dismiss Alert");
        getDriver().switchTo().alert().dismiss();
    }

    @Step("Send Data Alert")
    public static void sendDataAlert(String Text){
        LogsUtils.info("Send Data Alert");
        getDriver().switchTo().alert().sendKeys(Text);
    }

    /// ***************** Cookies *****************///

    @Step("Add Cookie")
    public static void addCookie(Cookie cookie){
        LogsUtils.info("Adding Cookie");
        getDriver().manage().addCookie(cookie);
    }

    @Step("Delete Cookie")
    public static void deleteCookie(Cookie cookie){
        LogsUtils.info("Deleting Cookie");
        getDriver().manage().deleteCookie(cookie);
    }

    @Step("Delete All Cookies")
    public static void deleteAllCookies(Cookie cookie){
        LogsUtils.info("Deleting All Cookies");
        getDriver().manage().deleteAllCookies();
    }

    @Step("Delete Cookie With Name")
    public static void deleteCookieWithName(String name){
        LogsUtils.info("Delete Cookie With Name");
        getDriver().manage().deleteCookieNamed(name);
    }

    @Step("Get Cookie With Name")
    public static void getCookieWithName(String name){
        LogsUtils.info("Get Cookie With Name");
        getDriver().manage().getCookieNamed(name);
    }




}
