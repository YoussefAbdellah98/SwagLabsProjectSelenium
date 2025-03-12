package com.SwagLabs.comp_leftsidebar;

import com.SwagLabs.Utilites.Helpers.LogsUtils;
import org.openqa.selenium.WebElement;

public class LeftSideBarComp extends LeftSideBarWebElement{

    public void checkLeftSideBarContainer(){
        LogsUtils.debug("check Left SideBar Container");
        WebElement leftSideBarContainer = getLeftSideBarContainer();
        checkIfNotNull(leftSideBarContainer,"Left SideBar Container");
    }


}
