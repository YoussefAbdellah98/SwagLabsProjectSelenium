package com.SwagLabs.comp_header;

import com.SwagLabs.Utilites.FindingElements;
import org.openqa.selenium.WebElement;

public class HeaderWebElement extends FindingElements {

    public WebElement getHeaderContainer(){
        return findElementById("header_container","Header Container");
    }

    public WebElement getLogo(){
        return findElementByClassName("app_logo","Logo");
    }

    public WebElement getCartButton(){
        return findElementById("shopping_cart_container","Shopping Cart Button");
    }

    public WebElement getLeftSideBarButton(){
        return findElementById("react-burger-menu-btn","Left Sidebar Button");
    }
}
