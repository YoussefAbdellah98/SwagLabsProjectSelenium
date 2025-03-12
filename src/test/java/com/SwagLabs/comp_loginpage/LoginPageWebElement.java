package com.SwagLabs.comp_loginpage;

import com.SwagLabs.Utilites.FindingElements;
import org.openqa.selenium.WebElement;

public class LoginPageWebElement extends FindingElements {

    public WebElement getUserNameField() {
        return findElementById("user-name", "UserName Field");}

    public WebElement getPasswordField() {
        return findElementById("password", "Password Field");
    }

    public WebElement getLoginButton() {
        return findElementById("login-button", "Login Button");
    }

    public WebElement getLoginPageContainer(){return findElementByClassName("login_container","Login Container");}

    public WebElement getErrorMessage(){return findElementByClassName("error-message-container","Error Message");}
}
