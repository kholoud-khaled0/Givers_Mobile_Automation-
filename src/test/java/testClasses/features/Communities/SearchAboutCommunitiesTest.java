package testClasses.features.Communities;

import io.qameta.allure.*;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.android.AndroidCommunitiesScreen;
import screens.android.AndroidLoginScreen;
import utils.common.CommunityStats;
import utils.common.assertions.AssertionManager;
import utils.model.CommunityTestData;
import utils.testFactory.DataProviders;

@Listeners(DynamicAllureListener.class)
@Feature("Communities Feature")
public class SearchAboutCommunitiesTest {

    // =========================
    // 🔎 SEARCH ONLY SCENARIO
    // =========================
    @Test(
            dataProvider = "searchOnlyData",
            dataProviderClass = DataProviders.class
    )
    @Severity(SeverityLevel.NORMAL)
    @Story("Search Community Only")
    @Description("Verify search returns only the searched community or valid error message")
    public void testSearchCommunityOnly(CommunityTestData testData) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(
                testData.email(),
                testData.password()
        );

        AndroidCommunitiesScreen communitiesScreen =
                new AndroidCommunitiesScreen();

        communitiesScreen.searchAndVerifyOnlyResult(
                testData.communityName()
        );

        AssertionManager.assertAll(null);
    }

    // =========================
    // 🔁 FULL COMMUNITY FLOW
    // =========================
    @Test(
            dataProvider = "fullCommunityFlowData",
            dataProviderClass = DataProviders.class
    )
    @Severity(SeverityLevel.CRITICAL)
    @Story("Validate Community Full Flow")
    @Description("Verify user can search for a community and execute full scenario based on type")
    public void testValidateCommunityFullFlow(CommunityTestData testData) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(
                testData.email(),
                testData.password()
        );

        AndroidCommunitiesScreen communitiesScreen =
                new AndroidCommunitiesScreen();

        CommunityStats stats =
                communitiesScreen.openCommunityAndExecuteScenario(
                        testData.communityName(),
                        testData.getCommunityType(),
                        testData.otp()
                );

        AssertionManager.assertNotNull(
                stats,
                "Community stats should not be null"
        );

        AssertionManager.assertTrue(
                stats.getCreatedNeedyCount() != null
                        || stats.getSupportedNeedyCount() != null,
                "Community should contain at least one valid statistic"
        );

        AssertionManager.assertAll(null);
    }

}
