package utils.appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import utils.appium.driverManager.DriverManager;
import utils.common.LogsUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class providing common element-level actions for Appium.
 * Compatible with Appium Java Client 8+ (W3C Actions API).
 */
public class ElementsActions {

    // ----------------------- FIND ELEMENTS ----------------------- //

    public static List<WebElement> findElements(By... locators) {
        List<WebElement> allElements = new ArrayList<>();
        for (By locator : locators) {
            List<WebElement> elements = DriverManager.getDriver().findElements(locator);
            allElements.addAll(elements);
        }
        return allElements;
    }

    public static WebElement findElement(By locator) {
        Waits.waitForElementToBeVisible(locator);
        return DriverManager.getDriver().findElement(locator);
    }

    // ----------------------- BASIC ACTIONS ----------------------- //

    public static void setValue(By locator, String value) {
        if (value == null) {
            LogsUtils.warn("⚠️ Tried to send null value to element: " + locator);
            return;
        }
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
        LogsUtils.warn("⚠️ Element not displayed: " + locator);
        return "";
    }

    public static String getAttribute(By locator, String attributeName) {
        if (isDisplayed(locator)) {
            WebElement element = findElement(locator);
            return element.getAttribute(attributeName);
        }
        LogsUtils.warn("⚠️ Element not displayed: " + locator);
        return "";
    }

    // ----------------------- CLEAR FIELD ----------------------- //

    public static void clear(By locator) {
        try {
            WebElement element = findElement(locator);
            element.click(); // Ensure focus

            String currentValue = element.getText();
            if (currentValue != null && !currentValue.isEmpty()) {
                int length = currentValue.length();
                StringBuilder backspaces = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    backspaces.append("\u0008");
                }
                element.sendKeys(backspaces.toString());
            }

            if (!element.getText().isEmpty()) {
                element.clear();
            }

            LogsUtils.info("✅ Cleared field: " + locator);
        } catch (Exception e) {
            LogsUtils.warn("⚠️ Failed to clear field: " + locator + " | " + e.getMessage());
        }
    }

    public static boolean isDisplayed(By locator) {
        try {
            WebElement element = findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ----------------------- COLOR CHECK METHODS ----------------------- //

    public static int getCenterPixelColor(By locator) throws Exception {
        AppiumDriver driver = DriverManager.getDriver();
        WebElement el = driver.findElement(locator);
        org.openqa.selenium.Rectangle rect = el.getRect();

        byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
        BufferedImage fullImg = ImageIO.read(new ByteArrayInputStream(screenshot));

        int x = Math.max(0, rect.getX());
        int y = Math.max(0, rect.getY());
        int w = Math.min(rect.getWidth(), fullImg.getWidth() - x);
        int h = Math.min(rect.getHeight(), fullImg.getHeight() - y);

        if (w <= 0 || h <= 0) {
            throw new Exception("Invalid element bounds for color sampling");
        }

        BufferedImage elImg = fullImg.getSubimage(x, y, w, h);
        int cx = w / 2;
        int cy = h / 2;

        return elImg.getRGB(cx, cy);
    }

    public static boolean isElementColorApproximately(By locator, Color expected, int tolerance) {
        try {
            int argb = getCenterPixelColor(locator);
            Color actual = new Color(argb, true);

            int dr = Math.abs(actual.getRed() - expected.getRed());
            int dg = Math.abs(actual.getGreen() - expected.getGreen());
            int db = Math.abs(actual.getBlue() - expected.getBlue());

            boolean match = (dr + dg + db) <= tolerance;

            LogsUtils.info(String.format(
                    "🎨 Color check -> Actual RGB: (%d,%d,%d) | Expected: (%d,%d,%d) | Match: %s",
                    actual.getRed(), actual.getGreen(), actual.getBlue(),
                    expected.getRed(), expected.getGreen(), expected.getBlue(),
                    match
            ));

            return match;
        } catch (Exception e) {
            LogsUtils.warn("⚠️ Failed to get element color: " + e.getMessage());
            return false;
        }
    }

    // ----------------------- EXTRA UTILITIES ----------------------- //

    public static void clearAndSetValue(By locator, String value) {
        clear(locator);
        setValue(locator, value);
    }

    public static boolean isTextDisplayed(String text) {
        try {
            By textLocator = AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"" + text + "\")"
            );
            return isDisplayed(textLocator);
        } catch (Exception e) {
            return false;
        }
    }

    // ----------------------- ADVANCED GESTURES (W3C) ----------------------- //

    private static void performTap(int x, int y, Duration holdTime) {
        AppiumDriver driver = DriverManager.getDriver();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new org.openqa.selenium.interactions.Pause(finger, holdTime));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public static void doubleClick(By locator) {
        WebElement el = findElement(locator);
        org.openqa.selenium.Rectangle rect = el.getRect();
        int cx = rect.getX() + rect.getWidth() / 2;
        int cy = rect.getY() + rect.getHeight() / 2;
        performTap(cx, cy, Duration.ofMillis(50));
        Waits.waitFor(Duration.ofMillis(100));
        performTap(cx, cy, Duration.ofMillis(50));
        LogsUtils.info("✅ Double clicked element: " + locator);
    }

    public static void longPress(By locator) {
        WebElement el = findElement(locator);
        org.openqa.selenium.Rectangle rect = el.getRect();
        int cx = rect.getX() + rect.getWidth() / 2;
        int cy = rect.getY() + rect.getHeight() / 2;
        performTap(cx, cy, Duration.ofSeconds(1));
        LogsUtils.info("📌 Long press performed on element: " + locator);
    }

    // ----------------------- CLIPBOARD ----------------------- //

    public static String getClipboardText() {
        try {
            AppiumDriver driver = DriverManager.getDriver();
            String clipboardText = (String) ((JavascriptExecutor) driver)
                    .executeScript("mobile: getClipboard", new java.util.HashMap<>());
            LogsUtils.info("📋 Clipboard text: " + clipboardText);
            return clipboardText;
        } catch (Exception e) {
            LogsUtils.warn("⚠️ Failed to get clipboard text: " + e.getMessage());
            return "";
        }
    }

    public static void pasteValue(By locator) {
        String clipboardValue = getClipboardText();
        if (clipboardValue == null || clipboardValue.isEmpty()) {
            LogsUtils.warn("⚠️ Clipboard is empty, cannot paste.");
            return;
        }
        setValue(locator, clipboardValue);
        LogsUtils.info("📥 Pasted clipboard value into element: " + locator);
    }
}
