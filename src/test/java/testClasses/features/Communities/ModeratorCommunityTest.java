package testClasses.features.Communities;

import io.qameta.allure.*;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.android.AndroidCommunitiesScreen;
import screens.android.AndroidLoginScreen;
import utils.common.assertions.AssertionManager;
import utils.model.CommunityTestData;
import utils.testFactory.DataProviders;

@Listeners(DynamicAllureListener.class)
@Feature("Moderator Community")
@Story("Moderator Community Full Flow")
public class ModeratorCommunityTest {

    @Test(
            dataProvider = "moderatorCommunityData",
            dataProviderClass = DataProviders.class
    )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify moderator can manage community, posts, and profiles successfully")
    public void testModeratorCommunityScenario(CommunityTestData testData) {

        // 1️⃣ Login
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(
                testData.email(),
                testData.password()
        );

        // 2️⃣ Execute Moderator Community Scenario
        AndroidCommunitiesScreen communitiesScreen =
                new AndroidCommunitiesScreen();

        communitiesScreen.ModeratorCommunityScenario(
                testData.communityName(),
                testData.giverId(),
                testData.secondEmail(),
                testData.secondPassword(),
                testData.email(),
                testData.password()
        );

        // 3️⃣ Assertions (Soft)
        AssertionManager.assertAll(null);
    }
}
