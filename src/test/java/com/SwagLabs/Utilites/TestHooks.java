package com.SwagLabs.Utilites;

import com.SwagLabs.Utilites.DataDriven.PropertiesFile;
import com.SwagLabs.Utilites.Helpers.AllureUtils;
import com.SwagLabs.Utilites.Helpers.FilesUtils;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

import static com.SwagLabs.Utilites.Actions.BrowserActions.getPageTitle;
import static com.SwagLabs.Utilites.Actions.BrowserActions.navigateToURL;
import static com.SwagLabs.Utilites.Drivers.SettingUpWebDriver.closeDriver;
import static com.SwagLabs.Utilites.Drivers.SettingUpWebDriver.setUpDriver;
import static com.SwagLabs.Utilites.TestingMethod.checkIfContainText;

public class TestHooks {

    @BeforeSuite
    public void beforeSuite() {
        FilesUtils.deleteFiles(new File("test-outputs/allure-results"));
    }

    @Parameters(value = {"browser"})
    @BeforeMethod(alwaysRun = true)
    public void openBrowser(@Optional("chrome") String browser) {
        setUpDriver(PropertiesFile.getConfigValue("browser", "browserType"));
        navigateToURL(PropertiesFile.getConfigValue("login", "loginUrl"));
        checkIfContainText(getPageTitle(), PropertiesFile.getConfigValue("login", "browserTitle"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        closeDriver(result);
    }

    @AfterClass
    public void afterClass() {
        AllureUtils.attachLogsToAllureReport();
    }
}
