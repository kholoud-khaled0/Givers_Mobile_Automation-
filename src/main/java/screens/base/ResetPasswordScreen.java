package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.android.AndroidActions;
import utils.appium.ElementsActions;

/**
 * Base class for Reset Password Screen functionality
 */
public abstract class ResetPasswordScreen {

    // ------------------- Locators ------------------- //

    protected static final By moreBtn =
            AppiumBy.accessibilityId("\uE821, More");

    protected static final By changeMyPasswordBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"Change My Password\")");


    protected static final By currentPasswordField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter your current password\")");

    protected static final By newPasswordField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Must be at least 8 characters\")");

    protected static final By confirmPasswordField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Must be identical to new password\")");

    protected static final By changePasswordBtn =
            AppiumBy.accessibilityId("Change Password");

    protected static final By passwordSuccessMessage =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Password updated successfully!\")");

    protected static final By logoutBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"Logout\")");

    protected static final By logoutConfirmBtn =
            AppiumBy.accessibilityId("Confirm button");

    // ------------------- Common Actions ------------------- //

    @Step("Tap 'More' button")
    public void tapMoreButton() {
        ElementsActions.click(moreBtn);
    }

    @Step("Tap 'Change My Password' button")
    public void tapChangeMyPasswordButton() {
        ElementsActions.click(changeMyPasswordBtn);
    }

    @Step("Enter current password: {password}")
    public void setCurrentPassword(String password) {
        ElementsActions.setValue(currentPasswordField, password);
    }

    @Step("Enter new password: {newPassword}")
    public void setNewPassword(String newPassword) {
        ElementsActions.setValue(newPasswordField, newPassword);
    }

    @Step("Enter confirm password: {confirmPassword}")
    public void setConfirmPassword(String confirmPassword) {
        ElementsActions.setValue(confirmPasswordField, confirmPassword);
    }

    @Step("Tap 'Change Password' button")
    public void tapChangePasswordButton() {
        ElementsActions.click(changePasswordBtn);
    }

    @Step("Check if success message 'Password updated successfully!' is displayed")
    public boolean isPasswordSuccessMessageDisplayed() {
        return ElementsActions.isDisplayed(passwordSuccessMessage);
    }

    @Step("Scroll to 'Logout' and tap it")
    public void scrollToLogoutAndTap() {
        AndroidActions.scrollToText("Logout");
        ElementsActions.click(logoutBtn);
    }

    @Step("Tap 'Confirm Logout' button")
    public void tapConfirmLogoutButton() {
        ElementsActions.click(logoutConfirmBtn);
    }


    // ------------------- Abstract Flow Methods ------------------- //

    /**
     * Perform the full password reset flow:
     * - Open more menu
     * - Go to Change My Password
     * - Enter current/new/confirm passwords
     * - Confirm password change
     */
    @Step("Perform full reset password flow")
    public abstract void performResetPasswordFlow(String currentPassword, String newPassword);

    /**
     * Perform logout flow after password reset
     */
    @Step("Perform logout flow after password reset")
    public abstract void performLogoutAfterReset();
}
