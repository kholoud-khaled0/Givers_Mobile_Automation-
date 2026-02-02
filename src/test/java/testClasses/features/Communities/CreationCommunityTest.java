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
@Feature("Creation Community")
@Story("Creation Community Full Flow")
public class CreationCommunityTest {

        @Test(
                dataProvider = "creationCommunityData",
                dataProviderClass = DataProviders.class
        )
        @Severity(SeverityLevel.CRITICAL)
        @Description("Verify Creation can manage community, posts, and profiles successfully")
        public void testCreationCommunityScenario(CommunityTestData testData) {

            // 1️⃣ Login
            AndroidLoginScreen loginScreen = new AndroidLoginScreen();
            loginScreen.loginWithSkip(
                    testData.email(),
                    testData.password()
            );

            // 2️⃣ Execute Moderator Community Scenario
            AndroidCommunitiesScreen communitiesScreen =
                    new AndroidCommunitiesScreen();

            communitiesScreen.executeCreationCommunityScenario(
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

