package utils.appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import utils.appium.driverManager.DriverManager;
import utils.common.LogsUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static utils.appium.driverManager.DriverManager.getDriver;
import static utils.ios.IosActions.swipe;


/**
 * Utility class providing common element-level actions for Appium.
 * Compatible with Appium Java Client 8+ (W3C Actions API).
 */
public class ElementsActions {

    // ----------------------- FIND ELEMENTS ----------------------- //

    public static List<WebElement> findElements(By... locators) {
        List<WebElement> allElements = new ArrayList<>();
        for (By locator : locators) {
            List<WebElement> elements = getDriver().findElements(locator);
            allElements.addAll(elements);
        }
        return allElements;
    }

    public static WebElement findElement(By locator) {
        Waits.waitForElementToBeVisible(locator);
        return getDriver().findElement(locator);
    }

    // ----------------------- BASIC ACTIONS ----------------------- //

    public static void setValue(By locator, String value) {
        if (value == null) {
            LogsUtils.warn("⚠️ Tried to send null value to element: " + locator);
            return;
        }
        WebElement element = findElement(locator);
//        element.clear();
        element.sendKeys(value);
    }

    /**
     * Send keys to a field safely.
     * Focuses, clears, and sends text. Optionally resends the last character if length >= 4.
     */
    @Step("Send keys '{text}' to element {locator}")
    public static void sendKeys(By locator, String text) {
        if (text == null) {
            LogsUtils.warn("⚠️ Tried to send null text to element: " + locator);
            return;
        }

        try {
            WebElement element = findElement(locator);
            element.click();           // Focus on the element


            element.sendKeys(text);    // Send full text

            // For long inputs (>=4 chars), resend last char to ensure entry
            if (text.length() >= 4) {
                char lastChar = text.charAt(text.length() - 1);
                element.sendKeys(String.valueOf(lastChar));
            }

            LogsUtils.info("✅ Sent text '" + text + "' to element: " + locator);
        } catch (Exception e) {
            LogsUtils.warn("⚠️ Failed to send keys to element: " + locator + " | " + e.getMessage());
        }
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

    public static void scrollDownProperly() {
        try {
            AndroidDriver driver = (AndroidDriver) getDriver();

            String command = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()";
            driver.findElement(AppiumBy.androidUIAutomator(command));
        } catch (Exception e) {
            System.out.println("Scroll failed: " + e.getMessage());
        }
    }

    @Step("Scroll until element is visible: {locator}")
    public static boolean scrollUntilElementVisible(By locator, int maxScrolls) {
        AppiumDriver driver = getDriver();

        for (int i = 0; i < maxScrolls; i++) {
            if (isDisplayed(locator)) {
                LogsUtils.info("✅ Element found after scrolling: " + locator);
                return true;
            }

            // scroll down small
            org.openqa.selenium.Dimension size = driver.manage().window().getSize();
            int startX = size.width / 2;
            int startY = (int) (size.height * 0.75);
            int endY   = (int) (size.height * 0.35);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO,
                    PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(100)));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(400),
                    PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(swipe));
            Waits.waitFor(Duration.ofMillis(300));
        }

        LogsUtils.warn("⚠️ Element not found after scrolling: " + locator);
        return false;
    }
    public static boolean isElementDisplayed(By locator) {
        try {
            return DriverManager.getDriver()
                    .findElement(locator)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void scrollDownSmall() {
        AppiumDriver driver = getDriver();
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.70);  // بداية أعلى قليلًا
        int endY   = (int) (size.height * 0.55);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(150)));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(300),
                PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

    // ----------------------- CLEAR FIELD ----------------------- //

    public static void clear(By locator) {
        try {
            WebElement element = findElement(locator);
            element.click(); // focus on field

            // جرب اولاً sendKeys CTRL+A + DELETE (آمنة على معظم Android)
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.DELETE);

            // fallback لو لسه فيه نص
            if (!element.getText().isEmpty()) {
                element.clear();
            }

            LogsUtils.info("✅ Cleared field successfully: " + locator);
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
        AppiumDriver driver = getDriver();
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
        AppiumDriver driver = getDriver();
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
            AppiumDriver driver = getDriver();
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
    public static void scrollUpSmall() {
        try {
            By scrollable = AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollBackward()"
            );

            findElement(scrollable);
        } catch (Exception ignored) {
        }
    }

    public static void scrollToElement(By locator) {
        try {
            AppiumDriver driver = getDriver();

            String locatorText = locator.toString();
            String scrollCommand = "";

            if (locatorText.contains("text(")) {
                // For UiSelector with text
                String textValue = locatorText.substring(locatorText.indexOf("text(") + 5, locatorText.lastIndexOf(")")).replace("\"", "");
                scrollCommand =
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + textValue + "\"));";
            } else if (locatorText.contains("textContains(")) {
                // For UiSelector with textContains
                String textValue = locatorText.substring(locatorText.indexOf("textContains(") + 13, locatorText.lastIndexOf(")")).replace("\"", "");
                scrollCommand =
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + textValue + "\"));";
            } else {
                // Generic fallback using description
                scrollCommand =
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                                locatorText.replace("By.selector: ", "") + ");";
            }

            driver.findElement(AppiumBy.androidUIAutomator(scrollCommand));
            LogsUtils.info("✅ Scrolled to element: " + locator);
        } catch (Exception e) {
            LogsUtils.warn("⚠️ Failed to scroll to element: " + locator + " | " + e.getMessage());
        }
    }
    @Step("Scroll to bottom of the page")
    public static void scrollToBottom() {
        try {
            AppiumDriver driverInstance = getDriver();
            String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)";
            driverInstance.findElement(AppiumBy.androidUIAutomator(scrollCommand));
            LogsUtils.info("✅ Scrolled to the bottom of the page successfully.");
        } catch (Exception e) {
            LogsUtils.warn("⚠️ Could not scroll to bottom: " + e.getMessage());
        }
    }
    @Step("Scroll to bottom of the page with minimal checks")
    public static void scrollToBottom2() {
        AppiumDriver driver = getDriver();

        try {
            org.openqa.selenium.Dimension size = driver.manage().window().getSize();
            int width = size.width;
            int height = size.height;

            int startX = width / 2;
            int startY = (int) (height * 0.8);
            int endY = (int) (height * 0.2);

            // Swipe أول مرة
            performSwipe(startX, startY, startX, endY, 700);
            Thread.sleep(300);

            if (!isAtBottom()) {
                performSwipe(startX, startY, startX, endY, 700);
                Thread.sleep(300);
            }

            LogsUtils.info("✅ Scrolled to the bottom of the page (1-2 swipes).");
        } catch (Exception e) {
            LogsUtils.warn("⚠️ Could not scroll to bottom: " + e.getMessage());
        }
    }

    /** Swipe helper method */
    private static void performSwipe(int startX, int startY, int endX, int endY, int durationMs) {
        AppiumDriver driver = getDriver();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(50)));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMs), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

    private static boolean isAtBottom() {
        By bottomElement = AppiumBy.androidUIAutomator("new UiSelector().text(\"Submit\")");
        return ElementsActions.isDisplayed(bottomElement);
    }
    @Step("Scroll down once")
    public static void scrollDownOnce() {
        try {
            AppiumDriver driver = getDriver();
            org.openqa.selenium.Dimension size = driver.manage().window().getSize();
            int width = size.width;
            int height = size.height;

            int startX = width / 2;
            int startY = (int) (height * 0.7);
            int endY = (int) (height * 0.5);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(50)));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(swipe));

            LogsUtils.info("✅ Scrolled down once after document upload.");
        } catch (Exception e) {
            LogsUtils.warn("⚠️ Failed to scroll down: " + e.getMessage());
        }
    }


}
