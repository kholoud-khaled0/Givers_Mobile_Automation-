package screens.android;

import io.qameta.allure.Step;
import screens.base.BadgeScreen;
import utils.common.BadgeNames;

public class AndroidBadgeScreen extends BadgeScreen {

    @Step("Complete Badges flow from profile to enabled and disabled badges")
    public void completeBadgesFlow() {

        tapOnProfileImage();
        verifyMyBadgesTitleIsDisplayed();

        tapOnViewBadgesList();
        verifyBadgesTitleIsDisplayed();

        openEnableFirstBadge();
        verifyCongratulationMessageIsDisplayed();
        verifyShareBadgeButtonIsEnabled();

        tapOnBadgesTitleToGoBack();

        scrollToDisableFirstBadge();
        openDisableFirstBadge();
        verifyBadgeMessageIsDisplayed();
        verifyShareBadgeButtonDoesNotWork();

        tapOnBadgesTitleToGoBack();
        searchAndOpenAllBadges();
    }


    @Step("Search and open all badges one by one")
    public void searchAndOpenAllBadges() {

        for (BadgeNames badge : BadgeNames.values()) {

            searchAndOpenBadgeByName(badge);
            tapOnBadgesTitleToGoBack();
        }
    }


}
