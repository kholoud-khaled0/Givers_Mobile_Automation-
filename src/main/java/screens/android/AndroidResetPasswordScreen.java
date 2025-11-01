package screens.android;

import io.qameta.allure.Step;
import screens.base.ResetPasswordScreen;
import utils.android.AndroidActions;
import utils.appium.ElementsActions;
import utils.appium.Waits;
import utils.common.assertions.AssertionManager;

import java.time.Duration;

/**
 * Android implementation of Reset Password Screen
 * Handles full password reset flow and validations
 */
public class AndroidResetPasswordScreen extends ResetPasswordScreen {

    // ------------------- Flow 1: Full Reset Password Flow ------------------- //
    @Override
    @Step("Perform full reset password flow (Main Scenario)")
    public void performResetPasswordFlow(String currentPassword, String newPassword) {

        tapMoreButton();
        tapChangeMyPasswordButton();

        setCurrentPassword(currentPassword);
        setNewPassword(newPassword);
        setConfirmPassword(newPassword);

        tapChangePasswordButton();

        Waits.waitForElementToBeVisible(passwordSuccessMessage, Duration.ofSeconds(10));
        boolean isSuccessVisible = isPasswordSuccessMessageDisplayed();
        AssertionManager.assertTrue(isSuccessVisible, "Password success message should be displayed.");
    }

    // ------------------- Flow 2: Logout Flow ------------------- //
    @Override
    @Step("Perform logout flow after password reset")
    public void performLogoutAfterReset() {
        AndroidActions.scrollToText("Logout");
        ElementsActions.click(logoutBtn);

        Waits.waitForElementToBeClickable(logoutConfirmBtn, Duration.ofSeconds(5));
        ElementsActions.click(logoutConfirmBtn);
    }

    // ------------------- Validation Helpers ------------------- //
    @Step("Verify password reset success message is displayed")
    public void verifyPasswordSuccessMessageVisible() {
        Waits.waitForElementToBeVisible(passwordSuccessMessage, Duration.ofSeconds(8));
        boolean isVisible = ElementsActions.isDisplayed(passwordSuccessMessage);
        AssertionManager.assertTrue(isVisible, "Expected 'Password updated successfully!' message to appear.");
    }

}
