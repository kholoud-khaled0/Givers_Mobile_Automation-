package screens.base;

import io.qameta.allure.Step;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import screens.android.AndroidLoginScreen;
import utils.appium.ElementsActions;

/**
 * Base class for Login Screen functionality
 */
public abstract class LoginScreen {

    // ------------------- Locators -------------------
    protected static final By emailField = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Please enter your email\")"
    );
    protected static final By passwordField = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Please enter your password\")"
    );
    protected static final By loginBtn = AppiumBy.accessibilityId("Login button");
    protected static final By signInBtn = AppiumBy.accessibilityId("Sign In");
    protected static final By SkipBtn = AppiumBy.accessibilityId("Skip");
    protected static final By permeationNotification = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
    protected static final By permeationGPS = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")");


    // ------------------- Actions -------------------

    @Step("Set email: {email}")
    public void setEmail(String email) {
        ElementsActions.setValue(emailField, email);
    }

    @Step("Set password: {password}")
    public void setPassword(String password) {
        ElementsActions.setValue(passwordField, password);
    }

    @Step("Tap Sign In button")
    public void tapSignInButton() {
        ElementsActions.click(SkipBtn);
        ElementsActions.click(signInBtn);
    }
    @Step("Tap Sign In button")
    public void tapSignInWithoutSkipButton() {
        ElementsActions.click(signInBtn);
    }

    @Step("Check if in Login Screen")
    public boolean isInLoginScreen() {
        return ElementsActions.isDisplayed(emailField)
                && ElementsActions.isDisplayed(passwordField)
                && ElementsActions.isDisplayed(loginBtn);
    }

    // ------------------- Abstract Methods -------------------

    @Step("Tap Login button")
    public abstract Object tapLoginButton(); // Object will be HomeScreen in implementation

    @Step("Tap Login button second")
    public abstract AndroidLoginScreen tapLoginButtonSecond();

    @Step("Get error message")
    public abstract String getErrorMessage();

}