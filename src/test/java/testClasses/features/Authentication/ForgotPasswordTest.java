package testClasses.features.Authentication;

import io.qameta.allure.*;
import listeners.DynamicAllureListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.android.AndroidForgotPasswordScreen;
import utils.model.ForgotPasswordTestData;
import utils.testFactory.DataProviders;

/**
 * Test Class for Forgot Password Full Flow
 * Covers entering email, OTP, resetting password, and login verification.
 */
@Listeners(DynamicAllureListener.class)
@Feature("Forgot Password Feature")
@Story("Forgot Password and Login Flow")
public class ForgotPasswordTest {

    @Test(dataProvider = "forgotPasswordData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can reset password via 'Forgot Password', then login successfully with the new one.")
    public void testForgotPasswordFullFlow(ForgotPasswordTestData data) {

        // ------------------- Test Data ------------------- //
        String email = data.email();
        String newPassword = data.newPassword();
        String otp = data.otp();

        // ------------------- Screen Object ------------------- //
        AndroidForgotPasswordScreen forgotPasswordScreen = new AndroidForgotPasswordScreen();

        // Step 1: Navigate to Forgot Password
        forgotPasswordScreen.tapSkipButton();
        forgotPasswordScreen.tapSignInWithEmailButton();
        forgotPasswordScreen.tapForgotPasswordButton();

        // Step 2: Enter email and send OTP
        forgotPasswordScreen.setEmail(email);
        forgotPasswordScreen.tapSendCodeButton();

        // Step 3: Enter OTP and new password
        forgotPasswordScreen.enterOtp(otp);
        forgotPasswordScreen.setNewPassword(newPassword);
        forgotPasswordScreen.setConfirmPassword(newPassword);
        forgotPasswordScreen.tapResetPasswordButton();


        // Step 5: Back to login & verify title
        forgotPasswordScreen.tapBackToLoginButton();
        Assert.assertTrue(
                forgotPasswordScreen.isWelcomeBackVisible(),
                "'Welcome Back' title should be visible after returning to login."
        );

        // Step 6: Login with new password
        forgotPasswordScreen.performLoginAfterReset(email, newPassword);
    }
}
