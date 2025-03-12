package com.SwagLabs.test_homepage;

import com.SwagLabs.Utilites.Helpers.AllureUtils;
import com.SwagLabs.Utilites.DataDriven.PropertiesFile;
import com.SwagLabs.Utilites.Helpers.FilesUtils;
import com.SwagLabs.comp_homepage.HomePageComp;
import com.SwagLabs.comp_loginpage.LoginPageComp;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class HomePageCompTest extends HomePageComp {

    @BeforeSuite
    public void beforeSuite(){
        FilesUtils.deleteFiles(new File("test-outputs/allure-results"));
    }
    @Parameters(value = {"browser"})
    @BeforeMethod(alwaysRun = true)
    public void openBrowser(@Optional("chrome") String browser){
        setUpDriver(PropertiesFile.getConfigValue("browser","browserType"));
        navigateToURL(PropertiesFile.getConfigValue("login","loginUrl"));
        checkIfContainText(getPageTitle(), PropertiesFile.getConfigValue("login","browserTitle"));

        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.checkLoginSuccessfullyWithValidData(
                PropertiesFile.getConfigValue("login","userName"),
                PropertiesFile.getConfigValue("login","password")
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        closeDriver(result);
    }

    @AfterClass
    public void afterClass(){
        AllureUtils.attachLogsToAllureReport();
    }

    @Test(priority = 1)
    public void verifyScrollUpAndDownForProducts() throws InterruptedException {
        checkScrollUpAndScrollDown();
    }
}
