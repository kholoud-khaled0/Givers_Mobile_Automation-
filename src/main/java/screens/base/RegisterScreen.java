package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.android.AndroidActions;
import utils.appium.ElementsActions;

/**
 * Base class for Register Screen functionality
 */
public abstract class RegisterScreen {

    // ------------------- Locators ------------------- //
    protected static final By createAnAccountBtn =
            AppiumBy.accessibilityId("Create An Account");

    protected static final By welcomeTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Welcome to Givers!\")");

    protected static final By firstNameField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter your first name\")");

    protected static final By lastNameField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter your last name\")");

    protected static final By emailField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter your email\")");

    protected static final By passwordField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter password\")");

    protected static final By repeatPasswordField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Repeat password\")");

    protected static final By termsCheckbox =
            AppiumBy.className("android.widget.CheckBox");

    protected static final By createAccountBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Create My Account\")");

    protected static final By skipBtn =
            AppiumBy.accessibilityId("Skip");

    protected static final By skipVerBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"skip\")");

    protected static final By launchCameraBtn =
            AppiumBy.accessibilityId("launch-camera");

    protected static final By uploadProfilePictureTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Upload Profile Picture\")");

    protected static final By imageCameraBox =
            AppiumBy.className("android.view.ViewGroup");

    protected static final By permeation =
            AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    protected static final By shutterBtn =
            AppiumBy.accessibilityId("Shutter");

    protected static final By doneBtn =
            AppiumBy.accessibilityId("Done");

    protected static final By cropBtn =
            AppiumBy.id("com.giversapp.GiversApp.staging:id/crop_image_menu_crop");

    protected static final By startBtn =
            AppiumBy.accessibilityId("Get Started!");

    // Home Title (from LoginScreen)
    protected static final By homeTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Givers\")");

    // ------------------- Inline Error Messages ------------------- //
    protected static final By firstNameInlineError =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"First name must contain at least 3 letters\")");

    protected static final By lastNameInlineError =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Last name must contain at least 3 letters\")");

    protected static final By passwordMismatchInlineError =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"The entered passwords do not match\")");



    // ------------------- Common Actions ------------------- //

    @Step("Tap 'Create An Account' button")
    public void tapCreateAnAccountButton() {
        ElementsActions.click(skipBtn);
        ElementsActions.click(createAnAccountBtn);
    }

    @Step("Set first name: {firstName}")
    public void setFirstName(String firstName) {
        ElementsActions.setValue(firstNameField, firstName);
    }

    @Step("Set last name: {lastName}")
    public void setLastName(String lastName) {
        ElementsActions.setValue(lastNameField, lastName);
    }

    @Step("Set email: {email}")
    public void setEmail(String email) {
        ElementsActions.setValue(emailField, email);
    }

    @Step("Set password: {password}")
    public void setPassword(String password) {
        ElementsActions.setValue(passwordField, password);
        ElementsActions.setValue(repeatPasswordField, password);
        AndroidActions.scrollToText("Create My Account");
    }

    @Step("Tap 'Create My Account' button")
    public void tapCreateAccountButton() {
        ElementsActions.click(createAccountBtn);
    }

    @Step("Tap Terms & Conditions checkbox")
    public void tapTermsCheckbox() {
        ElementsActions.click(termsCheckbox);
    }

    @Step("Check if 'Welcome to Givers!' title is displayed")
    public boolean isWelcomeDisplayed() {
        return ElementsActions.isDisplayed(welcomeTitle);
    }

    @Step("Tap 'Skip' on identity verification screen")
    public void tapSkipVerification() {
        ElementsActions.click(skipVerBtn);
    }

    @Step("Verify 'Upload Profile Picture' page is displayed")
    public boolean isUploadPicturePageDisplayed() {
        return ElementsActions.isDisplayed(uploadProfilePictureTitle);
    }

    @Step("Tap the image/camera box to open picker")
    public void tapImageCameraBox() {
        ElementsActions.click(imageCameraBox);
    }

    @Step("Tap 'Launch Camera' button")
    public void tapLaunchCamera() {
        ElementsActions.click(launchCameraBtn);
    }

    // ------------------- Camera Actions ------------------- //
    @Step("Allow camera permission if prompted")
    public void allowCameraPermission() {
        ElementsActions.click(permeation);
    }

    @Step("Capture photo using 'Shutter' button")
    public void tapShutterButton() {
        ElementsActions.click(shutterBtn);
    }

    @Step("Tap 'Done' after capturing photo")
    public void tapDoneButton() {
        ElementsActions.click(doneBtn);
    }

    @Step("Crop the captured image")
    public void tapCropButton() {
        ElementsActions.click(cropBtn);
    }

    @Step("Tap 'Get Started!' to finish registration")
    public void tapGetStartedButton() {
        ElementsActions.click(startBtn);
    }

    @Step("Check if 'Givers' home title is displayed")
    public boolean isHomeDisplayed() {
        return ElementsActions.isDisplayed(homeTitle);
    }

    // ------------------- Field Utilities ------------------- //
    @Step("Clear First Name field")
    public void clearFirstName() {
        ElementsActions.clear(firstNameField);
    }

    @Step("Clear Last Name field")
    public void clearLastName() {
        ElementsActions.clear(lastNameField);
    }

    @Step("Clear Repeat Password field")
    public void clearRepeatPassword() {
        ElementsActions.clear(repeatPasswordField);
    }

    // ------------------- Inline Error Checks ------------------- //
    @Step("Is first-name inline error displayed?")
    public boolean isFirstNameInlineErrorDisplayed() {
        return ElementsActions.isDisplayed(firstNameInlineError);
    }

    @Step("Is last-name inline error displayed?")
    public boolean isLastNameInlineErrorDisplayed() {
        return ElementsActions.isDisplayed(lastNameInlineError);
    }

    @Step("Is password-mismatch inline error displayed?")
    public boolean isPasswordMismatchInlineErrorDisplayed() {
        return ElementsActions.isDisplayed(passwordMismatchInlineError);
    }




    // ------------------- Abstract Methods ------------------- //
    @Step("Enter OTP: {otp}")
    public abstract void enterOtp(String otp);

    @Step("Perform full registration flow")
    public abstract void performRegistrationFlow(String firstName, String lastName, String email, String password, String otp);
}
