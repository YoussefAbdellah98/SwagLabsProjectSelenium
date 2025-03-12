package com.SwagLabs.Utilites;

import com.SwagLabs.Utilites.Drivers.SettingUpWebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class TestingMethod extends SettingUpWebDriver {

    @Step("check If Not Null")
    public void checkIfNotNull(WebElement element, String ElementName){
        if(element == null){
            String errorMessage = String.format("Expected " + ElementName + " to be exist but it was null");
            throw new AssertionError(errorMessage);
        }
    }

    @Step("Check If Null")
    public void checkIfNull(WebElement element, String ElementName){
        if(element != null){
            String errorMessage = String.format("Expected " + ElementName + " to be null but it was exist");
            throw new AssertionError(errorMessage);
        }
    }

    @Step("Check If Enabled")
    public void checkIfEnabled(WebElement element, String ElementName){
        if(!element.isEnabled()){
            String errorMessage = String.format("Expected " + ElementName + " to be enabled but it was disabled");
            throw new AssertionError(errorMessage);
        }
    }

    @Step("Check If Displayed")
    public void checkIfDisplayed(WebElement element, String ElementName){
        if(!element.isDisplayed()){
            String errorMessage = String.format("Expected " + ElementName + " to be displayed but it was hidden ");
            throw new AssertionError(errorMessage);
        }
    }

    @Step("check If Text Equal")
    public void checkIfTextEqual(String actualResult, String expectedResult){
        if(!actualResult.equals(expectedResult)){
            String errorMessage = String.format("Expected the actual result " + actualResult + " equal the expected result "+expectedResult);
            throw new AssertionError(errorMessage);
        }
    }

    @Step("check If Contain Text")
    public static void checkIfContainText(String actualResult, String expectedResult){
        if(!actualResult.contains(expectedResult)){
            String errorMessage = String.format("Expected the actual result " + actualResult + " contain the expected result "+expectedResult);
            throw new AssertionError(errorMessage);
        }
    }

    @Step("check If Selected")
    public void checkIfSelected(WebElement element, String ElementName){
        if(!element.isSelected()){
            String errorMessage = String.format("Expected " + ElementName + " to be selected but it was not selectable");
            throw new AssertionError(errorMessage);
        }
    }


}
