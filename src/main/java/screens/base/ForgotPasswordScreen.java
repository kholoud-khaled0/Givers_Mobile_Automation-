package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.appium.ElementsActions;
import utils.android.OtpHelper;

/**
 * Base class for Forgot Password functionality
 * Defines shared locators and actions across platforms
 */
public abstract class ForgotPasswordScreen {

    // ------------------- Locators ------------------- //
    protected static final By forgotPasswordBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Forgot password?\")");

    protected static final By emailField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter your email\")");

    protected static final By sendCodeBtn =
            AppiumBy.accessibilityId("Send code");

    protected static final By otpInputFields =
            AppiumBy.className("android.widget.EditText");

    protected static final By newPasswordField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter new password\")");

    protected static final By confirmPasswordField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Repeat new password\")");

    protected static final By resetPasswordBtn =
            AppiumBy.accessibilityId("Reset password");

    protected static final By passwordSuccessChangeMessage =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Password changed successfully\")");

    protected static final By backToLoginBtn =
            AppiumBy.accessibilityId("Back To Login");

    protected static final By welcomeBackTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Welcome Back!\")");

    protected static final By skipBtn =
            AppiumBy.accessibilityId("Skip");

    protected static final By signInBtn =
            AppiumBy.accessibilityId("Sign In");
      protected static final By moreBtn = AppiumBy.accessibilityId("\uE821, More");
    protected static final By signUpBtn = AppiumBy.accessibilityId("Sign up");


    // ------------------- Common Actions ------------------- //

    @Step("Tap 'Skip' button")
    public void tapSkipButton() {
        ElementsActions.click(skipBtn);
    }

    @Step("Tap 'Sign In' button")
    public void tapSignInButton() {
        ElementsActions.click(signInBtn);
    }

    @Step("Tap 'Forgot Password?' link")
    public void tapForgotPasswordButton() {
        ElementsActions.click(forgotPasswordBtn);
    }

    @Step("Enter email: {email}")
    public void setEmail(String email) {
        ElementsActions.setValue(emailField, email);
    }

    @Step("Tap 'Send Code' button")
    public void tapSendCodeButton() {
        ElementsActions.click(sendCodeBtn);
    }

    @Step("Enter OTP: {otp}")
    public void enterOtp(String otp) {
        OtpHelper.enterOtp(otp);
    }

    @Step("Enter new password: {password}")
    public void setNewPassword(String password) {
        ElementsActions.setValue(newPasswordField, password);
    }

    @Step("Enter confirm password: {confirmPassword}")
    public void setConfirmPassword(String confirmPassword) {
        ElementsActions.setValue(confirmPasswordField, confirmPassword);
    }

    @Step("Tap 'Reset Password' button")
    public void tapResetPasswordButton() {
        ElementsActions.click(resetPasswordBtn);
    }

    @Step("Verify 'Password changed successfully' message is displayed")
    public boolean isPasswordSuccessMessageDisplayed() {
        return ElementsActions.isDisplayed(passwordSuccessChangeMessage);
    }

    @Step("Tap 'Back To Login' button")
    public void tapBackToLoginButton() {
        ElementsActions.click(backToLoginBtn);
    }

    @Step("Check if 'Welcome Back' title is visible")
    public boolean isWelcomeBackVisible() {
        return ElementsActions.isDisplayed(welcomeBackTitle);
    }

    // ------------------- Abstract Method ------------------- //
    @Step("Perform login after password reset")
    public abstract void performLoginAfterReset(String email, String password);
}
