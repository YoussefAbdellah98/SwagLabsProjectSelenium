package com.SwagLabs.comp_leftsidebar;

import com.SwagLabs.Utilites.FindingElements;
import org.openqa.selenium.WebElement;

public class LeftSideBarWebElement extends FindingElements {

    public WebElement getLeftSideBarContainer(){
        return findElementByClassName("bm-menu-wrap","Left SideBar Container");
    }
}
