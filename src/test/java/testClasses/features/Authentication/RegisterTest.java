package testClasses.features.Authentication;

import io.qameta.allure.*;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.android.AndroidRegisterScreen;
import utils.common.TestContext;
import utils.model.RegisterTestData;
import utils.testFactory.DataProviders;

/**
 * Test Class for Register Feature
 * Includes both:
 *  - Full registration flow (OTP + Camera)
 *  - Validation flow (Inline errors + Password rules)
 */
@Listeners(DynamicAllureListener.class)
@Feature("Register Feature")
@Story("Register Flows")
public class RegisterTest {

    public String story;
    public String description;

    // ------------------------------------------------------------------------- //
    //  TEST 1: Full Registration Flow (Main Scenario)
    // ------------------------------------------------------------------------- //
    @Test(dataProvider = "registerData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Complete User Registration Flow")
    @Description("Validates the full registration flow including OTP and camera upload.")
    public void testRegistration(RegisterTestData registerTestData) {

        this.story = registerTestData.story();
        this.description = registerTestData.description();

        String firstName = registerTestData.firstName();
        String lastName = registerTestData.lastName();

        //  Generate unique email each time
        String baseEmail = registerTestData.email();
        String uniqueEmail = baseEmail.replace("@", "+" + System.currentTimeMillis() + "@");

        String password = registerTestData.password();
        String otp = registerTestData.otp();

        AndroidRegisterScreen registerScreen = new AndroidRegisterScreen();

        registerScreen.performRegistrationFlow(firstName, lastName, uniqueEmail, password, otp);
        registerScreen.verifyHomeScreenDisplayed();

        //  Save this email globally so other tests (like Reset Password) can reuse it
        TestContext.setLatestEmailFromLogin(uniqueEmail);

        System.out.println("[INFO] Registered new user email stored in context: " + uniqueEmail);
    }
}