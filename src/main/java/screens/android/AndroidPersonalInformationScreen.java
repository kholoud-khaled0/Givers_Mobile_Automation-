package screens.android;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.PersonalInformationScreen;
import utils.android.OtpHelper;
import utils.appium.ElementsActions;
import utils.appium.Waits;
import utils.common.assertions.AssertionManager;

import java.time.Duration;

/**
 * Android implementation of Personal Information flows
 */
public class AndroidPersonalInformationScreen extends PersonalInformationScreen {

    // ---------------- Scenario 1 ---------------- //
    @Override
    @Step("Perform Scenario 1: Edit info and remove photo")
    public void performEditInfoScenario(String firstName, String lastName) {
        tapMoreButton();
        openPersonalInformation();
        tapEditButton();
        removePhoto();
        updateFirstName(firstName);
        updateLastName(lastName);
        tapSaveButton();

        Waits.waitForElementToBeVisible(profileSuccessMsg, Duration.ofSeconds(8));
        boolean success = isProfileUpdateSuccessVisible();
        AssertionManager.assertTrue(success, "Profile should be updated successfully");
    }

    // ---------------- Scenario 2 ---------------- //
    @Override
    @Step("Perform Scenario 2: Upload photo and change email with OTP")
    public void performChangeEmailScenario(String newEmail, String oldEmail, String otp) {
        tapMoreButton();
        openPersonalInformation();
        tapEditButton();

        // Step 1: Upload new photo
        uploadProfilePhoto();

        // Step 2: Change to new email
        tapChangeMyEmailButton();
        enterEmail(newEmail);
        tapSendCodeButton();

        // Step 3: Enter OTP using helper
        OtpHelper.enterOtp(otp);

        Waits.waitForTextToBeVisible(newEmail, Duration.ofSeconds(10));
        boolean emailUpdated = ElementsActions.isTextDisplayed(newEmail);
        AssertionManager.assertTrue(emailUpdated, "New email should appear after verification.");

        // Step 4: Revert to old email
        tapChangeMyEmailButton();
        enterEmail(oldEmail);
        tapSendCodeButton();
        OtpHelper.enterOtp(otp);

        Waits.waitForTextToBeVisible(oldEmail, Duration.ofSeconds(10));
        boolean emailReverted = ElementsActions.isTextDisplayed(oldEmail);
        AssertionManager.assertTrue(emailReverted, "Email should revert successfully to old value.");
    }

    // ---------------- Scenario 3 ---------------- //
    @Step("Perform Scenario 3: Delete My Account flow")
    public void performDeleteAccountScenario() {
        tapMoreButton();

        // Step 1: double-tap on the profile identifier and extract ID
        String userId = doubleTapProfileIdentifier();

        // Step 2: open Personal Information screen
        openPersonalInformation();

        // Step 3: click Delete My Account
        tapDeleteMyAccountButton();

        // Step 4: paste the ID and confirm deletion
        pasteUserIdAndDelete(userId);

        // Step 5: confirm again by tapping Delete My Account (كما طلبت)
        tapDeleteMyAccountButton();
    }

    // ---------------- Helper Methods ---------------- //
    @Step("Upload profile photo via camera flow")
    private void uploadProfilePhoto() {
        tapProfileImageIcon();

        if (ElementsActions.isDisplayed(launchCameraBtn)) {
            ElementsActions.click(launchCameraBtn);
        }

        if (ElementsActions.isDisplayed(permissionAllowBtn)) {
            ElementsActions.click(permissionAllowBtn);
        }

        Waits.waitForElementToBeClickable(shutterBtn, Duration.ofSeconds(5));
        ElementsActions.click(shutterBtn);

        Waits.waitForElementToBeClickable(doneBtn, Duration.ofSeconds(5));
        ElementsActions.click(doneBtn);

        // Wait and crop the photo
        Waits.waitForElementToBeClickable(cropBtn, Duration.ofSeconds(10));
        ElementsActions.click(cropBtn);

        // Wait for save button and press it after crop
        Waits.waitForElementToBeClickable(saveBtn, Duration.ofSeconds(10));
        ElementsActions.click(saveBtn);

        // Optional: wait for success confirmation (if available)
        Waits.waitFor(Duration.ofSeconds(3));
    }

    // ---------------- Assertion Helper ---------------- //
    @Step("Check if delete success message is visible")
    public boolean isDeleteSuccessMessageVisible() {
        try {
            By successMsg = AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Giver deleted successfully\")"
            );

            boolean isVisible = Waits.waitForTextToBeVisiblee("Giver deleted successfully", Duration.ofSeconds(10));

            if (!isVisible) {
                isVisible = ElementsActions.isDisplayed(successMsg);
            }

            return isVisible;
        } catch (Exception e) {
            System.out.println("[ERROR] Could not verify delete success message: " + e.getMessage());
            return false;
        }
    }
}
