package utils.appium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.appium.driverManager.DriverManager;
import utils.common.LogsUtils;

import java.util.ArrayList;
import java.util.List;

public class ElementsActions {
    public static List<WebElement> findElements(By... locators ) {
        List<WebElement> allElements = new ArrayList<>();
        for(By locator : locators) {
           List <WebElement> elements = DriverManager.getDriver().findElements(locator);
           allElements.addAll(elements);
        }
        return allElements;
    
    }

    public static WebElement findElement(By locator) {
        Waits.waitForElementToBeVisible(locator);
        return DriverManager.getDriver().findElement(locator);
    }

    public static void setValue(By locator, String value) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public static void click(By locator) {
        Waits.waitForElementToBeClickable(locator);
        WebElement element = findElement(locator);
        element.click();
    }

    public static String getText(By locator) {
        if (isDisplayed(locator)) {
            WebElement element = findElement(locator);
            return element.getText();
        }
        LogsUtils.warn("Element not displayed: " + locator);
        return "";
    }

    public static String getAttribute(By locator, String attributeName) {
        if (isDisplayed(locator)) {
            WebElement element = findElement(locator);
            return element.getAttribute(attributeName);
        }
        LogsUtils.warn("Element not displayed: " + locator);
        return "";
    }

    public static boolean isDisplayed(By locator) {
        try {
            WebElement element = findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
