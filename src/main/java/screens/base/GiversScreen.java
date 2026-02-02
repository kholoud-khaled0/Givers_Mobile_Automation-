package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.appium.ElementsActions;
import utils.appium.Waits;

import java.util.List;
import java.util.Random;

/**
 * Base class for Givers Screen functionality.
 * Contains locators and reusable actions for both Android & iOS implementations.
 */
public abstract class GiversScreen {

    // ------------------- Locators ------------------- //

    // Needy section
    protected static final By needySection =
            AppiumBy.androidUIAutomator("new UiSelector().description(\", Needy\")");

    protected static final By firstNeedyItem =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(24)");

    protected static final By needyDetailsBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Details\")");

    // Communities
    protected static final By communitiesTab =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Communities\")");

    protected static final By communityCard =
            AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Created by\")");

    // ------------------- NEW: Givers ------------------- //
    protected static final By giversTab =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Givers\")");

    protected static final By giverCard =
            AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Supported\").instance(0)");

    // Favorite buttons
    protected static final By addToFavoritesBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"\uE806\")");

    protected static final By removeToFavoritesBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Remove from favorites\")");

    // Navigation
    protected static final By backBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\").instance(0)");

    protected static final By moreBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"\uE821, More\")");

    protected static final By myFavoritesBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"My Favorites\")");

    protected static final By myFavoritesScreenTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"My Favorites\")");
    protected static final By joinAsNGOButton =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Join as NGO\")");
    protected static final By nameOfNGOField =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Name of the NGO\")");
    protected static final By contactPersonField =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Name of the NGO contact person\")");
    protected static final By emailField =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Please Enter Your Email\")");
    protected static final By phoneField =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Enter your phone number\")");
    protected static final By countryCodeField =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"+20\")");
    protected static final By submitBtn =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Submit\")");
    protected static final By successRequestMsg =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"You request to join as an NGO was successfully submitted\")");
    // ------------------- Suggest Improvement Flow ------------------- //

    protected static final By suggestImprovementOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Suggest Improvement\")");

    protected static final By suggestImprovementTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Have an idea to make our app better? Share your brilliant suggestion with us, we’re all ears!\")");

    protected static final By improvementInputField =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");

    protected static final By filePickerTrigger =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"file-picker-trigger\")");

    protected static final By launchDocumentPicker =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"launch-document-picker\")");

    protected static final By documentsOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Documents\")");

    protected static final By firstDocumentItem =
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.documentsui:id/icon_thumb\").instance(0)");

    protected static final By submitButton =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Submit\")");

    protected static final By successMsg =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Report submitted successfully!\")");
    // ------------------- Report a Bug Flow ------------------- //

    protected static final By reportBugOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Report a Bug\")");

    protected static final By reportBugTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Found a bug? We knew you’d have a keen eye! Let us know what happened, any error messages, and steps to make it happen again and kill it for good!\")");

    protected static final By reportBugInputField =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");

    protected static final By reportBugSubmitSuccessMsg =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Report submitted successfully!\")");
    // ------------------- About Us Flow ------------------- //

    protected static final By aboutUsOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"About Us\")");

    protected static final By aboutUsRoot =
            AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)");

    protected static final By allTextViews =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")");
    protected static final By termsConditionsOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Terms & Conditions\")");
    protected static final By privacyPolicyOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Privacy Policy\")");
    protected static final By communityGuidelinesOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Community Guidelines\")");
    protected static final By faqsOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"FAQs\")");
    protected static final By changeLanguageOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Change Language\")");

    protected static final By arabicLanguageOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Arabic\")");

    protected static final By englishLanguageOption =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"English\")");

    protected static final By changeLanguageArabicText =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"تغيير اللغة\")");
    protected static final By englishLanguageInArabicOption =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"الإنجليزية\")");

    // ------------------- Common Actions ------------------- //

    @Step("Open Needy section")
    public void openNeedySection() {
        ElementsActions.click(needySection);
    }

    @Step("Select first needy from the list")
    public void selectFirstNeedy() {
        ElementsActions.click(firstNeedyItem);
    }

    @Step("Add to favorites")
    public void addToFavorites() {
        ElementsActions.click(addToFavoritesBtn);
    }

    @Step("Remove from favorites")
    public void removeToFavorites() {
        ElementsActions.click(removeToFavoritesBtn);
    }

    @Step("Remove from favorites by index {index}")
    public void removeFromFavoritesByIndex(int index) {
        List<org.openqa.selenium.WebElement> removeBtns = ElementsActions.findElements(removeToFavoritesBtn);
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
            throw new AssertionError("Message not displayed or missing text: " + text);
        }
    }
    // ------------------- Join as NGO Flow ------------------- //

    @Step("Scroll to and click Join as NGO")
    public void scrollAndClickJoinAsNGO() {
        ElementsActions.scrollToElement(joinAsNGOButton);
        ElementsActions.click(joinAsNGOButton);
    }

    @Step("Enter NGO data: name={ngoName}, contact={contact}, email={email}, phone={phone}")
    public void enterNGOData(String ngoName, String contact, String email, String phone) {
        ElementsActions.setValue(nameOfNGOField, ngoName);
        ElementsActions.setValue(contactPersonField, contact);
        ElementsActions.setValue(emailField, email);
        ElementsActions.setValue(phoneField, phone);
    }

    @Step("Click Submit for NGO request")
    public void clickSubmitNGORequest() {
        ElementsActions.click(submitBtn);
    }

    @Step("Verify NGO request success message displayed")
    public void verifyNGORequestSuccess() {
        if (!ElementsActions.isDisplayed(successRequestMsg)) {
            throw new AssertionError("Success message for NGO join request not shown");
        }
    }

    // ------------------- Suggest Improvement ------------------- //

    @Step("Open Suggest Improvement screen from More menu")
    public void openSuggestImprovement() {
        ElementsActions.click(moreBtn);
        ElementsActions.scrollToElement(suggestImprovementOption);
        ElementsActions.click(suggestImprovementOption);
    }

    @Step("Verify Suggest Improvement page is displayed")
    public void verifyOnSuggestImprovementPage() {
        if (!ElementsActions.isDisplayed(suggestImprovementTitle)) {
            throw new AssertionError(" Suggest Improvement page not opened correctly.");
        }
    }

    @Step("Enter random improvement text")
    public void enterImprovementText() {
        String randomText = "Feedback_" + generateRandomString(8);
        ElementsActions.setValue(improvementInputField, randomText);
    }

    @Step("Attach report file dynamically")
    public void attachReportFile() {
        ElementsActions.click(filePickerTrigger);
        ElementsActions.click(launchDocumentPicker);
        ElementsActions.click(documentsOption);
        ElementsActions.click(firstDocumentItem);
    }

    @Step("Verify attached report is visible")
    public void verifyAttachmentIsVisible() {
        By reportFileLocator = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"report_attachment_\")");
        if (!ElementsActions.isDisplayed(reportFileLocator)) {
            throw new AssertionError(" Report attachment not visible after upload.");
        }
    }
    @Step("Submit suggestion")
    public void submitImprovement() {
        ElementsActions.isDisplayed(submitButton);
        Waits.waitForElementToBeClickable(submitButton);
        ElementsActions.click(submitButton);
    }

    @Step("Verify success message displayed")
    public void verifyImprovementSuccess() {
        if (!ElementsActions.isDisplayed(successMsg)) {
            throw new AssertionError(" Success message not shown after submitting report.");
        }
    }

    @Step("Open Report a Bug screen from More menu")
    public void openReportBug() {
        ElementsActions.click(moreBtn);
        ElementsActions.scrollToElement(reportBugOption);
        ElementsActions.click(reportBugOption);
    }

    @Step("Verify Report a Bug page is displayed")
    public void verifyOnReportBugPage() {
        if (!ElementsActions.isDisplayed(reportBugTitle)) {
            throw new AssertionError("Report a Bug page not opened correctly.");
        }
    }

    @Step("Enter random bug description")
    public void enterBugDescription() {
        String randomText = "BugReport_" + generateRandomString(8);
        ElementsActions.setValue(reportBugInputField, randomText);
    }

    @Step("Attach bug report document dynamically")
    public void attachBugReportFile() {
        ElementsActions.click(filePickerTrigger);
        ElementsActions.click(launchDocumentPicker);
        ElementsActions.click(documentsOption);
        ElementsActions.click(firstDocumentItem);
    }

    @Step("Submit bug report")
    public void submitBugReport() {
        ElementsActions.isDisplayed(submitButton);
        Waits.waitForElementToBeClickable(submitButton);
        ElementsActions.click(submitButton);
    }

    @Step("Verify bug report submitted successfully")
    public void verifyBugReportSuccess() {
        if (!ElementsActions.isDisplayed(reportBugSubmitSuccessMsg)) {
            throw new AssertionError("Success message not shown after submitting bug report.");
        }
    }
    @Step("Open About Us page")
    public void openAboutUs() {
        ElementsActions.scrollToElement(aboutUsOption);
        ElementsActions.click(aboutUsOption);
    }

    @Step("Verify About Us page opened dynamically")
    public void verifyAboutUsPageOpened() {
        if (!ElementsActions.isDisplayed(aboutUsOption)) {
            throw new AssertionError("About Us page did not open or is not scrollable.");
        }


        List<WebElement> texts = ElementsActions.findElements(allTextViews);
        if (texts.size() < 5) {
            throw new AssertionError("About Us page seems empty or missing key sections.");
        }

        System.out.println(" About Us page opened successfully with " + texts.size() + " text elements.");
    }

    @Step("Scroll through About Us page")
    public void scrollThroughAboutUsPage() {
        ElementsActions.scrollToElement(allTextViews);
        ElementsActions.scrollToBottom();
    }
    @Step("Open Terms & Conditions")
    public void openTermsConditions() {
        ElementsActions.scrollToElement(termsConditionsOption);
        ElementsActions.click(termsConditionsOption);
    }

    @Step("Open Privacy Policy")
    public void openPrivacyPolicy() {
        ElementsActions.scrollToElement(privacyPolicyOption);
        ElementsActions.click(privacyPolicyOption);
    }

    @Step("Open Community Guidelines")
    public void openCommunityGuidelines() {
        ElementsActions.scrollToElement(communityGuidelinesOption);
        ElementsActions.click(communityGuidelinesOption);
    }

    @Step("Open FAQs")
    public void openFAQs() {
        ElementsActions.scrollToElement(faqsOption);
        ElementsActions.click(faqsOption);
    }

    @Step("Verify {pageName} page loaded dynamically")
    public void verifyPageHasDynamicContent(String pageName) {
        if (!ElementsActions.isDisplayed(aboutUsRoot)) {
            throw new AssertionError(pageName + " page is not scrollable or failed to open.");
        }

        List<WebElement> textElements = ElementsActions.findElements(allTextViews);
        if (textElements.size() < 5) {
            throw new AssertionError(pageName + " page seems empty or missing content.");
        }

        System.out.println("✅ " + pageName + " loaded successfully with " + textElements.size() + " text items.");
    }

    @Step("Scroll through current page")
    public void scrollThroughPage() {
        ElementsActions.scrollToBottom();
    }
    @Step("Open Change Language menu")
    public void openChangeLanguageMenu() {
        ElementsActions.scrollToElement(changeLanguageOption);
        ElementsActions.click(changeLanguageOption);
    }

    @Step("Select Arabic language")
    public void selectArabicLanguage() {
        ElementsActions.click(arabicLanguageOption);
    }

    @Step("Select English language")
    public void selectEnglishLanguage() {
        ElementsActions.click(englishLanguageOption);
    }

    // ------------------- 🔹 Utility Method 🔹 ------------------- //
    public static String generateRandomString(int length) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        return sb.toString();
    }
}