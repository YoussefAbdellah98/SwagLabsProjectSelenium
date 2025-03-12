package com.SwagLabs.comp_cartpage;

import com.SwagLabs.Utilites.FindingElements;
import org.openqa.selenium.WebElement;

public class CartPageWebElement extends FindingElements {

    public WebElement getCartPageContainer(){
        return findElementById("cart_contents_container","Cart Page Container");
    }
}
