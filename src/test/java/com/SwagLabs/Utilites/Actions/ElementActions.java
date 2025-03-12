package com.SwagLabs.Utilites.Actions;

import com.SwagLabs.Utilites.Helpers.LogsUtils;
import com.SwagLabs.Utilites.WaitingMethod;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementActions extends WaitingMethod {


    @Step("Click On")
    public static void click(WebElement element, String ElementName) {
        explicitWaitForClickable(element);
        scrollToElement(element, ElementName);
        element.click();
        LogsUtils.info("Click On The: ", "[", ElementName, "]");

    }

    @Step("Send Data")
    public static void sendData(WebElement element, String Data, String ElementName) {
        explicitWaitForClickable(element);
        scrollToElement(element, ElementName);
        element.sendKeys(Data);
        LogsUtils.info("Data Entered Is: ", "[", Data, "]", "In The Field", "[", ElementName, "]");

    }

    @Step("Get Text")
    public static void getText(WebElement element, String ElementName) {
        explicitWaitForVisibilityOfElementLocated(element);
        scrollToElement(element, ElementName);
        element.getText();
        LogsUtils.info("The Text Is: ", "[", ElementName, "]");

    }

    @Step("Hover On")
    public static void MoveToElement(WebElement element, String ElementName) {
        explicitWaitForVisibilityOfElementLocated(element);
        scrollToElement(element,ElementName);
        new Actions(getDriver()).moveToElement(element).perform();
        LogsUtils.info("Hover On The: ", "[", ElementName, "]");

    }

    @Step("Scroll To")
    public static void scrollToElement(WebElement element, String ElementName) {
        explicitWaitForVisibilityOfElementLocated(element);
        ((JavascriptExecutor) (getDriver())).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        LogsUtils.info("Scroll To: ", "[", ElementName, "]");

    }

    @Step("Select By Index")
    public static void selectByIndex(WebElement element, String ElementName ,int index){
       explicitWaitForVisibilityOfElementLocated(element);
       scrollToElement(element,ElementName);
       new Select(element).selectByIndex(index);
        LogsUtils.info("Select By Index: ", "[", String.valueOf(index), "]");

    }

    @Step("Select By Value")
    public static void selectByValue(WebElement element, String ElementName){
        explicitWaitForVisibilityOfElementLocated(element);
        scrollToElement(element,ElementName);
        new Select(element).selectByValue(ElementName);
        LogsUtils.info("Select By Value: ", "[", ElementName, "]");

    }


}
