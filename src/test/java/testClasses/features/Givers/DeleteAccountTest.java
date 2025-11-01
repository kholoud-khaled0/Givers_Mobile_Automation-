package testClasses.features.Givers;

import io.qameta.allure.*;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.android.AndroidLoginScreen;
import screens.android.AndroidPersonalInformationScreen;
import utils.common.TestContext;
import utils.common.assertions.AssertionManager;
import utils.model.PersonalInformationTestData;
import utils.testFactory.DataProviders;

@Listeners(DynamicAllureListener.class)
@Feature("Personal Information Feature")
@Story("Delete Account Flow")
public class DeleteAccountTest {

    public String story;
    public String description;

    @Test(dataProvider = "deleteAccountData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can delete their account successfully and see success message.")
    public void testDeleteAccount(PersonalInformationTestData testData) {

        this.story = testData.story();
        this.description = testData.description();


        String email = TestContext.getLatestEmailFromLogin();
        String password = testData.password();

        if (email == null || email.isEmpty()) {
            email = testData.email();
        }
        if (password == null || password.isEmpty()) {
            password = testData.password();
        }

        System.out.println("[INFO] Deleting account for user: " + email);

        // Step 1: Login
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(email, password);

        // Step 2: Perform delete account flow
        AndroidPersonalInformationScreen personalInfo = new AndroidPersonalInformationScreen();
        personalInfo.performDeleteAccountScenario();

        // Step 3: Assert success message appeared
        boolean isDeleteSuccess = personalInfo.isDeleteSuccessMessageVisible();
        AssertionManager.assertTrue(
                isDeleteSuccess,
                "User should see 'Giver deleted successfully' message after deletion."
        );

        AssertionManager.assertAll(null);
    }
}
