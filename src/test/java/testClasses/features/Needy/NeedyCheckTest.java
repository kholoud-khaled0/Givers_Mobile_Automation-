package testClasses.features.Needy;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import screens.android.AndroidLoginScreen;
import screens.android.AndroidNeedyCheckScreen;
import utils.common.assertions.AssertionManager;
import utils.model.NeedyTestData;
import utils.testFactory.DataProviders;

public class NeedyCheckTest {

    @Test(dataProvider = "needyCheckData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a user can log in, navigate to Needy Check, enter valid ID and Name, and see the 'Existing household member' message.")
    public void testExistingHouseholdMemberFlow(NeedyTestData testData) {

        // 1️⃣ Login

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        // 2️⃣ Initialize NeedyCheck screen
        AndroidNeedyCheckScreen needyScreen = new AndroidNeedyCheckScreen();

        // 3️⃣ Perform the full flow
        needyScreen.performNeedyCheckFlow(testData.ID(), testData.Name());

        // 4️⃣ Assertion: Verify Existing Household Member message
        AssertionManager.assertTrue(
                needyScreen.isExistingProfile(),
                "Expected 'Existing household member' message to be displayed."
        );

        // 5️⃣ Collect assertions
        AssertionManager.assertAll(null);
    }

    @Test(dataProvider = "needyCheckData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a user can log in, navigate to Needy Check, enter valid ID with incorrect Name, and see the 'Not Existing' message.")
    public void testMismatchedNameFlow(NeedyTestData testData) {

        // 1️⃣ Login
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        // 2️⃣ Initialize NeedyCheck screen
        AndroidNeedyCheckScreen needyScreen = new AndroidNeedyCheckScreen();

        // 3️⃣ Perform the full flow with mismatched name
        needyScreen.performNeedyCheckFlow(testData.ID(), testData.Name());

        // 4️⃣ Assertion: Verify Not Existing message
        AssertionManager.assertTrue(
                needyScreen.isProfileNotFound(),
                "Expected 'Not Existing' message to be displayed for mismatched Name."
        );

        AssertionManager.assertAll(null);
    }

    @Test(dataProvider = "needyCheckData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a user can log in, navigate to Needy Check, enter incorrect ID with correct Name, and see the 'Not Existing' message.")
    public void testIncorrectIDFlow(NeedyTestData testData) {

        // 1️⃣ Login
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        // 2️⃣ Initialize NeedyCheck screen
        AndroidNeedyCheckScreen needyScreen = new AndroidNeedyCheckScreen();

        // 3️⃣ Perform the full flow with incorrect ID
        needyScreen.performNeedyCheckFlow(testData.ID(), testData.Name());

        // 4️⃣ Assertion: Verify Not Existing message
        AssertionManager.assertTrue(
                needyScreen.isProfileNotFound(),
                "Expected 'Not Existing' message to be displayed for incorrect ID."
        );

        AssertionManager.assertAll(null);
    }
    @Test(dataProvider = "needyCheckData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a user can log in, navigate to Needy Check, enter valid ID and Name, and see the 'Existing household member' message.")
    public void testExistingNeedyMemberFlow(NeedyTestData testData) {

        // 1️⃣ Login
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        // 2️⃣ Initialize NeedyCheck screen
        AndroidNeedyCheckScreen needyScreen = new AndroidNeedyCheckScreen();

        // 3️⃣ Perform the full flow
        needyScreen.performNeedyCheckFlow(testData.ID(), testData.Name());

        // 5️⃣ Collect assertions
        AssertionManager.assertAll(null);
    }

}
