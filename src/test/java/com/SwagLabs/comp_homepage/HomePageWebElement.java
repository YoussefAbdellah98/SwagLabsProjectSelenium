package com.SwagLabs.comp_homepage;

import com.SwagLabs.Utilites.FindingElements;
import org.openqa.selenium.WebElement;

public class HomePageWebElement extends FindingElements {

    public WebElement getHomePageContainer(){
        return findElementById("page_wrapper","Home Page Container");
    }

    public WebElement getFirstProduct(){
        return findElementById("item_4_img_link","First Product");
    }
    public WebElement getLastProduct(){
        return findElementById("item_3_img_link","Last Product");
    }
}
