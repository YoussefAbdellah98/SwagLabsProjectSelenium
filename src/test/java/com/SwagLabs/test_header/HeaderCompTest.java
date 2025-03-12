package com.SwagLabs.test_header;

import com.SwagLabs.Utilites.DataDriven.PropertiesFile;
import com.SwagLabs.comp_cartpage.CartPageComp;
import com.SwagLabs.comp_header.HeaderComp;
import com.SwagLabs.comp_leftsidebar.LeftSideBarComp;
import com.SwagLabs.comp_loginpage.LoginPageComp;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class HeaderCompTest extends HeaderComp {

    @Parameters(value = {"browser"})
    @BeforeMethod(alwaysRun = true)
    public void openBrowser(@Optional("chrome") String browser){
        setUpDriver(PropertiesFile.getConfigValue("environment","browserType"));
        getDriver().navigate().to("https://www.saucedemo.com/");

        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.checkLoginSuccessfullyWithValidData("standard_user","secret_sauce");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        closeDriver(result);
    }


    @Test(priority = 1)
    public void verifyTheLogoCompany(){
        /// Check Header Container
        checkHeaderContainer();

        /// Check Logo
        checkLogoCompany();
    }

    @Test(priority = 2)
    public void verifyClickOnTheCartButtonAndCheckTheCartButtonPageOpened(){
        /// Check Header Container
        checkHeaderContainer();

        /// Click On The Cart Button
        clickOnTheCartButton();

        /// Check The Cart Page Opened
        CartPageComp cartPageComp = new CartPageComp();
        cartPageComp.checkCartPageOpened();
    }

    @Test(priority = 3)
    public void verifyClickOnTheLeftSideBar(){
        /// Check Header Container
        checkHeaderContainer();

        /// Click On The Left SideBar Button
        clickOnTheLeftSideBarButton();

        /// Check Container
        LeftSideBarComp leftSideBarComp = new LeftSideBarComp();
        leftSideBarComp.checkLeftSideBarContainer();
    }
}
