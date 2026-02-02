package utils.ios;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import utils.appium.driverManager.DriverManager;

import java.util.HashMap;
import java.util.Map;

public class IosActions {

    //https://appium.readthedocs.io/en/latest/en/writing-running-appium/ios/ios-xctest-mobile-gestures/

    public static void swipe(String direction, WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("element", ((RemoteWebElement) element).getId());
        DriverManager.getDriver().executeScript("mobile: swipe", params);
    }


    public static void scroll( WebElement element,String direction) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("element", ((RemoteWebElement) element).getId());
        DriverManager.getDriver().executeScript("mobile: scroll", params);
    }

    public static void scrollToElement(WebElement element,String predicateString, String direction) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("predicateString", predicateString);
        params.put("direction", direction);
        DriverManager.getDriver().executeScript("mobile: scroll", params);
    }




    public static void pinch( WebElement element, float scale, float velocity) {
        Map<String, Object> params = new HashMap<>();
        params.put("scale", scale);
        params.put("velocity", velocity);
        params.put("element", ((RemoteWebElement) element).getId());
        DriverManager.getDriver().executeScript("mobile: pinch", params);
    }


    public static void doubleTap(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        DriverManager.getDriver().executeScript("mobile: doubleTap", params);
    }

    public static void doubleTap(float x, float y) {
        Map<String, Object> params = new HashMap<>();
        params.put("x", x);
        params.put("y", y);
        DriverManager.getDriver().executeScript("mobile: doubleTap", params);
    }


    public static void touchAndHold(WebElement element, float duration) {
        Map<String, Object> params = new HashMap<>();
        params.put("duration", duration);
        params.put("element", ((RemoteWebElement) element).getId());
        DriverManager.getDriver().executeScript("mobile: touchAndHold", params);
    }

    public static void touchAndHold(float x, float y, float duration) {
        Map<String, Object> params = new HashMap<>();
        params.put("x", x);
        params.put("y", y);
        params.put("duration", duration);
        DriverManager.getDriver().executeScript("mobile: touchAndHold", params);
    }

    public static void twoFingerTap(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        DriverManager.getDriver().executeScript("mobile: twoFingerTap", params);
    }


    public static void dragFromToForDuration(WebElement element,float fromX, float fromY, float toX, float toY, float duration) {
        Map<String, Object> params = new HashMap<>();
        params.put("fromX", fromX);
        params.put("fromY", fromY);
        params.put("toX", toX);
        params.put("toY", toY);
        params.put("duration", duration);
        params.put("element", ((RemoteWebElement) element).getId());
        DriverManager.getDriver().executeScript("mobile: dragFromToForDuration", params);
    }

    public static void alert(String action, String buttonLabel) {
        Map<String, Object> params = new HashMap<>();
        params.put("action", action);
        params.put("buttonLabel", buttonLabel);
        DriverManager.getDriver().executeScript("mobile: alert", params);
    }

    public static void setValue(WebElement element, String value) {
        String inputValue = element.getText();
        if (inputValue != null ) {
            for(int i = 0; i < inputValue.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE); 
            }
    }
      element.sendKeys(value);
      }
}
