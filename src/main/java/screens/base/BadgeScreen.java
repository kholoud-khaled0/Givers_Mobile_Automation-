package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.appium.ElementsActions;
import utils.appium.Waits;
import utils.common.BadgeNames;

import static org.testng.AssertJUnit.fail;
import static utils.common.assertions.CustomSoftAssert.*;

public class BadgeScreen {

    /* ================= Locators ================= */

    protected static final By profileImageBtn =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)");

    protected static final By myBadgesTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"My Badges\")");

    protected static final By viewBadgesListBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"View Badges List\")");

    protected static final By badgesTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Badges\")");

    protected static final By enableFirstBadge =
            AppiumBy.accessibilityId("Badge image, Giver In The Making");

    protected static final By congratulationMessage =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"You made your first donation already. The world is a little bit better now.\")");

    protected static final By shareBadgesBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"Share Badge\")");

    protected static final By disableFirstBadge =
            AppiumBy.accessibilityId("Badge image, Good Scout");

    protected static final By badgeMessage =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Create your first Needy profile and have it published to earn this badge.\")");

    protected static final By moreBtn = AppiumBy.accessibilityId("\uE821, More");
    /* ================= Navigation Steps ================= */


    @Step("Tap on more button")
    public void tapMoreButton() {
        Waits.waitForElementToBeClickable(moreBtn);
        ElementsActions.click(moreBtn);
    }

    @Step("Tap on Profile Image")
    public void tapOnProfileImage() {
        Waits.waitForElementToBeClickable(profileImageBtn);
        ElementsActions.click(profileImageBtn);
    }

    @Step("Verify My Badges title is displayed")
    public void verifyMyBadgesTitleIsDisplayed() {
        Waits.waitForElementToBeVisible(myBadgesTitle);
        assertElementDisplayed(myBadgesTitle);
    }

    @Step("Tap on View Badges List")
    public void tapOnViewBadgesList() {
        Waits.waitForElementToBeClickable(viewBadgesListBtn);
        ElementsActions.click(viewBadgesListBtn);
    }

    @Step("Verify Badges title is displayed")
    public void verifyBadgesTitleIsDisplayed() {
        Waits.waitForElementToBeVisible(badgesTitle);
        assertElementDisplayed(badgesTitle);
    }

    @Step("Tap on Badges title to go back")
    public void tapOnBadgesTitleToGoBack() {
        Waits.waitForElementToBeClickable(badgesTitle);
        ElementsActions.click(badgesTitle);
    }

    /* ================= Badge Validation ================= */

    @Step("Open enabled first badge")
    public void openEnableFirstBadge() {
        Waits.waitForElementToBeClickable(enableFirstBadge);
        ElementsActions.click(enableFirstBadge);
    }

    @Step("Verify congratulation message is displayed")
    public void verifyCongratulationMessageIsDisplayed() {
        Waits.waitForElementToBeVisible(congratulationMessage);
        assertElementDisplayed(congratulationMessage);
    }

    @Step("Verify Share Badge button is enabled")
    public void verifyShareBadgeButtonIsEnabled() {
        Waits.waitForElementToBeVisible(shareBadgesBtn);
        assertElementEnabled(shareBadgesBtn);
    }

    @Step("Scroll to disabled first badge")
    public void scrollToDisableFirstBadge() {
        Waits.waitForElementToBeVisible(badgesTitle);
        ElementsActions.scrollUntilElementVisible(disableFirstBadge, 5);
    }

    @Step("Open disabled first badge")
    public void openDisableFirstBadge() {
        Waits.waitForElementToBeClickable(disableFirstBadge);
        ElementsActions.click(disableFirstBadge);
    }

    @Step("Verify badge message is displayed")
    public void verifyBadgeMessageIsDisplayed() {
        Waits.waitForElementToBeVisible(badgeMessage);
        assertElementDisplayed(badgeMessage);
    }

    @Step("Verify Share Badge button does not work (badge message remains visible)")
    public void verifyShareBadgeButtonDoesNotWork() {
        Waits.waitForElementToBeVisible(badgeMessage);
        ElementsActions.click(shareBadgesBtn);
        assertElementDisplayed(badgeMessage);
    }

    /* ================= Dynamic Search ================= */

    @Step("Search for badge with name: {badge.value} and open it")
    public void searchAndOpenBadgeByName(BadgeNames badge) {

        By badgeLocator = AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Badge image, " + badge.value + "\")"
        );

        int maxScrolls = 6;

        for (int i = 0; i < maxScrolls; i++) {

            if (ElementsActions.isElementDisplayed(badgeLocator)) {
                Waits.waitForElementToBeClickable(badgeLocator);
                ElementsActions.click(badgeLocator);
                return;
            }

            ElementsActions.scrollDownSmall();
        }

        fail("Badge with name [" + badge.value + "] was NOT found after scrolling");
    }

}
