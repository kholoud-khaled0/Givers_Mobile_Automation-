package utils.android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import utils.appium.driverManager.DriverManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class AndroidActions {


    public static void dragGesture(WebElement element, int endX, int endY) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("endX", endX);
        params.put("endY", endY);
        DriverManager.getDriver().executeScript("mobile: dragGesture", params);
    }

    public static void dragGesture(int startX, int startY, int endX, int endY) {
        Map<String, Object> params = new HashMap<>();
        params.put("startX", startX);
        params.put("startY", startY);
        params.put("endX", endX);
        params.put("endY", endY);
        DriverManager.getDriver().executeScript("mobile: dragGesture", params);
    }

    public static void flingGesture(WebElement element, String direction) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("direction", direction);
        DriverManager.getDriver().executeScript("mobile: flingGesture", params);
    }

    public static void doubleClickGesture(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        DriverManager.getDriver().executeScript("mobile: doubleClickGesture", params);
    }

    public static void doubleClickGesture(int x, int y) {
        Map<String, Object> params = new HashMap<>();
        params.put("x", x);
        params.put("y", y);
        DriverManager.getDriver().executeScript("mobile: doubleClickGesture", params);
    }

    public static void longClickGesture(WebElement element) {
        longClickGesture(element, 500);
    }

    public static void longClickGesture(int x, int y) {
        longClickGesture(x, y, 500);
    }

    public static void longClickGesture(int x, int y, int durationMs) {
        Map<String, Object> params = new HashMap<>();
        params.put("x", x);
        params.put("y", y);
        params.put("duration", durationMs);
        DriverManager.getDriver().executeScript("mobile: longClickGesture", params);
    }

    public static void longClickGesture(WebElement element, int durationMs) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("duration", durationMs);
        DriverManager.getDriver().executeScript("mobile: longClickGesture", params);
    }

    public static void pinchCloseGesture(WebElement element, double percent) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("percent", percent);
        DriverManager.getDriver().executeScript("mobile: pinchCloseGesture", params);
    }

    public static void pinchCloseGesture(int left, int top, int width, int height, double percent) {
        Map<String, Object> params = new HashMap<>();
        params.put("left", left);
        params.put("top", top);
        params.put("width", width);
        params.put("height", height);
        params.put("percent", percent);
        DriverManager.getDriver().executeScript("mobile: pinchCloseGesture", params);
    }

    public static void pinchOpenGesture(WebElement element, double percent) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("percent", percent);
        DriverManager.getDriver().executeScript("mobile: pinchOpenGesture", params);
    }

    public static void pinchOpenGesture(int left, int top, int width, int height, double percent) {
        Map<String, Object> params = new HashMap<>();
        params.put("left", left);
        params.put("top", top);
        params.put("width", width);
        params.put("height", height);
        params.put("percent", percent);
        DriverManager.getDriver().executeScript("mobile: pinchOpenGesture", params);
    }

    public static void swipeGesture(WebElement element, String direction, double percent) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("direction", direction);
        params.put("percent", percent);
        DriverManager.getDriver().executeScript("mobile: swipeGesture", params);
    }

    public static void swipeGesture(int left, int top, int width, int height, String direction, double percent) {
        Map<String, Object> params = new HashMap<>();
        params.put("left", left);
        params.put("top", top);
        params.put("width", width);
        params.put("height", height);
        params.put("direction", direction);
        params.put("percent", percent);
        DriverManager.getDriver().executeScript("mobile: swipeGesture", params);
    }

    public static void scrollGesture(WebElement element, String direction, int percent) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("direction", direction);
        params.put("percent", percent);
        DriverManager.getDriver().executeScript("mobile: scrollGesture", params);
    }

    public static void scrollGesture(int left, int top, int width, int height, String direction, int percent) {
        Map<String, Object> params = new HashMap<>();
        params.put("left", left);
        params.put("top", top);
        params.put("width", width);
        params.put("height", height);
        params.put("direction", direction);
        params.put("percent", percent);
        DriverManager.getDriver().executeScript("mobile: scrollGesture", params);
    }

    public static void scrollToElement(String UiSelector) {
        Map<String, Object> params = new HashMap<>();
        params.put("strategy", "-android uiautomator");
        params.put("selector", UiSelector);
        DriverManager.getDriver().executeScript("mobile: scroll", params);
    }

    public static boolean isElementDisplayed(By locator) {
        try {
            WebDriver driver = DriverManager.getDriver();
            List<WebElement> elements = driver.findElements(locator);
            if (elements == null || elements.isEmpty()) {
                return false;
            }
            return elements.get(0).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void scrollToText(String text) {
        try {
            DriverManager.getDriver().findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"" + text + "\")"
            ));
            System.out.println("Scrolled to text: " + text);
        } catch (Exception e) {
            System.out.println("Scroll to text failed or already visible: " + text);
        }
    }

    public static boolean isElementDisplayed(By locator, int waitSeconds) {
        try {
            WebDriver driver = DriverManager.getDriver();
            for (int i = 0; i < waitSeconds; i++) {
                List<WebElement> elements = driver.findElements(locator);
                if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                    return true;
                }
                Thread.sleep(1000); // wait 1 second before retry
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    // ------------------- New scrollToElement for By locator -------------------
    public static void scrollToElement(By locator) {
        try {
            String uiSelector;
            // handle accessibilityId
            if (locator instanceof AppiumBy) {
                uiSelector = "new UiSelector().description(\"" + locator.toString().replace("By.accessibilityId: ", "") + "\")";
            } else {
                // fallback to text
                uiSelector = "new UiSelector().text(\"" + locator.toString().replace("By.selector: ", "") + "\")";
            }

            Map<String, Object> params = new HashMap<>();
            params.put("strategy", "-android uiautomator");
            params.put("selector", uiSelector);

            DriverManager.getDriver().executeScript("mobile: scroll", params);
            System.out.println("[INFO] Scrolled to element: " + locator);

        } catch (Exception e) {
            System.out.println("[WARN] Scroll to element failed: " + locator + " | " + e.getMessage());
        }
    }
}
