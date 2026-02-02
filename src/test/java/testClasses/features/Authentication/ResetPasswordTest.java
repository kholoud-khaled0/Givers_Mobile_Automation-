package testClasses.features.Authentication;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.android.AndroidLoginScreen;
import screens.android.AndroidResetPasswordScreen;
import utils.common.TestContext;
import utils.common.assertions.AssertionManager;
import utils.model.ResetPasswordTestData;
import utils.testFactory.DataProviders;

@Listeners(DynamicAllureListener.class)
@Feature("Reset Password Feature")
@Story("Reset Password and logout Flows")
public class ResetPasswordTest {

    @Test(dataProvider = "resetPasswordData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testFullResetPasswordFlow(ResetPasswordTestData testData) {

        this.story = testData.story();
        this.description = testData.description();

        // Get latest data from Register (shared context)
        String email = TestContext.getLatestEmailFromLogin();
        if (email == null || email.isEmpty()) {
            email = testData.email(); // fallback to JSON
        }

        String oldPassword = TestContext.getLatestPasswordFromRegister();
        if (oldPassword == null || oldPassword.isEmpty()) {
            oldPassword = testData.oldPassword(); // fallback to JSON
        }

        String newPassword = testData.newPassword();

        // Step 1: Login with old password
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(email, oldPassword);
        boolean isHomeVisible = !loginScreen.isInLoginScreen();
        AssertionManager.assertTrue(isHomeVisible, "Home Page should be visible after first login.");

        // Step 2: Reset password


        AndroidResetPasswordScreen resetScreen = new AndroidResetPasswordScreen();
        resetScreen.performResetPasswordFlow(oldPassword, newPassword);

        // Step 3: Logout after reset
        resetScreen.performLogoutAfterReset();

        // Step 4: Login again with new password
        AndroidLoginScreen reLoginScreen = new AndroidLoginScreen();
        reLoginScreen.SignInWithoutSkipButton(email, newPassword);

        AssertionManager.assertAll(null);
    }

    public String story;
    public String description;
}
