package screens.android;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import screens.base.GiversScreen;
import utils.android.AndroidActions;
import utils.appium.ElementsActions;

import java.util.List;

/**
 * Android implementation for GiversScreen flows
 */
public class AndroidGiversScreen extends GiversScreen {

    @Step("Open Needy section (scroll if not visible)")
    @Override
    public void openNeedySection() {
        ElementsActions.isDisplayed(needySection);
        super.openNeedySection();
    }

    @Step("Ensure first needy is visible with clicking")
    public void ensureFirstNeedyVisible() {
        ElementsActions.isDisplayed(firstNeedyItem);
        ElementsActions.click(firstNeedyItem);
    }

    @Step("Open needy details")
    @Override
    public void openDetails() {
        ElementsActions.isDisplayed(needyDetailsBtn);
        super.openDetails();
    }

    @Step("Add to favorites")
    @Override
    public void addToFavorites() {
        ElementsActions.isDisplayed(addToFavoritesBtn);
        super.addToFavorites();
    }

    @Step("Go back")
    @Override
    public void goBack() {
        super.goBack();
    }

    @Step("Open More menu")
    @Override
    public void openMoreMenu() {
        super.openMoreMenu();
    }

    @Step("Open My Favorites screen")
    @Override
    public void openMyFavorites() {
        ElementsActions.isDisplayed(myFavoritesBtn);
        super.openMyFavorites();
    }

    @Step("Remove first needy from favorites after ensuring it's visible in My Favorites")
    @Override
    public void removeFromFavoritesByIndex(int index) {

        if (!ElementsActions.isDisplayed(myFavoritesScreenTitle)) {
            throw new AssertionError("Not on My Favorites screen!");
        }

        // تأكد ان firstNeedyItem موجود (scroll إذا لزم)
        if (!ElementsActions.isDisplayed(firstNeedyItem)) {
            AndroidActions.scrollToElement(firstNeedyItem);
        }

        List<WebElement> removeBtns = ElementsActions.findElements(removeToFavoritesBtn);

        if ((removeBtns == null || removeBtns.isEmpty() || removeBtns.size() <= index)) {
            AndroidActions.scrollToElement(removeToFavoritesBtn);
            removeBtns = ElementsActions.findElements(removeToFavoritesBtn);
        }

        if (!removeBtns.isEmpty() && removeBtns.size() > index) {
            removeBtns.get(index).click();
        } else {
            System.out.println("No favorites found to remove at index: " + index);
        }
    }
}