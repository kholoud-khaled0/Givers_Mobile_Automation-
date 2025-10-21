package testClasses.features;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.android.AndroidLoginScreen;
import utils.common.assertions.AssertionManager;
import utils.model.LoginTestData;
import utils.testFactory.DataProviders;

@Listeners(DynamicAllureListener.class)
@Feature("Login Feature")
public class LoginTests{

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testLogin(LoginTestData loginTestData) {

        // Set story & description dynamically to fix Allure listener error
        this.story = loginTestData.story();
        this.description = loginTestData.description();

        String email = loginTestData.email();
        String password = loginTestData.password();
        boolean shouldLogin = loginTestData.shouldLogin();

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();

        if (shouldLogin) {
            loginScreen.login(email, password);
            boolean isHomeVisible = !loginScreen.isInLoginScreen();
            AssertionManager.assertTrue(isHomeVisible, "Home Page should be visible after successful login");
        } else {
            loginScreen.login(email, password);

            boolean isToastVisible = loginScreen.isErrorToastVisible();
            AssertionManager.assertTrue(isToastVisible, "Error toast message should appear after failed login");

            AssertionManager.assertTrue(loginScreen.isInLoginScreen(),
                    "User should remain on login screen after failed login");
        }

        AssertionManager.assertAll(null);
    }

    // Dummy fields to fix DynamicAllureListener error
    public String story;
    public String description;
}
