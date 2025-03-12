package com.SwagLabs.test_loginpage;
import com.SwagLabs.Utilites.Helpers.AllureUtils;
import com.SwagLabs.Utilites.DataDriven.JsonFile;
import com.SwagLabs.Utilites.DataDriven.PropertiesFile;
import com.SwagLabs.Utilites.Helpers.FilesUtils;
import com.SwagLabs.comp_homepage.HomePageComp;
import com.SwagLabs.comp_loginpage.LoginPageComp;
import com.github.javafaker.Faker;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class LoginPageCompTest extends LoginPageComp {

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
    public void verifyLoginSuccessfulUsingPropertiesFile(){
        /// Check Login Page Opened
        checkLoginPageOpened();

        /// Check Login Successfully With Valid Data
        checkLoginSuccessfullyWithValidData(
                PropertiesFile.getConfigValue("login","userName"),
                PropertiesFile.getConfigValue("login","password"));

        /// Check Home Page Opened
        HomePageComp homePageComp = new HomePageComp();
        homePageComp.checkHomePageOpened();

    }

    @Test(priority = 2)
    public void verifyLoginSuccessfulUsingJsonFile(){
        /// Check Login Page Opened
        checkLoginPageOpened();

        /// Check Login Successfully With Valid Data
        checkLoginSuccessfullyWithValidData(
                JsonFile.getJsonData("test-login-data","login-valid-data.userName"),
                JsonFile.getJsonData("test-login-data","login-valid-data.password"));

        /// Check Home Page Opened
        HomePageComp homePageComp = new HomePageComp();
        homePageComp.checkHomePageOpened();
    }

    @Test(priority = 3)
    public void verifyErrorMessageLoginFailedUsingJavaFaker(){
        Faker fakerData = new Faker();
        /// Check Login Page Opened
        checkLoginPageOpened();

        /// Check Login Successfully With Valid Data
        checkLoginFailedUsingJavaFaker(
                fakerData.name().username(),
                fakerData.internet().password());

        /// Check Error Message
        checkErrorMessageAfterLoginUsingInvalidData();
    }




}
