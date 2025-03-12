package com.SwagLabs.comp_loginpage;
import com.SwagLabs.Utilites.Helpers.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class LoginPageComp extends LoginPageWebElement{

    @Step("Check Login Page Opened")
    public void checkLoginPageOpened(){
        LogsUtils.debug("check Login Page Opened");
        /// Check Container
        WebElement loginPageContainer = getLoginPageContainer();
        checkIfNotNull(loginPageContainer,"Login Page Container");

        /// Check URL
        checkIfContainText(getCurrentURL(),"saucedemo.com");
    }

    @Step("Check Login Successfully With Valid Data")
    public void checkLoginSuccessfullyWithValidData(String userName, String password){
        LogsUtils.debug("check Login Successfully With Valid Data");
        /// Enter Data In The UserName Field
        WebElement userNameField = getUserNameField();
        checkIfNotNull(userNameField,"UserName Field");
        sendData(userNameField,userName,"UserName Field");

        /// Enter Data In The Password Field
        WebElement passwordField = getPasswordField();
        checkIfNotNull(passwordField,"Password Field");
        sendData(passwordField,password, "Password Field");

        ///  Click On The login Button
        WebElement loginButton = getLoginButton();
        checkIfNotNull(loginButton,"Login Button");
        click(loginButton,"Login Button");
    }

    @Step("Check Login Failed With Invalid Data Using Java Faker")
    public void checkLoginFailedUsingJavaFaker(String userName, String password){
        LogsUtils.debug("check Login Failed With Invalid Data Using Java Faker");
        /// Enter Data In The UserName Field
        WebElement userNameField = getUserNameField();
        checkIfNotNull(userNameField,"UserName Field");
        sendData(userNameField,userName,"UserName Field");

        /// Enter Data In The Password Field
        WebElement passwordField = getPasswordField();
        checkIfNotNull(passwordField,"Password Field");
        sendData(passwordField,password, "Password Field");

        ///  Click On The login Button
        WebElement loginButton = getLoginButton();
        checkIfNotNull(loginButton,"Login Button");
        click(loginButton,"Login Button");
    }

    @Step("Check Error Message")
    public void checkErrorMessageAfterLoginUsingInvalidData(){
        LogsUtils.debug("Check Error Message After Login Using Invalid Data");
        WebElement errorMessage = getErrorMessage();
        checkIfNotNull(errorMessage,"Error Message");
        checkIfDisplayed(errorMessage,"Error Message");
        checkIfTextEqual(errorMessage.getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }


}
