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

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        AndroidGiversScreen giversScreen = new AndroidGiversScreen();
        giversScreen.openNeedySection();
        giversScreen.ensureFirstNeedyVisible();
        //giversScreen.selectFirstNeedy();
        giversScreen.addToFavorites();
        giversScreen.verifyMessageContains("added to your favorites");
        giversScreen.goBack();
        giversScreen.openMoreMenu();
        giversScreen.openMyFavorites();
        giversScreen.removeFromFavoritesByIndex(0);
        giversScreen.verifyMessageContains("removed from your favorites");

        AssertionManager.assertAll(null);
    }

    // ------------------- NEW TEST FOR COMMUNITIES ------------------- //


    // ------------------- NEW TEST FOR GIVERS ------------------- //

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can add a giver to favorites and remove it successfully")
    public void testAddRemoveGiverFavorites(LoginTestData testData) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        AndroidGiversScreen giversScreen = new AndroidGiversScreen();
        giversScreen.openCommunities();
        giversScreen.openGiversTab();
        giversScreen.selectGiverByIndex(0);
        giversScreen.addToFavorites();
        giversScreen.verifyMessageContains("added to your favorites");

        giversScreen.goBack();
        giversScreen.openMoreMenu();
        giversScreen.openMyFavorites();
        giversScreen.openGiversTab();
        giversScreen.verifyGiverExistsByIndex(0);

        giversScreen.removeFromFavoritesByIndex(0);
        giversScreen.verifyMessageContains("removed from your favorites");

        AssertionManager.assertAll(null);
    }
}
