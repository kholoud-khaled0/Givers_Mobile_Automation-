package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.android.AndroidActions;
import utils.appium.ElementsActions;
import utils.appium.Waits;

import java.time.Duration;

/**
 * Base class for Personal Information Screen functionality.
 * Contains locators and reusable actions for both Android & iOS implementations.
 */
public abstract class PersonalInformationScreen {

    // ------------------- Locators ------------------- //

    protected static final By moreBtn =
            AppiumBy.accessibilityId("\uE821, More");

    protected static final By personalInformationBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"Personal Information\")");

    protected static final By editBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit\")");

    protected static final By firstNameField =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)");

    protected static final By lastNameField =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");

    protected static final By saveBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Save\")");

    protected static final By profileSuccessMsg =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile updated successfully!\")");

    protected static final By removePhotoBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Remove Photo\")");

    protected static final By profileImageIcon =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(25)");

    protected static final By changeMyEmailBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Change My Email Address\")");

    protected static final By enterYourEmailField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter your email\")");

    protected static final By sendCodeBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Send Code\")");

    protected static final By launchCameraBtn =
            AppiumBy.accessibilityId("launch-camera");

    protected static final By permissionAllowBtn =
            AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    protected static final By shutterBtn =
            AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Shutter\")");

    protected static final By doneBtn =
            AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Done\")");

    protected static final By cropBtn =
            AppiumBy.id("com.giversapp.GiversApp.staging:id/crop_image_menu_crop");

    protected static final By profileIdentifier =
            AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\", @\")");

    protected static final By deleteMyAccountBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete My Account\")");

    protected static final By confirmDeleteField =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
    protected static final By confirmDeleteMyAccountBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete My Account\")");


    // ------------------- Common Actions ------------------- //

    @Step("Tap 'More' button")
    public void tapMoreButton() {
        ElementsActions.click(moreBtn);
    }

    @Step("Open 'Personal Information' section")
    public void openPersonalInformation() {
        ElementsActions.click(personalInformationBtn);
    }

    @Step("Double tap profile identifier to copy user ID")
    public String doubleTapProfileIdentifier() {
        Waits.waitForElementToBeVisible(profileIdentifier);

        ElementsActions.doubleClick(profileIdentifier);

        String fullDesc = ElementsActions.getAttribute(profileIdentifier, "contentDescription");
        String extractedId = null;

        if (fullDesc != null && fullDesc.contains("@")) {

            extractedId = fullDesc.substring(fullDesc.indexOf("@") + 1).trim();
        }

        System.out.println("[INFO] Extracted dynamic user ID (without @): " + extractedId);
        return extractedId;
    }

    @Step("Tap 'Delete My Account' button")
    public void tapDeleteMyAccountButton() {
        ElementsActions.click(deleteMyAccountBtn);
    }

    @Step("Paste user ID into confirmation field and tap delete")
    public void pasteUserIdAndDelete(String userId) {
        ElementsActions.click(confirmDeleteField);
        ElementsActions.setValue(confirmDeleteField, userId);

        // Ensure the Delete My Account button is clickable before tapping
        Waits.waitForElementToBeClickable(confirmDeleteMyAccountBtn, Duration.ofSeconds(5));

        ElementsActions.click(confirmDeleteMyAccountBtn);
    }


    @Step("Tap 'Edit' button")
    public void tapEditButton() {
        ElementsActions.click(editBtn);
    }

    @Step("Update first name: {newFirstName}")
    public void updateFirstName(String newFirstName) {
        ElementsActions.click(firstNameField);
        Waits.waitForElementToBeVisible(firstNameField);
        String currentValue = ElementsActions.getText(firstNameField);
        if (currentValue != null && !currentValue.isEmpty() && !currentValue.equals(newFirstName)) {
            ElementsActions.clear(firstNameField);
        }

        ElementsActions.setValue(firstNameField, newFirstName);
    }

    @Step("Update last name: {newLastName}")
    public void updateLastName(String newLastName) {
        ElementsActions.click(lastNameField);
        Waits.waitForElementToBeVisible(lastNameField);
        String currentValue = ElementsActions.getText(lastNameField);
        if (currentValue != null && !currentValue.isEmpty() && !currentValue.equals(newLastName)) {
            ElementsActions.clear(lastNameField);
        }
        ElementsActions.setValue(lastNameField, newLastName);
    }

    @Step("Remove profile photo")
    public void removePhoto() {
        AndroidActions.scrollToText("Remove Photo");
        ElementsActions.click(removePhotoBtn);
    }

    @Step("Tap profile image icon to open upload options")
    public void tapProfileImageIcon() {
        ElementsActions.click(profileImageIcon);
    }

    @Step("Tap 'Change My Email Address' button")
    public void tapChangeMyEmailButton() {
        ElementsActions.click(changeMyEmailBtn);
    }

    @Step("Enter email: {email}")
    public void enterEmail(String email) {
        ElementsActions.setValue(enterYourEmailField, email);
    }

    @Step("Tap 'Send Code' button")
    public void tapSendCodeButton() {
        ElementsActions.click(sendCodeBtn);
    }

    @Step("Tap 'Save' button")
    public void tapSaveButton() {
        ElementsActions.click(saveBtn);
    }

    @Step("Check success message is displayed")
    public boolean isProfileUpdateSuccessVisible() {
        return ElementsActions.isDisplayed(profileSuccessMsg);
    }

    // ------------------- Abstract Flows ------------------- //

    @Step("Perform scenario 1: edit name, bio, remove photo and save")
    public abstract void performEditInfoScenario(String firstName, String lastName);

    @Step("Perform scenario 2: upload photo, change email (with OTP), and verify")
    public abstract void performChangeEmailScenario(String newEmail, String oldEmail, String otp);
}
