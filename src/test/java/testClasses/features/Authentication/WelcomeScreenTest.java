package testClasses.features.Authentication;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listeners.DynamicAllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.android.AndroidWelcomeScreen;

@Listeners(DynamicAllureListener.class)
@Feature("Authentication Feature")
@Story("Welcome Screen Navigation Flows")
public class WelcomeScreenTest {

    private final AndroidWelcomeScreen welcomeScreen = new AndroidWelcomeScreen();

    @Test(priority = 1, description = "Skip directly and verify navigation to Sign Up screen")
    @Severity(SeverityLevel.CRITICAL)
    public void testSkipFlow() {


        welcomeScreen.skipFlow();

    }

    @Test(priority = 2, description = "Click Continue, then Skip, and verify navigation to Sign Up screen")
    @Severity(SeverityLevel.NORMAL)
    public void testContinueThenSkipFlow() {
        welcomeScreen.continueThenSkipFlow();

    }

    @Test(priority = 3, description = "Click Continue twice, then Let's Go, and verify navigation to Sign Up screen")
    @Severity(SeverityLevel.NORMAL)
    public void testFullContinueFlow() {
        welcomeScreen.fullContinueFlow();

    }

}
