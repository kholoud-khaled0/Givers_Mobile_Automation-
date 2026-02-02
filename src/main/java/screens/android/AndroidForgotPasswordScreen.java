package screens.android;

import io.qameta.allure.Step;
import screens.base.ForgotPasswordScreen;
import utils.appium.ElementsActions;
import utils.appium.Waits;
import utils.common.assertions.AssertionManager;

import java.time.Duration;


/**
 * Android implementation for Forgot Password Screen
 * Handles full flow and validations
 */
public class AndroidForgotPasswordScreen extends ForgotPasswordScreen {

    @Override
    @Step("Perform login after password reset")
    public void performLoginAfterReset(String email, String password) {
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.performLogin(email, password);
    }

    // ------------------- Complete Forgot Password Flow ------------------- //
    @Step("Perform complete Forgot Password flow with OTP: {otp}")
    public void performForgotPasswordFlow(String email, String otp, String newPassword) {

        // Step 1: Navigate to Forgot Password
        tapSkipButton();
        tapSignUpButton();
        tapSignInButton();
        tapForgotPasswordButton();

        // Step 2: Enter email and send OTP
        setEmail(email);
        tapSendCodeButton();

        // Step 3: Wait & enter OTP
        Waits.waitFor(Duration.ofSeconds(3));
        enterOtp(otp);

        // Step 4: Enter and confirm new password
        setNewPassword(newPassword);
        setConfirmPassword(newPassword);
        tapResetPasswordButton();


        // Step 6: Back to Login screen
        tapBackToLoginButton();
        AssertionManager.assertTrue(
                isWelcomeBackVisible(),
                "Expected 'Welcome Back!' screen after returning to login."
        );
    }
    @Step("Tap 'More' button")
    public void tapMoreButton() {
        ElementsActions.click(moreBtn);
    }

    @Step("Tap Sign In button")
    public  void tapSignUpButton() {
        tapMoreButton();
        ElementsActions.click(signUpBtn);
    }
}
