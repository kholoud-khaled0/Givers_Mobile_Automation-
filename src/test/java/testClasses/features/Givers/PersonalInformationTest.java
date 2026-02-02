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
@Story("Edit profile, upload photo, and change email flows")
public class PersonalInformationTest {

    public String story;
    public String description;

    // ------------------------------------------------------------------------- //
    //  TEST 1: Edit personal information (Scenario 1)
    // ------------------------------------------------------------------------- //
    @Test(dataProvider = "personalInformationData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Edit Personal Info and Remove Photo")
    @Description("Verify user can edit first/last name, bio, remove photo and save successfully.")
    public void testEditPersonalInformation(PersonalInformationTestData testData) {

        this.story = testData.story();
        this.description = testData.description();

        // Step 1: Login
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        // Step 2: Perform Scenario 1
        AndroidPersonalInformationScreen personalInfo = new AndroidPersonalInformationScreen();
        personalInfo.performEditInfoScenario(
                testData.firstName(),
                testData.lastName()
        );

        AssertionManager.assertAll(null);
    }

    // ------------------------------------------------------------------------- //
    //  TEST 2: Upload photo + change email + revert (Scenario 2)
    // ------------------------------------------------------------------------- //
    @Test(dataProvider = "personalInformationData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Upload Photo and Change Email with OTP")
    @Description("Verify user can upload photo, change email using OTP, and revert it successfully.")
    public void testChangeEmailAndUploadPhoto(PersonalInformationTestData testData) {

        this.story = testData.story();
        this.description = testData.description();

        // Step 1: Login using old email
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        // Step 2: Get new email directly from JSON
        String oldEmail = testData.email();
        String newEmail = testData.newEmail();
        String otp = testData.otp();

        System.out.println("[INFO] Old email: " + oldEmail);
        System.out.println("[INFO] New email (from JSON): " + newEmail);

        // Step 3: Perform Scenario 2 (Change email + upload photo + OTP)
        AndroidPersonalInformationScreen personalInfo = new AndroidPersonalInformationScreen();
        personalInfo.performChangeEmailScenario(newEmail, oldEmail, otp);

        // Step 4: Save email in context
        TestContext.setLatestEmailFromLogin(newEmail);
        System.out.println("[INFO] New email stored in context: " + newEmail);

        AssertionManager.assertAll(null);
    }
}
