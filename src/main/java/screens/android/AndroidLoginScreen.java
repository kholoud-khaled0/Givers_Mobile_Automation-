package screens.android;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import screens.base.LoginScreen;
import utils.appium.ElementsActions;
import utils.appium.Waits;

import java.time.Duration;

/**
 * Android implementation of Login Screen
 * Handles both successful and failed login scenarios
 */
public class AndroidLoginScreen extends LoginScreen {

    // ------------------- Locators -------------------
    protected static final By homeTitle = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Givers\")"
    );
    protected static final By toastLocator = AppiumBy.xpath("//android.widget.Toast[1]");

    // ------------------- Actions -------------------

    @Override
    @Step("Tap Login button and Permeation's")
    public AndroidLoginScreen tapLoginButton() {
        ElementsActions.click(loginBtn);
        Waits.waitForElementToBeVisible(permeationNotification, Duration.ofSeconds(30));
        ElementsActions.click(permeationNotification);

        Waits.waitForElementToBeVisible(permeationGPS, Duration.ofSeconds(30));
        ElementsActions.click(permeationGPS);
        return this; // Return same screen for chaining
    }

    @Step("Tap Login button second")
    @Override
    public AndroidLoginScreen tapLoginButtonSecond() {
        ElementsActions.click(loginBtn);
        return this; // Return same screen for chaining
    }

    @Override
    @Step("Get error message from Toast")
    public String getErrorMessage() {
        try {
            Thread.sleep(1000); // short wait for Toast to appear
            return ElementsActions.getText(toastLocator);
        } catch (NoSuchElementException e) {
            return "No toast message found";
        } catch (Exception e) {
            return "Error reading toast message: " + e.getMessage();
        }
    }

    @Step("Check if error toast is visible")
    public boolean isErrorToastVisible() {
        try {
            Thread.sleep(1000); // short wait for toast
            return ElementsActions.isDisplayed(toastLocator);
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Check if Home Page is visible")
    public boolean isHomeVisible() {
        return ElementsActions.isDisplayed(homeTitle);
    }

    // ------------------- Helper Method -------------------

    @Step("Perform full login with email: {email} and password: {password}")
    public AndroidLoginScreen login(String email, String password) {
        tapSignInButton();
        setEmail(email);
        setPassword(password);
        tapLoginButton();
        return this;
    }
    @Step("Perform full login with email: {email} and password: {password}")
    public AndroidLoginScreen loginWithSkip(String email, String password) {
        tapSignInButton();
        setEmail(email);
        setPassword(password);
        tapLoginButton();
        return this;
    }

    @Step("Perform full login with email: {email} and password: {password}")
    public AndroidLoginScreen SignInWithoutSkipButton(String email, String password) {
        tapSignInWithoutSkipButton();
        setEmail(email);
        setPassword(password);
        tapLoginButtonSecond();
        return this;
    }
}
