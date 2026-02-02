package screens.android;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.RegisterScreen;
import utils.android.AndroidActions;
import utils.android.OtpHelper;
import utils.appium.ElementsActions;
import utils.appium.Waits;
import utils.common.assertions.AssertionManager;

import java.time.Duration;

/**
 * Android implementation of Register Screen
 * Handles full account creation flow and validations
 */
public class AndroidRegisterScreen extends RegisterScreen {

    private static final By homeTitle = AndroidLoginScreen.homeTitle;

    @Override
    @Step("Enter OTP digits: {otp}")
    public void enterOtp(String otp) {
        OtpHelper.enterOtp(otp);
    }

    // ------------------- Flow 1: Main Registration Flow ------------------- //
    @Override
    @Step("Perform full registration flow (Main Scenario)")
    public void performRegistrationFlow(String firstName, String lastName, String email, String password, String otp) {
        tapCreateAnAccountButton();
        verifyWelcomeScreenDisplayed();
        fillRegistrationForm(firstName, lastName, email, password);
        tapTermsCheckbox();
        tapCreateAccountButton();

        enterOtp(otp);

        AssertionManager.assertTrue(
                isUploadPicturePageDisplayed(),
                "Upload Profile Picture page should be displayed."
        );

        tapImageCameraBox();
        tapLaunchCamera();
        handleCameraAndCropFlow();
        tapGetStartedButton();
    }

    // ------------------- Flow 2: Validation Flow ------------------- //
    @Step("Perform registration validation flow (Inline errors + mismatch checks)")
    public void performRegistrationValidationFlow(
            String invalidFirstName,
            String validFirstName,
            String invalidLastName,
            String validLastName,
            String email,
            String password,
            String invalidConfirmPassword,
            String validConfirmPassword,
            String otp
    ) {
        tapCreateAnAccountButton();
        verifyWelcomeScreenDisplayed();

        // --- First Name ---
        setFirstName(invalidFirstName);
        AssertionManager.assertTrue(isFirstNameInlineErrorDisplayed(),
                "Expected inline error for invalid first name.");
        clearFirstName();

        setFirstName(validFirstName);
        AssertionManager.assertFalse(isFirstNameInlineErrorDisplayed(),
                "Expected no inline error for valid first name.");

        // --- Last Name ---
        setLastName(invalidLastName);
        AssertionManager.assertTrue(isLastNameInlineErrorDisplayed(),
                "Expected inline error for invalid last name.");
        clearLastName();

        setLastName(validLastName);
        AssertionManager.assertFalse(isLastNameInlineErrorDisplayed(),
                "Expected no inline error for valid last name.");

        // --- Email ---
        setEmail(email);

        // --- Password mismatch ---
        ElementsActions.setValue(passwordField, password);
        ElementsActions.setValue(repeatPasswordField, invalidConfirmPassword);
        AssertionManager.assertTrue(isPasswordMismatchInlineErrorDisplayed(),
                "Expected inline error for mismatched passwords.");

        clearRepeatPassword();
        ElementsActions.setValue(repeatPasswordField, validConfirmPassword);
        AssertionManager.assertFalse(isPasswordMismatchInlineErrorDisplayed(),
                "Expected no inline error after matching passwords.");

        AndroidActions.scrollToText("Create My Account");
        tapTermsCheckbox();
        tapCreateAccountButton();

        // OTP + Skip
        enterOtp(otp);
        Waits.waitForElementToBeClickable(skipVerBtn, Duration.ofSeconds(10));
        tapSkipVerification();

        // Camera Flow
        AssertionManager.assertTrue(isUploadPicturePageDisplayed(),
                "Upload Profile Picture page should be displayed.");
        tapImageCameraBox();
        tapLaunchCamera();
        handleCameraAndCropFlow();

        Waits.waitForElementToBeClickable(skipBtn, Duration.ofSeconds(10));
        ElementsActions.click(skipBtn);

    }

    @Step("Handle camera and crop flow")
    public void handleCameraAndCropFlow() {
        Waits.waitForElementToBeClickable(shutterBtn, Duration.ofSeconds(10));
        ElementsActions.click(shutterBtn);
        Waits.waitForElementToBeClickable(doneBtn, Duration.ofSeconds(10));
        ElementsActions.click(doneBtn);
        Waits.waitForElementToBeClickable(cropBtn, Duration.ofSeconds(10));
        ElementsActions.click(cropBtn);
    }

    @Step("Verify welcome screen displayed")
    public void verifyWelcomeScreenDisplayed() {
        boolean isDisplayed = AndroidActions.isElementDisplayed(welcomeTitle, 6);
        AssertionManager.assertTrue(isDisplayed, "Expected 'Welcome to Givers!' to be visible.");
    }

    @Step("Verify home screen displayed")
    public void verifyHomeScreenDisplayed() {
        boolean isHomeDisplayed = AndroidActions.isElementDisplayed(homeTitle, 10);
        AssertionManager.assertTrue(isHomeDisplayed, "Expected Home screen to be visible.");
    }

    @Step("Fill registration form fields")
    public void fillRegistrationForm(String firstName, String lastName, String email, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }
}
