package testClasses.features.Givers;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import screens.android.AndroidGiversScreen;
import screens.android.AndroidLoginScreen;
import utils.common.assertions.AssertionManager;
import utils.model.LoginTestData;
import utils.testFactory.DataProviders;

@Feature("Givers Feature")
@Story("My Favorites Flow")
public class MyFavoritesTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can add a needy to favorites and remove from favorites successfully")
    public void testAddRemoveFavorites(LoginTestData testData) {

        // Step 1: Login
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        // Step 2: Open Givers Screen
        AndroidGiversScreen giversScreen = new AndroidGiversScreen();

        // Step 3: Open Needy section
        giversScreen.openNeedySection();

        // Step 4: Ensure first needy is visible
        giversScreen.ensureFirstNeedyVisible();

        // Step 5: Open details and add to favorites
        giversScreen.openDetails();
        giversScreen.addToFavorites();

        // Step 6: Verify dynamic message contains 'added to your favorites'
        giversScreen.verifyMessageContains("added to your favorites");

        // Step 7: Go back to main screen
        giversScreen.goBack();

        // Step 8: Open More → My Favorites
        giversScreen.openMoreMenu();
        giversScreen.openMyFavorites();

        // Step 10: Remove from favorites
        giversScreen.removeFromFavoritesByIndex(0);

        // Step 11: Verify dynamic removal message
        giversScreen.verifyMessageContains("removed from your favorites");

        AssertionManager.assertAll(null);
    }
}
