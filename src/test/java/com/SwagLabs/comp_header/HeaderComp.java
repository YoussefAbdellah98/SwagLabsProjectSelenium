package com.SwagLabs.comp_header;

import com.SwagLabs.Utilites.Helpers.LogsUtils;
import org.openqa.selenium.WebElement;

public class HeaderComp extends HeaderWebElement{

    public void checkHeaderContainer(){
        LogsUtils.debug("check Header Container");
        WebElement headerContainer = getHeaderContainer();
        checkIfNotNull(headerContainer,"Header Container");
    }

    public void checkLogoCompany(){
        LogsUtils.debug("check Logo Company");
        WebElement logoCompany = getLogo();
        checkIfNotNull(logoCompany,"Logo Company");
        getText(logoCompany,"Logo Company");
        checkIfTextEqual(logoCompany.getText(),"Swag Labs");
    }

    public void clickOnTheCartButton(){
        LogsUtils.debug("click On The Cart Button");
        WebElement cartButton = getCartButton();
        checkIfNotNull(cartButton,"Cart Button");
        click(cartButton,"Cart Button");
    }

    public void clickOnTheLeftSideBarButton(){
        LogsUtils.debug("click On The Left SideBar Button");
        WebElement leftSideBarButton = getLeftSideBarButton();
        checkIfNotNull(leftSideBarButton,"Left SideBar Button");
        click(leftSideBarButton,"Left SideBar Button");
    }



}
