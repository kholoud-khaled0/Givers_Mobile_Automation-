package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.appium.ElementsActions;

import java.util.List;

/**
 * Base class for Givers Screen functionality.
 * Contains locators and reusable actions for both Android & iOS implementations.
 */
public abstract class GiversScreen {

    // ------------------- Locators ------------------- //

    // Needy section (top-level)
    protected static final By needySection =
            AppiumBy.androidUIAutomator("new UiSelector().description(\", Needy\")");

    // First needy item in the list (index 0)
    protected static final By firstNeedyItem =
            AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\", Needy\").instance(0)");

    // Buttons inside needy details
    protected static final By needyDetailsBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Details\")");

    protected static final By addToFavoritesBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\")");
    protected static final By removeToFavoritesBtn =
            AppiumBy.accessibilityId("Remove from favorites");

    protected static final By backBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\").instance(0)");

    protected static final By moreBtn =
            AppiumBy.accessibilityId("\uE821, More");

    protected static final By myFavoritesBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"My Favorites\")");

    protected static final By myFavoritesScreenTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"My Favorites\")");

    // ------------------- Common Actions ------------------- //

    @Step("Open Needy section")
    public void openNeedySection() {
        ElementsActions.click(needySection);
    }

    @Step("Select first needy from the list")
    public void selectFirstNeedy() {
        ElementsActions.click(firstNeedyItem);
    }

    @Step("Open needy details")
    public void openDetails() {
        ElementsActions.click(needyDetailsBtn);
    }

    @Step("Add to favorites")
    public void addToFavorites() {
        ElementsActions.click(addToFavoritesBtn);
    }
    @Step("Remove to favorites")
    public void removeToFavorites() {
        ElementsActions.click(removeToFavoritesBtn);
    }

    @Step("Remove from favorites by index")
    public void removeFromFavoritesByIndex(int index) {
        List<org.openqa.selenium.WebElement> removeBtns = ElementsActions.findElements(addToFavoritesBtn);
        if (!removeBtns.isEmpty() && removeBtns.size() > index) {
            removeBtns.get(index).click();
        }
    }

    @Step("Go back")
    public void goBack() {
        ElementsActions.click(backBtn);
    }

    @Step("Open More menu")
    public void openMoreMenu() {
        ElementsActions.click(moreBtn);
    }

    @Step("Open My Favorites screen")
    public void openMyFavorites() {
        ElementsActions.click(myFavoritesBtn);
    }

    @Step("Verify screen title is displayed: {title}")
    public void verifyScreenTitle(String title) {
        By titleLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"" + title + "\")");
        if (!ElementsActions.isDisplayed(titleLocator)) {
            throw new AssertionError("Screen title not displayed: " + title);
        }
    }

    @Step("Verify message contains text: {text}")
    public void verifyMessageContains(String text) {
        By msgLocator = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"" + text + "\")");
        if (!ElementsActions.isDisplayed(msgLocator)) {
            throw new AssertionError("Message not displayed: " + text);
        }
    }
}
