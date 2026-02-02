package testClasses.features.Givers;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import screens.android.AndroidGiversScreen;
import screens.android.AndroidLoginScreen;
import screens.base.GiversScreen;
import utils.model.LoginTestData;
import utils.testFactory.DataProviders;
import utils.common.assertions.AssertionManager;

@Feature("Givers Feature")
@Story("Suggest Improvement Flow")
public class ApplicationFeedbackTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user can open Suggest Improvement page, enter random feedback, attach a file, and submit successfully")
    public void testSuggestImprovementFlow(LoginTestData testData) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        AndroidGiversScreen givers = new AndroidGiversScreen();
        givers.openMoreMenu();

        // Open Suggest Improvement flow
        givers.openAndVerifySuggestImprovement();

        // Enter random feedback text + attach file
        givers.enterFeedbackAndAttachFile();

        // Submit suggestion
        givers.submitFeedbackAndVerify();

        AssertionManager.assertAll(null);
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user can open Report a Bug page, enter random feedback, attach a file, and submit successfully")
    public void testReportBugFlow(LoginTestData testData) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        AndroidGiversScreen givers = new AndroidGiversScreen();
        givers.openMoreMenu();

        // Scroll and open Report a Bug
        givers.openAndVerifyReportBug();

        // Enter random bug description + attach file
        givers.enterBugReportAndAttachFile();

        // Submit report and verify success
        givers.submitBugReportAndVerify();

        AssertionManager.assertAll(null);
    }

}
