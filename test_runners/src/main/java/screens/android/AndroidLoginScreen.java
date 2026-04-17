package screens.android;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import screens.base.LoginScreen;
import utils.appium.ElementsActions;
import utils.common.assertions.AssertionManager;

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
    @Step("Tap Login button")
    public AndroidLoginScreen tapLoginButton() {
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
}
