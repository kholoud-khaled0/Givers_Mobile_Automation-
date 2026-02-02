package testClasses.features.Badge;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import screens.android.AndroidBadgeScreen;
import screens.android.AndroidLoginScreen;
import utils.model.CommunityTestData;
import utils.model.LoginTestData;
import utils.testFactory.DataProviders;

public class BadgeTest {

    @Test(
            dataProvider = "loginData", dataProviderClass = DataProviders.class
    )
    @Severity(SeverityLevel.CRITICAL)
    @Description(
            "Verify user can view badges from profile, open an enabled badge and validate congratulation message and share button state, then open a disabled badge and validate its message and disabled share button"
    )
    public void testBadgesValidation(LoginTestData loginTestData) {

        // 1 Login
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(
                loginTestData.email(),
                loginTestData.password()
        );
        AndroidBadgeScreen badgeScreen = new AndroidBadgeScreen();
        badgeScreen.completeBadgesFlow();
}
}
