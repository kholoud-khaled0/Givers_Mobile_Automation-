package utils.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.appium.driverManager.DriverManager;
import utils.appium.Waits;

import java.time.Duration;
import java.util.List;

/**
 * Utility class for handling OTP input fields on Android.
 * Supports both traditional EditText OTP fields and non-editable ViewGroup boxes
 * (commonly used in Flutter or React Native apps).
 */
public class OtpHelper {

    /**
     * Enter OTP when the app uses non-editable ViewGroups as visual boxes
     * and a hidden input field for text entry.
     * Clicks the first visible OTP box to open the keyboard,
     * then types the full OTP into the actual input element.
     *
     * @param otp the OTP string (e.g. "123456")
     */
    public static void enterOtp(String otp) {
        try {
            // Step 1: انتظر أول ViewGroup يظهر (الـ OTP boxes)
            Waits.waitForElementToBeVisible(AppiumBy.className("android.view.ViewGroup"), Duration.ofSeconds(10));

            // Step 2: جيب كل الـ ViewGroups
            List<WebElement> boxes = DriverManager.getDriver()
                    .findElements(AppiumBy.className("android.view.ViewGroup"));

            if (boxes.isEmpty()) {
                throw new RuntimeException(" No OTP boxes found on screen!");
            }

            boxes.get(0).click();

            List<WebElement> inputs = DriverManager.getDriver()
                    .findElements(AppiumBy.className("android.widget.EditText"));

            if (!inputs.isEmpty()) {
                WebElement otpInput = inputs.get(0);
                otpInput.click();
                try { otpInput.clear(); } catch (Exception ignore) {}
                otpInput.sendKeys(otp);
            } else {
            DriverManager.getDriver().switchTo().activeElement().sendKeys(otp);
        }


        System.out.println("✅ OTP entered successfully: " + otp);

        } catch (Exception e) {
            throw new RuntimeException(" Failed to enter OTP: " + otp, e);
        }
    }

    /**
     * Legacy method for entering OTPs when each box is an actual input field.
     * This remains for backward compatibility with apps using EditText OTP boxes.
     *
     * @param otp          the OTP string
     * @param boxesLocator locator that finds all OTP boxes in visual order
     */
    public static void enterOtpByIndex(String otp, By boxesLocator) {
        List<WebElement> boxes = DriverManager.getDriver().findElements(boxesLocator);

        if (boxes == null || boxes.isEmpty()) {
            throw new RuntimeException(" No OTP boxes found with locator: " + boxesLocator);
        }

        int max = Math.min(boxes.size(), otp.length());
        for (int i = 0; i < max; i++) {
            WebElement box = boxes.get(i);
            try {
                box.click();
                try { box.clear(); } catch (Exception ignore) {}
                box.sendKeys(String.valueOf(otp.charAt(i)));

            } catch (Exception e) {
                try {
                    DriverManager.getDriver().switchTo().activeElement()
                            .sendKeys(String.valueOf(otp.charAt(i)));
                } catch (Exception ex) {
                    throw new RuntimeException(
                            " Failed to input OTP char '" + otp.charAt(i) + "' into box index " + i, ex);
                }
            }
        }

        System.out.println("✅ OTP entered by index successfully: " + otp);
    }

    // --- Locator helpers --- //

    /** Preferred locator when OTP boxes have a known resource-id */
    public static By recommendedLocatorByResourceId(String resourceId) {
        return AppiumBy.id(resourceId);
    }

    /** Fallback locator for generic ViewGroup-based OTP layouts */
    public static By fallbackByClassName() {
        return AppiumBy.className("android.view.ViewGroup");
    }

    /** Fallback locator to find boxes under a specific container by resource-id */
    public static By fallbackByXPathUnderContainer(String containerResourceId) {
        return AppiumBy.xpath("//android.view.ViewGroup[@resource-id='" + containerResourceId + "']//android.view.ViewGroup");
    }
}
