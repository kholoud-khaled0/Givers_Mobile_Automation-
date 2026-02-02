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

    // ------------------- NEW METHODS FOR COMMUNITIES ------------------- //

    @Step("Open Communities page")
    public void openCommunities() {
        ElementsActions.isDisplayed(communitiesTab);
        ElementsActions.click(communitiesTab);
    }

    @Step("Select community by index {index}")
    public void selectCommunityByIndex(int index) {
        List<WebElement> communityList = ElementsActions.findElements(communityCard);
        if (communityList.isEmpty() || communityList.size() <= index) {
            AndroidActions.scrollToElement(communityCard);
            communityList = ElementsActions.findElements(communityCard);
        }

        if (!communityList.isEmpty() && communityList.size() > index) {
            communityList.get(index).click();
        } else {
            throw new AssertionError("No community found at index: " + index);
        }
    }

    @Step("Verify community exists in favorites by index {index}")
    public void verifyCommunityExistsByIndex(int index) {
        ElementsActions.click(communitiesTab);
        List<WebElement> communities = ElementsActions.findElements(communityCard);
        if (communities.isEmpty()) {
            AndroidActions.scrollToElement(communityCard);
            communities = ElementsActions.findElements(communityCard);
        }

        if (communities.isEmpty() || index >= communities.size()) {
            throw new AssertionError("Community not found in favorites at index: " + index);
        }
    }

    // ------------------- NEW METHODS FOR GIVERS ------------------- //

    @Step("Open Givers tab")
    public void openGiversTab() {
        ElementsActions.isDisplayed(giversTab);
        ElementsActions.click(giversTab);
    }

    @Step("Select giver by index {index}")
    public void selectGiverByIndex(int index) {
        List<WebElement> giverList = ElementsActions.findElements(giverCard);
        if (giverList.isEmpty() || giverList.size() <= index) {
            AndroidActions.scrollToElement(giverCard);
            giverList = ElementsActions.findElements(giverCard);
        }

        if (!giverList.isEmpty() && giverList.size() > index) {
            giverList.get(index).click();
        } else {
            throw new AssertionError("No giver found at index: " + index);
        }
    }

    @Step("Verify giver exists in favorites by index {index}")
    public void verifyGiverExistsByIndex(int index) {
        List<WebElement> giverList = ElementsActions.findElements(giverCard);
        if (giverList.isEmpty() || index >= giverList.size()) {
            AndroidActions.scrollToElement(giverCard);
            giverList = ElementsActions.findElements(giverCard);
        }

        if (giverList.isEmpty() || index >= giverList.size()) {
            throw new AssertionError("Giver not found in favorites at index: " + index);
        }
    }
    @Step("Scroll then click Join as NGO")
    public void scrollToJoinAsNGOAndClick() {
        scrollAndClickJoinAsNGO();
    }

    @Step("Ensure on Join as NGO page")
    public void verifyOnJoinAsNGOPage() {
        ElementsActions.isDisplayed(joinAsNGOButton);
    }

    @Step("Open Suggest Improvement and verify page")
    public void openAndVerifySuggestImprovement() {
        openSuggestImprovement();
        verifyOnSuggestImprovementPage();
    }

    @Step("Enter suggestion text and upload document")
    public void enterFeedbackAndAttachFile() {
        enterImprovementText();
        attachReportFile();
    }

    @Step("Submit feedback and verify success")
    public void submitFeedbackAndVerify() {
        verifyAttachmentIsVisible();
        submitImprovement();
        verifyImprovementSuccess();
    }
    @Step("Open Report a Bug and verify page")
    public void openAndVerifyReportBug() {
        openReportBug();
        verifyOnReportBugPage();
    }

    @Step("Enter bug description and upload document")
    public void enterBugReportAndAttachFile() {
        enterBugDescription();
        attachBugReportFile();
    }

    @Step("Submit bug report and verify success")
    public void submitBugReportAndVerify() {
        verifyAttachmentIsVisible();
        submitBugReport();
        verifyBugReportSuccess();
    }
    @Step("Open About Us and verify page loaded dynamically")
    public void openAndVerifyAboutUsPage() {
        openAboutUs();
        verifyAboutUsPageOpened();
        scrollThroughAboutUsPage();
    }
    // ------------------- Terms & Conditions Flow ------------------- //
    @Step("Open and verify Terms & Conditions page")
    public void openAndVerifyTermsConditionsPage() {
        openTermsConditions();
        verifyPageHasDynamicContent("Terms & Conditions");
        scrollThroughPage();
    }

    // ------------------- Privacy Policy Flow ------------------- //
    @Step("Open and verify Privacy Policy page")
    public void openAndVerifyPrivacyPolicyPage() {
        openPrivacyPolicy();
        verifyPageHasDynamicContent("Privacy Policy");
        scrollThroughPage();
    }

    // ------------------- Community Guidelines Flow ------------------- //
    @Step("Open and verify Community Guidelines page")
    public void openAndVerifyCommunityGuidelinesPage() {
        openCommunityGuidelines();
        verifyPageHasDynamicContent("Community Guidelines");
        scrollThroughPage();
    }

    // ------------------- FAQs Flow ------------------- //
    @Step("Open and verify FAQs page")
    public void openAndVerifyFAQsPage() {
        openFAQs();
        verifyPageHasDynamicContent("FAQs");
        scrollThroughPage();
    }
    @Step("Open and change language to Arabic then back to English")
    public void changeLanguageAndVerifyFlow() {
        openChangeLanguageMenu();
        selectArabicAndVerify();
        selectEnglishAndVerify();
    }

    @Step("Open Change Language menu from More section")
    public void openChangeLanguageMenu() {
        ElementsActions.scrollToElement(changeLanguageOption);
        ElementsActions.click(changeLanguageOption);
    }

    @Step("Select Arabic language and verify UI updated")
    public void selectArabicAndVerify() {
        ElementsActions.click(arabicLanguageOption);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!ElementsActions.isDisplayed(changeLanguageArabicText)) {
            throw new AssertionError("Language did not change to Arabic.");
        }

        System.out.println("✅ Language successfully changed to Arabic.");
    }

    @Step("Select English language and verify UI updated")
    public void selectEnglishAndVerify() {
        ElementsActions.scrollToElement(changeLanguageArabicText);
        ElementsActions.click(changeLanguageArabicText); // open menu again in Arabic
        ElementsActions.click(englishLanguageInArabicOption);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!ElementsActions.isDisplayed(changeLanguageOption)) {
            throw new AssertionError("Language did not change back to English.");
        }

        System.out.println("✅ Language successfully changed back to English.");
    }

}
