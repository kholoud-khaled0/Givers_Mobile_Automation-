package testClasses.features.Authentication;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.android.AndroidLoginScreen;
import utils.common.assertions.AssertionManager;
import utils.model.LoginTestData;
import utils.testFactory.DataProviders;

@Listeners(DynamicAllureListener.class)
@Feature("Login Feature")
@Story("Success Login Flows")
public class LoginTests {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testLogin(LoginTestData loginTestData) {

        // Set story & description dynamically to fix Allure listener error
        this.story = loginTestData.story();
        this.description = loginTestData.description();

        String email = loginTestData.email();
        String password = loginTestData.password();

        // ✅ Perform login flow
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.login(email, password);

        // ✅ Validate that user successfully reaches Home screen
        boolean isHomeVisible = !loginScreen.isInLoginScreen();
        AssertionManager.assertTrue(isHomeVisible, "Home Page should be visible after successful login");

        AssertionManager.assertAll(null);
    }

    // Dummy fields to fix DynamicAllureListener error
    public String story;
    public String description;
}
