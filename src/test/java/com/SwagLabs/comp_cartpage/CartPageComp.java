package com.SwagLabs.comp_cartpage;

import com.SwagLabs.Utilites.Helpers.LogsUtils;
import org.openqa.selenium.WebElement;

public class CartPageComp extends CartPageWebElement{

    public void checkCartPageOpened(){
        LogsUtils.debug("check Cart Page Opened");
        /// Check Container
        WebElement cartPageContainer = getCartPageContainer();
        checkIfNotNull(cartPageContainer,"Cart Page Container");

        /// Check URL
        checkIfContainText(getCurrentURL(),"/cart.html");
    }



}
