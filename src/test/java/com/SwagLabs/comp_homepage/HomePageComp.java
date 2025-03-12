package com.SwagLabs.comp_homepage;
import com.SwagLabs.Utilites.DataDriven.PropertiesFile;
import com.SwagLabs.Utilites.Helpers.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class HomePageComp extends HomePageWebElement{

    @Step("check Home Page Opened")
    public void checkHomePageOpened(){
        LogsUtils.debug("check Home Page Opened");
        /// Check Container
        WebElement homePageContainer = getHomePageContainer();
        checkIfNotNull(homePageContainer,"Home Page Container");

        /// Check URL
        checkIfContainText(getCurrentURL(),
                PropertiesFile.getConfigValue("home","homeUrl"));
    }

    public void checkScrollUpAndScrollDown() throws InterruptedException {
        LogsUtils.debug("check ScrollUp And ScrollDown");
        /// Check ScrollUp
        WebElement lastProduct = getLastProduct();
        checkIfNotNull(lastProduct,"Last Product");
        scrollToElement(lastProduct,"Last Product");
        Thread.sleep(1000);

        /// Check ScrollDown
        WebElement firstProduct = getFirstProduct();
        checkIfNotNull(firstProduct,"First Product");
        scrollToElement(firstProduct,"First Product");
        Thread.sleep(1000);

    }
}
