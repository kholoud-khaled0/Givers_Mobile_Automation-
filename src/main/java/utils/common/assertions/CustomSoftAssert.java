package utils.common.assertions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import utils.appium.driverManager.DriverManager;
import utils.common.AllureUtils;
import utils.common.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.io.File;
import java.lang.reflect.Method;

import static utils.appium.TakeScreenShot.takeScreenShot;


public class CustomSoftAssert extends SoftAssert {
    public CustomSoftAssert() {
        super();
    }

    public void customAssertAll(ITestResult result) {
        try {
            super.assertAll("Custom Soft Assertion");
        } catch (AssertionError e) {
            LogsUtils.error("Custom Soft Assertion Failed: " + e.getMessage());
            result.setStatus(ITestResult.FAILURE);
            result.setThrowable(e);}
    }


    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        super.onAssertFailure(assertCommand, ex);
        Method testMethod = Reporter.getCurrentTestResult().getMethod().getConstructorOrMethod().getMethod();
        String testName = testMethod.getName();
        File screenshot = takeScreenShot(testName + "_Failed");
        LogsUtils.error("Assertion Failed: " + ex.getMessage());
        if (screenshot != null) {
            AllureUtils.attachPng(screenshot);
        }
    }



    @Override
    @Deprecated
    public void assertAll() {
        throw new UnsupportedOperationException(
                "Direct assertAll() is disabled; use customAssertAll() instead."
        );
    }

    @Override
    @Deprecated
    public void assertAll(String message) {
        throw new UnsupportedOperationException(
                "Direct assertAll(String) is disabled; use customAssertAll() instead."
        );
    }
    @Step("Assert element is displayed")
    public static void assertElementDisplayed(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        Assert.assertTrue(
                element.isDisplayed(),
                "Expected element to be displayed but it was not"
        );
    }

    @Step("Assert element is NOT displayed")
    public static void assertElementNotDisplayed(By locator) {
        try {
            WebElement element = DriverManager.getDriver().findElement(locator);
            Assert.assertFalse(
                    element.isDisplayed(),
                    "Expected element NOT to be displayed but it was"
            );
        } catch (Exception e) {
            // Element not found → pass
            Assert.assertTrue(true);
        }
    }

    /* ================= Enabled / Disabled ================= */

    @Step("Assert element is enabled")
    public static void assertElementEnabled(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        Assert.assertTrue(
                element.isEnabled(),
                "Expected element to be enabled but it was disabled"
        );
    }

    @Step("Assert element is disabled")
    public static void assertElementDisabled(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        Assert.assertFalse(
                element.isEnabled(),
                "Expected element to be disabled but it was enabled"
        );
    }

    /* ================= Text ================= */

    @Step("Assert element text equals expected text")
    public static void assertElementTextEquals(By locator, String expectedText) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        Assert.assertEquals(
                element.getText(),
                expectedText,
                "Element text does not match expected text"
        );
    }

    @Step("Assert element text contains expected text")
    public static void assertElementTextContains(By locator, String expectedText) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        Assert.assertTrue(
                element.getText().contains(expectedText),
                "Element text does not contain expected text"
        );
    }

    /* ================= Clickable ================= */

    @Step("Assert element is clickable")
    public static void assertElementClickable(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        Assert.assertTrue(
                element.isDisplayed() && element.isEnabled(),
                "Expected element to be clickable but it was not"
        );
    }
}
