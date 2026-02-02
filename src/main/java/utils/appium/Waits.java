package utils.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.appium.driverManager.DriverManager;

import java.time.Duration;

import static utils.appium.driverManager.DriverManager.getDriver;

public class Waits {


    public static void waitForElementToBeVisible(By locator, Duration duration) {
        WebDriverWait wait = new WebDriverWait(getDriver(), duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(By locator, Duration duration) {
        WebDriverWait wait = new WebDriverWait(getDriver(), duration);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementToBeInvisible(By locator, Duration duration) {
        WebDriverWait wait = new WebDriverWait(getDriver(), duration);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waiForElessmentToBeStale(WebElement element, Duration duration) {
        WebDriverWait wait = new WebDriverWait(getDriver(), duration);
        wait.until(ExpectedConditions.stalenessOf(element));
    }


    public static void waitForElementToBeVisible(By locator) {
        waitForElementToBeVisible(locator, Duration.ofSeconds(Long.parseLong(System.getProperty("DefaultWaitTime", "120"))));
    }
    public static void waitForElementToBeClickable(By locator) {
        waitForElementToBeClickable(locator, Duration.ofSeconds(Long.parseLong(System.getProperty("DefaultWaitTime", "120"))));
    }
    public static void waitForElementToBeInvisible(By locator) {
        waitForElementToBeInvisible(locator, Duration.ofSeconds(Long.parseLong(System.getProperty("DefaultWaitTime", "120"))));
    }


    public static void waitForScrollToStop( By Locator, Duration timeout) {
    final Point[] prevLocation = {null};

    new FluentWait<>(getDriver())
        .withTimeout(timeout)
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(Exception.class)
        .until(d -> {
            try {
                WebElement element = ElementsActions.findElement(Locator);
                Point currentLocation = element.getLocation();

                if (prevLocation[0] != null && prevLocation[0].equals(currentLocation)) {
                    return true;
                }
                prevLocation[0] = currentLocation;
                return false;

            } catch (Exception e) {
                return false;
            }
        });
    }
    public static void waitForTextToBeVisible(String text, Duration duration) {
        By textLocator = By.xpath("//*[contains(@text, '" + text + "') or contains(@content-desc, '" + text + "')]");
        WebDriverWait wait = new WebDriverWait(getDriver(), duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
    }
    public static void waitFor(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted during static wait", e);
        }
    }
    // ✅ Add inside Waits class (before the last closing bracket)
    /**
     * Wait until exact text is visible on screen.
     */
    public static void waitForExactText(String text, Duration duration) {
        By locator = By.xpath("//*[normalize-space(@text)='" + text + "']");
        WebDriverWait wait = new WebDriverWait(getDriver(), duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void smallWait() {
        try { Thread.sleep(5000); } catch (Exception e) {}

    }
    public static void waitForUIStability() {
        try {
            long height1 = getDriver().manage().window().getSize().getHeight();
            Thread.sleep(800);
            long height2 = getDriver().manage().window().getSize().getHeight();

            int tries = 0;
            while (height1 != height2 && tries < 5) {
                Thread.sleep(300);
                height1 = height2;
                height2 = getDriver().manage().window().getSize().getHeight();
                tries++;
            }

        } catch (Exception ignored) {}
    }

    /**
     * Wait until element containing specific content-desc or text disappears.
     */
    public static void waitForTextToDisappear(String text, Duration duration) {
        By textLocator = By.xpath("//*[contains(@text, '" + text + "') or contains(@content-desc, '" + text + "')]");
        WebDriverWait wait = new WebDriverWait(getDriver(), duration);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(textLocator));
    }
    public static boolean waitForTextToBeVisiblee(String text, Duration duration) {
        By textLocator = By.xpath("//*[contains(@text, '" + text + "') or contains(@content-desc, '" + text + "')]");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), duration);
            wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
            return true; // ✅ النص ظهر فعلاً
        } catch (Exception e) {
            return false; // ⛔ انتهى الوقت أو النص مش موجود
        }
    }
    public static void waitForCameraDialogToDisappear() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("camera_dialog_root")));
    }

    public static void waitForElementToBePresent(By locator) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));

        wait.until(driver ->
                !driver.findElements(locator).isEmpty()
        );
    }
    public static void waitForElementToDisappear(By locator, int timeoutInSeconds) {
        WebDriverWait wait =
                new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


}
