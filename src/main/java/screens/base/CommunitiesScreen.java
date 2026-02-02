package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.appium.ElementsActions;
import utils.appium.Waits;
import utils.common.CommunityStats;
import utils.common.RandomNeedyDataGenerator;

import java.util.NoSuchElementException;

import static screens.base.LoginScreen.*;
import static screens.base.PersonalInformationScreen.cropBtn;
import static utils.android.OtpHelper.enterOtp;
import static utils.appium.driverManager.DriverManager.getDriver;

public abstract class CommunitiesScreen {

    // ========================= LOCATORS ========================= //

    protected static final By CommunityBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Communities\")");

    protected static final By joinCommunityBtn =
            AppiumBy.accessibilityId("Join Community");

    protected static final By exploreBtn =
            AppiumBy.accessibilityId("Explore");

    protected static final By myCommunitiesBtn =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionContains(\"My Communities\")"
            );

    protected static final By CommunitiesBtn =
            AppiumBy.accessibilityId("Communities");

    protected static final By GiversBtn =
            AppiumBy.accessibilityId("Givers");

    protected static final By searchCommunitiesField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Search communities\")");

    // Inside community
    protected static final By joinCommunityBtnInside =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Join\")");

    protected static final By rankingTab =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Ranking\")");

    // ===== Official Community tabs =====
    protected static final By needyCreatedItem =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Needy Created\")");

    protected static final By needyCreatedTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Created Needies\")");

    protected static final By ngoMembersItem =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"NGO Members\")");

    protected static final By ngoMembersTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"NGO Members\")");

    protected static final By followersItem =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Followers\")");

    protected static final By followersTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Followers\")");

    protected static final By backBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"\")");


    // ========================= DYNAMIC DESCRIPTIONS ========================= //

    protected By totalDonationsDesc(String value) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + value + ", Total donations\")"
        );
    }

    protected By supportedNeedyDesc(String value) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + value + ", Needy supported\")"
        );
    }
    // Join Community Flow
    protected static final By joinNowBtn =
            AppiumBy.accessibilityId("Join Now!");

    protected static final By joinCommunityTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Join Community\")");

    protected static final By joinEmailField =
            AppiumBy.className("android.widget.EditText");

    protected static final By joinSubmitBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Submit\")");

    protected static final By joinSuccessMessage =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Congratulations! You’re now a member in this community.\")"
            );
    // ===== Post actions =====
    protected static final By postThreeDotsBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\uE817\").instance(1)");

    protected static final By postThreeDots0Btn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\uE817\").instance(0)");


    protected static final By editPostBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"Edit post\")");

    protected static final By deletePostBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"Delete post\")");

    // Edit post
    protected static final By postEditInputField =
            AppiumBy.className("android.widget.EditText");

    protected static final By deleteImageBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\")");

    protected static final By confirmDeleteImageBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete\")");

    protected static final By savePostBtn =
            AppiumBy.accessibilityId("Save");

    // Toast / Messages
    protected static final By postUpdatedMsg =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Post updated successfully\")"
            );

    protected static final By postDeletedMsg =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Post deleted successfully\")"
            );

    // Confirm delete post
    protected static final By confirmDeletePostBtn =
            AppiumBy.accessibilityId("Confirm button");

    protected static final By moderatorTitle =
            AppiumBy.accessibilityId("Moderator");

    protected static final By threeDotsModeratorCommunity =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"\uE817\").instance(0)"
            );
    protected static final By editCommunityDetailsBtn =
            AppiumBy.accessibilityId("Edit Community Details");
    protected static final By addOrRemoveVerifyingMemberBtn =
            AppiumBy.accessibilityId("Add/Remove Verifying Member");
    protected static final By manageNeedyProfilesBtn =
            AppiumBy.accessibilityId("Manage Needy Profiles");
    protected static final By removePhotoBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Remove Photo\")");
    protected static final By uploadPhotoMsg =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Please upload a photo for the community\")"
            );
    protected static final By uploadPhotoBtn =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.view.ViewGroup\").instance(18)"
            );

    protected static final By saveUpdatesBtn =
            AppiumBy.accessibilityId("Save Updates");

    protected static final By PeopleYouMayKnowTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"People you may know\")");
    protected static final By viewMembersBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"View Members\")");
    protected static final By searchAboutGiversField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Search Givers by name or Giver’s ID\")");
    protected static final By inviteAsAVerifyingMemberBtn =
            AppiumBy.accessibilityId("Invite as a verifying member");

    protected static final By removeMemberBtn =
            AppiumBy.accessibilityId("Remove member");
    protected static final By confirmRemoveBtn =
            AppiumBy.accessibilityId("Confirm button");
    protected static final By removeSucMsg =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Member successfully removed\")");
    protected static final By rejectedProfilesTab =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Rejected Profiles\")"
            );

    protected static final By rejectionReasonLabel =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Rejection Reason\").instance(0)"
            );
    protected static final By approvedProfilesTab =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Approved Profiles\")"
            );

    protected static final By monthlyTargetText =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Monthly target\")"
            );
    protected static final By pendingApprovalStatus =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"Pending Approval\").instance(0)"
            );

    protected static final By giverNameLabel =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Giver name\").instance(0)"
            );

    protected static final By creationDateLabel =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Creation date\").instance(0)"
            );

    protected static final By needyIdLabel =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Needy ID\").instance(0)"
            );
    protected static final By inProgressTab =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"In progress\")");
    protected static final By draftTab =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Draft\")");
    protected static final By completeTab =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete\")");
    protected static final By logoutBtn =
            AppiumBy.accessibilityId("Logout");
    protected static final By notificationBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"\uE832\")");
    protected static final By ngoInvitation =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"NGO Invitation\")");
    protected static final By acceptInvitation =
            AppiumBy.accessibilityId("Accept");
    protected static final By rejectInvitation =
            AppiumBy.accessibilityId("Reject");
    protected static final By backToCommunitiesBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Back to communities\")");

// ===== Official Community – Inside Community =====

    // Needy Created
    protected By needyCreatedDesc(String value) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + value + ", Needy Created\")"
        );
    }

    // Followers
    protected By followersDesc(String value) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + value + ", Followers\")"
        );
    }

    // Posts section title
    protected static final By postsByMembersTitle =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Posts by Community Members\")"
            );

    // Follow / Unfollow
    protected static final By followBtn =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"Follow\")"
            );

    protected static final By unfollowBtn =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"Unfollow\")"
            );

    // New Post
    protected static final By newPostBtn =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\", New post\")"
            );

    // Post input
    protected static final By postInputField =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"How will you help a needy today?\")"
            );

    // Post submit
    protected static final By postSubmitBtn =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"Post\")"
            );
    // Like & Comment buttons
    protected static final By likeBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\", Like\")");

    protected static final By commentBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\", Comment\")");

    // Three dots (post & comment – same icon, different context)
    protected static final By threeDotsBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\").instance(0)");

    // Comments screen
    protected static final By commentsTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Comments\")");

    protected static final By writeCommentField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Write a Comment\")");

    protected static final By sendCommentBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"\")");

    // Comment actions
    protected static final By editCommentBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"Edit Comment\")");

    protected static final By deleteCommentBtn =

            AppiumBy.androidUIAutomator("new UiSelector().description(\"Delete Comment\")");

    protected static final By updateCommentBtn =
            AppiumBy.accessibilityId("Update");

    protected static final By confirmDeleteBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Confirm\")");

    // Toast / messages
    protected static final By commentUpdatedMsg =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Comment updated successfully\")");

    protected static final By commentDeletedMsg =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Comment deleted successfully\")");

    protected static final By otpInput =
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"code-input\")");

    protected static final By searchInput =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Search communities\")");

    // Search result by exact community name
    protected By searchResultByName(String communityName) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + communityName + "\")"
        );
    }

    // Any community item (used to assert only one result)
    protected static final By anyCommunityResult =
            AppiumBy.className("android.widget.TextView");

    protected static final By invalidCommunityMsg =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Please enter a valid community name. Special characters are not allowed.\")"
            );

    // ========================= NAVIGATION ========================= //

    @Step("Open Communities tab")
    public void openCommunities() {
        ElementsActions.click(CommunityBtn);
    }

    @Step("Search about Communities ")
    public void setSearchInputCommunities(String communityName) {
        ElementsActions.setValue(searchInput,communityName);
    }
    // ========================= SCROLL ========================= //
    @Step("Tap Sign In button")
    public void tapSignInWithoutSkipButton() {
        ElementsActions.click(signInBtn);
    }

    @Step("Check if in Login Screen")
    public boolean isInLoginScreen() {
        return ElementsActions.isDisplayed(emailField)
                && ElementsActions.isDisplayed(passwordField)
                && ElementsActions.isDisplayed(loginBtn);
    }
    @Step("Set email: {email}")
    public void setEmail(String secondEmail) {
        ElementsActions.setValue(emailField, secondEmail);
    }

    @Step("Set password: {password}")
    public void setPassword(String secondPassword) {
        ElementsActions.setValue(passwordField, secondPassword);
    }

    @Step("Perform login with email and password")
    public void performLogin(String secondEmail, String secondPassword) {
        setEmail(secondEmail);
        setPassword(secondPassword);
        ElementsActions.click(loginBtn);
    }


    @Step("Scroll to community by name: {communityName}")
    protected void scrollToCommunity(String communityName) {
        try {
            getDriver().findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))" +
                                    ".scrollIntoView(new UiSelector().text(\"" + communityName + "\"))"
                    )
            );
        } catch (Exception e) {
            throw new NoSuchElementException(
                    "Community not found: " + communityName
            );
        }
    }


    // ========================= COMMUNITY CARD ========================= //

    protected WebElement getCommunityCard(String communityName) {
        return getDriver().findElement(
                AppiumBy.xpath(
                        "//android.widget.TextView[@text='" + communityName + "']" +
                                "/ancestor::android.view.ViewGroup"
                )
        );
    }

    // ========================= COMMUNITY TYPE ========================= //

    protected boolean isOfficialCommunity(WebElement card) {
        return !card.findElements(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Official Community\")")
        ).isEmpty();
    }

    protected boolean isCreatedByGivers(WebElement card) {
        return !card.findElements(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Created by Givers\")")
        ).isEmpty();
    }

    // ========================= READ VALUES (LIST) ========================= //

    protected String readValueNextToLabel(WebElement card, String labelText) {
        try {
            return card.findElement(
                    By.xpath(
                            ".//android.widget.TextView[@text='" + labelText + "']" +
                                    "/following-sibling::android.widget.TextView"
                    )
            ).getText();
        } catch (Exception e) {
            throw new NoSuchElementException("Value not found for label: " + labelText);
        }
    }

    // ========================= READ STATS FROM LIST ========================= //

    @Step("Read community statistics from list for: {communityName}")
    public CommunityStats readCommunityStats(String communityName) {

        scrollToCommunity(communityName);
        WebElement card = getCommunityCard(communityName);

        CommunityStats stats = new CommunityStats();

        if (isOfficialCommunity(card)) {

            String createdNeedy = readValueNextToLabel(card, "Created Needy");
            stats.setCommunityType("Official Community");
            stats.setCreatedNeedyCount(createdNeedy);

            logCommunityStat("Community Type", "Official Community");
            logCommunityStat("Created Needy (list)", createdNeedy);

        } else if (isCreatedByGivers(card)) {

            String supportedNeedy = readValueNextToLabel(card, "Supported Needy");
            String donations = readValueNextToLabel(card, "Donations");

            stats.setCommunityType("Created by Givers");
            stats.setSupportedNeedyCount(supportedNeedy);
            stats.setDonationsAmount(donations);

            logCommunityStat("Community Type", "Created by Givers");
            logCommunityStat("Supported Needy (list)", supportedNeedy);
            logCommunityStat("Donations (list)", donations);

        } else {
            throw new IllegalStateException("Unknown community type for: " + communityName);
        }

        return stats;
    }

    // ========================= ALLURE LOG ========================= //

    @Step("{label}: {value}")
    protected void logCommunityStat(String label, String value) {
        // Allure visualization only
    }

    // ========================= OPEN COMMUNITY ========================= //

    @Step("Open community by name: {communityName}")
    public void openCommunity(String communityName) {
        scrollToCommunity(communityName);
        ElementsActions.click(
                AppiumBy.xpath("//android.widget.TextView[@text='" + communityName + "']")
        );
    }

    @Step("Open community by name: {communityName}")
    public void openCommunityWithoutScroll(String communityName) {
        ElementsActions.click(
                AppiumBy.xpath("//android.widget.TextView[@text='" + communityName + "']")
        );
    }

    @Step("Like post")
    protected void likePost() {
        ElementsActions.click(likeBtn);
    }
    @Step("unfollow community")
    protected void unFollowCommunity() {
        ElementsActions.click(unfollowBtn);
    }

    @Step("Open comments")
    protected void openComments() {
        ElementsActions.click(commentBtn);
        ElementsActions.isDisplayed(commentsTitle);
    }

    @Step("Add new comment")
    protected String addNewComment() {

        String commentText =
                "auto_comment_" + System.currentTimeMillis();

        ElementsActions.setValue(writeCommentField, commentText);
        ElementsActions.click(sendCommentBtn);

        // verify comment appears
        ElementsActions.isDisplayed(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"" + commentText + "\")"
                )
        );

        return commentText;
    }

    @Step("Edit comment")
    protected String editComment(String oldText) {

        String updatedText =
                "edited_" + System.currentTimeMillis();

        // 1️⃣ Open comment menu
        ElementsActions.click(threeDotsBtn);
        ElementsActions.click(editCommentBtn);

        // 2️⃣ Get editable field (REAL input)
        By editCommentField =
                AppiumBy.className("android.widget.EditText");

        // 3️⃣ Clear & set new value
        ElementsActions.clear(editCommentField);
        ElementsActions.setValue(editCommentField, updatedText);

        // 4️⃣ Update
        ElementsActions.click(updateCommentBtn);

        // 5️⃣ Verify success
        ElementsActions.isDisplayed(commentUpdatedMsg);

        return updatedText;
    }

    @Step("Open section and verify title")
    protected void openSectionAndVerify(By sectionBtn, By title) {
        ElementsActions.click(sectionBtn);
        ElementsActions.isDisplayed(title);
        ElementsActions.click(backBtn);
    }


    @Step("Delete comment")
    protected void deleteComment() {

        ElementsActions.click(threeDotsBtn);
        ElementsActions.click(deleteCommentBtn);
        ElementsActions.click(confirmDeleteBtn);

        ElementsActions.isDisplayed(commentDeletedMsg);
    }

    @Step("Close comments screen")
    protected void closeCommentsScreen() {
        ElementsActions.click(AppiumBy.xpath(
                "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"));
    }
    @Step("Click on post three dots (auto-detect)")
    protected void clickOnPostThreeDots() {

        if (ElementsActions.isDisplayed(postThreeDots0Btn)) {
            ElementsActions.click(postThreeDots0Btn);
            return;
        }

        if (ElementsActions.isDisplayed(postThreeDotsBtn)) {
            ElementsActions.click(postThreeDotsBtn);
            return;
        }

        throw new AssertionError("No post three dots button found");
    }

    @Step("Capture photo using Community camera flow")
    protected void captureCommunityPhoto() {

        // 1️⃣ Open camera container (ViewGroup instance 21)
        By cameraContainer1 =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.view.ViewGroup\").instance(21)"
                );
        ElementsActions.click(cameraContainer1);

        // 2️⃣ Launch camera
        By launchCameraBtn =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().description(\"launch-camera\")"
                );
        ElementsActions.click(launchCameraBtn);

        // 3️⃣ Allow permission IF exists
        By permissionBtn =
                AppiumBy.id(
                        "com.android.permissioncontroller:id/permission_allow_foreground_only_button"
                );

        if (ElementsActions.isDisplayed(permissionBtn)) {
            ElementsActions.click(permissionBtn);
        }

        // 4️⃣ Shutter (take photo)
        By shutterBtn =
                AppiumBy.id("com.android.camera2:id/shutter_button");
        ElementsActions.click(shutterBtn);

        // 5️⃣ Done
        By doneBtn =
                AppiumBy.accessibilityId("Done");
        ElementsActions.click(doneBtn);
    }
    @Step("Capture photo using Community camera flow")
    protected void captureModeratorCommunityPhoto() {

        // 1️⃣ Open camera container (ViewGroup instance)
        ElementsActions.click(uploadPhotoBtn);

        // 2️⃣ Launch camera
        By launchCameraBtn =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().description(\"launch-camera\")"
                );
        ElementsActions.click(launchCameraBtn);

        // 3️⃣ Allow permission IF exists
        By permissionBtn =
                AppiumBy.id(
                        "com.android.permissioncontroller:id/permission_allow_foreground_only_button"
                );

        if (ElementsActions.isDisplayed(permissionBtn)) {
            ElementsActions.click(permissionBtn);
        }

        // 4️⃣ Shutter (take photo)
        By shutterBtn =
                AppiumBy.id("com.android.camera2:id/shutter_button");
        ElementsActions.click(shutterBtn);

        // 5️⃣ Done
        By doneBtn =
                AppiumBy.accessibilityId("Done");
        ElementsActions.click(doneBtn);
        if(ElementsActions.isDisplayed(cropBtn)) {
            ElementsActions.click(cropBtn);
        }
    }
    @Step("Delete image with retry until confirm appears")
    protected void deleteImageWithRetry() {

        boolean confirmAppeared = false;

        for (int i = 0; i < 5; i++) {
            if (ElementsActions.isDisplayed(deleteImageBtn)) {

                ElementsActions.click(deleteImageBtn);
                try {
                    Waits.waitForElementToBeVisible(confirmDeleteImageBtn);
                    confirmAppeared = true;
                    break;
                } catch (Exception ignored) {

                }
            }
        }

        if (!confirmAppeared) {
            throw new AssertionError("Confirm delete image button did not appear");
        }

        ElementsActions.click(confirmDeleteImageBtn);

        Waits.waitForElementToDisappear(deleteImageBtn, 10);
    }

    @Step("Search for community and validate result or error message")
    public void searchAndVerifyCommunityOnly(String communityName) {

        // 1️⃣ Open communities
        openCommunities();
        ElementsActions.setValue(searchInput, communityName);

        if (ElementsActions.isDisplayed(invalidCommunityMsg)) {
            logCommunityStat(
                    "Search Validation",
                    "Invalid community name error displayed as expected"
            );
            return;
        }

        // 4️⃣ Expected valid result
        By expectedResult =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"" + communityName + "\")"
                );

        try {
            Waits.waitForElementToBeVisible(expectedResult);
        } catch (Exception e) {
            throw new AssertionError(
                    "No search result and no error message appeared for: " + communityName
            );
        }

        logCommunityStat("Search Verified", communityName);
    }

    @Step("Enter OTP digit by digit into single code input")
    protected void enterOtpSafely(String otp) {

        if (otp == null || otp.isBlank()) {
            throw new IllegalArgumentException("OTP is empty");
        }

        By otpInput =
                AppiumBy.id("code-input");

        Waits.waitForElementToBeVisible(otpInput);
        ElementsActions.click(otpInput);


        for (int i = 0; i < otp.length(); i++) {

            String digit = String.valueOf(otp.charAt(i));

            ElementsActions.setValue(otpInput, digit);

            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        }
    }

    private void editPostAndDeleteImage(By threeDotsBtn) {

        ElementsActions.click(threeDotsBtn);
        ElementsActions.click(editPostBtn);

        String updatedText =
                "edited_post_" + System.currentTimeMillis();

        ElementsActions.clear(postEditInputField);
        ElementsActions.setValue(postEditInputField, updatedText);

        deleteImageWithRetry();

        ElementsActions.click(savePostBtn);

        if (ElementsActions.isDisplayed(confirmRemoveBtn)) {
            ElementsActions.click(confirmRemoveBtn);
        }

        ElementsActions.isDisplayed(postUpdatedMsg);
        logCommunityStat("Post Updated", updatedText);
    }
    private void deletePost(By threeDotsBtn) {

        ElementsActions.click(threeDotsBtn);
        ElementsActions.click(deletePostBtn);
        ElementsActions.click(confirmDeletePostBtn);

        ElementsActions.isDisplayed(postDeletedMsg);
        logCommunityStat("Post Status", "Post deleted successfully");
    }

    @Step("Delete post using three dots instance(0)")
    protected void deletePostUsingFirstDots() {
        deletePost(postThreeDots0Btn);
    }

    @Step("Delete post using three dots instance(1)")
    protected void deletePostUsingSecondDots() {
        deletePost(postThreeDotsBtn);
    }

    private void editAndDeletePostCore(
            By threeDotsBtn,
            String communityName,
            boolean shouldUnfollow,
            boolean withoutScroll
    ) {

        // Edit
        editPostAndDeleteImage(threeDotsBtn);

        // Delete
        deletePost(threeDotsBtn);

        // Reopen community
        if (withoutScroll) {
            openCommunityWithoutScroll(communityName);
        } else {
            openCommunity(communityName);
        }

        // Optional unfollow
        if (shouldUnfollow) {
            ElementsActions.click(unfollowBtn);
            ElementsActions.isDisplayed(followBtn);
            logCommunityStat("Follow Status", "User unfollowed community");
        }
    }

    // ========================= CREATED BY GIVERS SCENARIO ========================= //

    @Step("Execute Created By Givers community scenario")
    protected void executeCreatedByGiversScenario(CommunityStats stats, String otp , String communityName) {

        // Join button visible
        ElementsActions.isDisplayed(joinCommunityBtnInside);

        // Ranking visible
        ElementsActions.isDisplayed(rankingTab);

        // Verify donations
        ElementsActions.isDisplayed(
                totalDonationsDesc(stats.getDonationsAmount())
        );

        // Verify supported needy
        ElementsActions.isDisplayed(
                supportedNeedyDesc(stats.getSupportedNeedyCount())
        );

        // Read givers before join
        String giversBeforeJoin = extractNumberFromDescription("Givers");
        stats.setGiversCount(giversBeforeJoin);

        logCommunityStat("Givers before join", giversBeforeJoin);

        // Join flow
        joinCommunityUsingGeneratedEmail(otp);
        editAndDeletePostThenUnfollowUsingFirstDots(communityName);
    }

    /* ---------- FULL FLOW ---------- */

    @Step("Full comment flow (like → comment → edit → delete)")
    protected void performFullCommentFlow() {
        Waits.waitForElementToBeVisible(likeBtn);
        likePost();

        openComments();

        String originalComment = addNewComment();

//        String editedComment = editComment(originalComment);

        deleteComment();

        closeCommentsScreen();

    }

    // ========================= HELPERS ========================= //

    protected String extractNumberFromDescription(String keyword) {

        String desc =
                getDriver()
                        .findElement(
                                AppiumBy.androidUIAutomator(
                                        "new UiSelector().descriptionContains(\"" + keyword + "\")"
                                )
                        )
                        .getAttribute("content-desc");

        return desc.split(",")[0].trim();
    }
    @Step("Join community using generated email and OTP")
    protected void joinCommunityUsingGeneratedEmail(String otp) {

        // 1️⃣ Click Join
        ElementsActions.click(joinCommunityBtnInside);

        // 2️⃣ Verify Join Community screen
        ElementsActions.isDisplayed(joinCommunityTitle);

        // 3️⃣ Generate email prefix only
        String emailPrefix = RandomNeedyDataGenerator.generateEmailPrefix();
        logCommunityStat("Generated Email Prefix", emailPrefix);

        // 4️⃣ Enter email prefix
        ElementsActions.setValue(joinEmailField, emailPrefix);

        // 5️⃣ Submit
        ElementsActions.click(joinNowBtn);
        ElementsActions.click(joinNowBtn);
//        Waits.waitForElementToBeVisible(otpInput);
        enterOtp(otp);

        // 7️⃣ Verify success message
        ElementsActions.isDisplayed(joinSuccessMessage);

        logCommunityStat("Join Status", "User successfully joined the community");
    }

    @Step("Create new post with photo and perform full comment flow")
    protected void createPostWithPhotoAndComments() {

        // Verify New Post button
        ElementsActions.isDisplayed(newPostBtn);

        // Open New Post
        ElementsActions.click(newPostBtn);

        // Generate post text
        String postText =
                RandomNeedyDataGenerator.generatePostText();

        // Enter post text
        ElementsActions.setValue(postInputField, postText);

        // Capture photo
        captureCommunityPhoto();

        // Submit post
        ElementsActions.click(postSubmitBtn);

        // Verify post appears
        ElementsActions.isDisplayed(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"" + postText + "\")"
                )
        );

        logCommunityStat("New Post Created", postText);

        // Like → Comment → Delete flow
        performFullCommentFlow();
    }
    @Step("Edit post, delete image, reopen community without scroll, then unfollow (dots 1)")
    protected void editAndDeletePostThenUnfollowUsingSecondDots(String communityName) {

        editAndDeletePostCore(
                postThreeDotsBtn,
                communityName,
                false,
                true
        );
    }

    @Step("Edit post, delete image, reopen community with scroll (dots 1)")
    protected void editAndDeletePostUsingSecondDots(String communityName) {

        editAndDeletePostCore(
                postThreeDotsBtn,
                communityName,
                false,
                false
        );
    }
    @Step("Edit post, delete image, reopen community without scroll, then unfollow (dots 0)")
    protected void editAndDeletePostThenUnfollowUsingFirstDots(String communityName) {

        editAndDeletePostCore(
                postThreeDots0Btn,
                communityName,
                true,   // unfollow
                true    // without scroll
        );
    }
    @Step("Edit post, delete image, reopen community without scroll, then unfollow (dots 0)")
    protected void editAndDeletePostUsingFirstDots(String communityName) {


        editAndDeletePostCore(
                postThreeDots0Btn,
                communityName,
                false,   // unfollow
                true    // without scroll
        );
    }


    @Step("Execute Official Community scenario")
    protected void executeOfficialCommunityScenario(CommunityStats stats ,String communityName ) {

        // Verify Needy Created (same as list)
        ElementsActions.isDisplayed(
                needyCreatedDesc(stats.getCreatedNeedyCount())
        );

        // Followers BEFORE follow
        String followersBefore =
                extractNumberFromDescription("Followers");
        stats.setFollowersCount(followersBefore);

        // Follow
        ElementsActions.click(followBtn);
        ElementsActions.isDisplayed(unfollowBtn);

        // ===== Enter sections & verify titles =====
        openSectionAndVerify(needyCreatedItem, needyCreatedTitle);
        openSectionAndVerify(ngoMembersItem, ngoMembersTitle);
        openSectionAndVerify(followersItem, followersTitle);

        // ===== Posts & comments flow =====
        createPostWithPhotoAndComments();
        editAndDeletePostThenUnfollowUsingFirstDots(communityName);


        // Followers AFTER unfollow
        String followersAfter =
                extractNumberFromDescription("Followers");

        int before = Integer.parseInt(followersBefore);
        int after  = Integer.parseInt(followersAfter);

        if (after != before ) {
            throw new AssertionError(
                    "Followers count did not decrease after unfollow"
            );
        }

        logCommunityStat("Followers after unfollow", followersAfter);
    }
    @Step("Verify field '{labelText}' is read-only")
    protected void verifyFieldIsReadOnly(String labelText) {

        By fieldLocator =
                By.xpath(
                        "//android.widget.TextView[@text='" + labelText + "']" +
                                "/following-sibling::android.widget.EditText"
                );

        WebElement field = getDriver().findElement(fieldLocator);

        String beforeValue = field.getText();

        // 1️⃣ enabled = false
        if (field.isEnabled()) {
            throw new AssertionError(labelText + " field is enabled but should be read-only");
        }

        // 2️⃣ clickable = false
        if ("true".equalsIgnoreCase(field.getAttribute("clickable"))) {
            throw new AssertionError(labelText + " field is clickable but should not be");
        }

        // 3️⃣ Try to edit (safety)
        try {
            field.click();
            field.sendKeys("TEST");
        } catch (Exception ignored) {}

        String afterValue = field.getText();

        if (!beforeValue.equals(afterValue)) {
            throw new AssertionError(
                    labelText + " value changed but should be read-only"
            );
        }

        logCommunityStat(labelText, "Verified as read-only");
    }
    @Step("Edit field '{labelText}' with new value")
    protected String editEditableField(String labelText) {

        By fieldLocator =
                By.xpath(
                        "//android.widget.TextView[@text='" + labelText + "']" +
                                "/following-sibling::android.widget.EditText"
                );

        WebElement field = getDriver().findElement(fieldLocator);

        if (!field.isEnabled()) {
            throw new AssertionError(labelText + " field is disabled but should be editable");
        }

        String newValue =
                "auto_" + System.currentTimeMillis() + "@test.com";

        field.click();
        try { field.clear(); } catch (Exception ignored) {}
        field.sendKeys(newValue);

        String currentValue = field.getText();
        if (!currentValue.equals(newValue)) {
            throw new AssertionError(
                    "Failed to update " + labelText +
                            ". Expected: " + newValue +
                            " but found: " + currentValue
            );
        }

        logCommunityStat(labelText, "Updated to: " + newValue);

        return newValue;
    }
    @Step("Verify invitation success message is displayed")
    protected void verifyInvitationSentSuccessfully() {

        By successMsg =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"was successfully sent\")"
                );

        Waits.waitForElementToBeVisible(successMsg);

        ElementsActions.isDisplayed(successMsg);

        logCommunityStat(
                "Invitation Status",
                "Invitation was successfully sent"
        );
    }


    @Step("Verify field '{fieldName}' exists")
    protected void verifyFieldExists(String fieldName) {

        By field =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"" + fieldName + "\").instance(0)"
                );

        ElementsActions.isDisplayed(field);
    }
    @Step("Search giver by ID: {giverId}")
    protected void searchForGiver(String giverId) {

        Waits.waitForElementToBeVisible(searchAboutGiversField);
        ElementsActions.setValue(searchAboutGiversField, giverId);

        logCommunityStat("Search Giver", "Searched for giver ID: " + giverId);
    }

    @Step("Verify element is visible")
    protected void verifyElementVisible(By locator) {
        ElementsActions.isDisplayed(locator);
    }
    @Step("Verify In Progress section")
    protected void verifyInProgressSection() {

        ElementsActions.click(inProgressTab);

        verifyElementVisible(pendingApprovalStatus);
        verifyElementVisible(giverNameLabel);
        verifyElementVisible(creationDateLabel);
        verifyElementVisible(needyIdLabel);

        logCommunityStat("In Progress", "All required fields are visible");
    }
    @Step("Verify Complete section")
    protected void verifyCompleteSection() {

        ElementsActions.click(completeTab);

        // ===== Approved Profiles =====
        ElementsActions.click(approvedProfilesTab);
        verifyElementVisible(monthlyTargetText);

        logCommunityStat("Approved Profiles", "Monthly target is visible");

        // ===== Rejected Profiles =====
        ElementsActions.click(rejectedProfilesTab);

        verifyElementVisible(rejectionReasonLabel);
        verifyElementVisible(needyIdLabel);
        verifyElementVisible(creationDateLabel);
        verifyElementVisible(giverNameLabel);

        logCommunityStat("Rejected Profiles", "All required fields are visible");
    }
    @Step("Open My Communities")
    protected void openMyCommunities() {
        ElementsActions.click(CommunityBtn);
        Waits.waitForElementToBeClickable(myCommunitiesBtn);
        ElementsActions.click(myCommunitiesBtn);
    }
    @Step("Open Moderator Community")
    protected void openModeratorCommunity(String communityName) {

        openMyCommunities();

        if (ElementsActions.isDisplayed(moderatorTitle)) {
            openCommunity(communityName);
            return;
        }

    }
    @Step("Edit community details")
    protected void editCommunityDetails() {

        // 1️⃣ Open moderator menu (3 dots)
        Waits.waitForElementToBeClickable(threeDotsModeratorCommunity);
        ElementsActions.click(threeDotsModeratorCommunity);

        // 2️⃣ Open Edit Community Details
        Waits.waitForElementToBeClickable(editCommunityDetailsBtn);
        ElementsActions.click(editCommunityDetailsBtn);

        // 5️⃣ Remove photo
        if (ElementsActions.isDisplayed(removePhotoBtn)) {
            ElementsActions.click(removePhotoBtn);
        }

        // 6️⃣ Verify upload photo message
        ElementsActions.isDisplayed(uploadPhotoMsg);

        // 7️⃣ Capture new photo
        captureModeratorCommunityPhoto();

        // 8️⃣ Save updates
        ElementsActions.click(saveUpdatesBtn);

    }
    @Step("Add verifying member to community")
    protected void addVerifyingMember(String giverId) {

        // 1️⃣ Open moderator menu (3 dots)
        Waits.waitForElementToBeClickable(threeDotsModeratorCommunity);
        ElementsActions.click(threeDotsModeratorCommunity);

        // 2️⃣ Click Add / Remove Verifying Member
        Waits.waitForElementToBeClickable(addOrRemoveVerifyingMemberBtn);
        ElementsActions.click(addOrRemoveVerifyingMemberBtn);

        // 3️⃣ Verify screen title
        ElementsActions.isDisplayed(PeopleYouMayKnowTitle);

        // 4️⃣ Search for giver by ID
        searchForGiver(giverId);

        // 5️⃣ Invite as verifying member
        Waits.waitForElementToBeClickable(inviteAsAVerifyingMemberBtn);
        ElementsActions.click(inviteAsAVerifyingMemberBtn);

        // 6️⃣ Verify success toast (dynamic)
        verifyInvitationSentSuccessfully();

        logCommunityStat(
                "Verifying Member",
                "Invitation sent successfully to giver ID: " + giverId
        );
    }
    @Step("Remove verifying member to community")
    protected void removeVerifyingMember(String giverId) {
         // 1️⃣ Open moderator menu (3 dots)
        Waits.waitForElementToBeClickable(threeDotsModeratorCommunity);
        ElementsActions.click(threeDotsModeratorCommunity);

        // 2️⃣ Click Add / Remove Verifying Member
        Waits.waitForElementToBeClickable(addOrRemoveVerifyingMemberBtn);
        ElementsActions.click(addOrRemoveVerifyingMemberBtn);

        // 3️⃣ Verify screen title
        ElementsActions.isDisplayed(PeopleYouMayKnowTitle);

        ElementsActions.click(viewMembersBtn);
        searchForGiver(giverId);
        ElementsActions.click(removeMemberBtn);
        ElementsActions.click(confirmRemoveBtn);
        ElementsActions.isDisplayed(removeSucMsg);

    }
@Step("Click Back  button and more button and Login ")
protected void secondLoginFlow(String secondEmail, String secondPassword) {
    ElementsActions.click(backBtn);
    ElementsActions.click(backBtn);
    Waits.waitForElementToBeVisible(moreBtn);
    ElementsActions.click(moreBtn);
    By logout = AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().description(\"Logout\"))"
    );

    ElementsActions.findElement(logout);


    ElementsActions.click(logoutBtn);
    ElementsActions.click(confirmRemoveBtn);
    tapSignInWithoutSkipButton();
    isInLoginScreen();
    performLogin(secondEmail,secondPassword);

}
    public void manageNeedyVerificationFlow() {

        ElementsActions.click(threeDotsModeratorCommunity);

        ElementsActions.click(manageNeedyProfilesBtn);

        verifyInProgressSection();

        verifyCompleteSection();

    }
    public void manageCreationNeedyVerificationFlow() {

        ElementsActions.click(threeDotsModeratorCommunity);

        ElementsActions.click(manageNeedyProfilesBtn);
        ElementsActions.click(draftTab);
        ElementsActions.click(inProgressTab);
        ElementsActions.click(completeTab);
        ElementsActions.click(approvedProfilesTab);
        ElementsActions.click(rejectedProfilesTab);

    }
        private void verifyNeedyProfilesFlow() {
        manageNeedyVerificationFlow();
    }

    private void removeVerifyingMemberFlow(
            String communityName,
            String giverId,
            String email,
            String password
    ) {

        secondLoginFlow(email, password);

        openModeratorCommunity(communityName);

        removeVerifyingMember(giverId);

        ElementsActions.click(backBtn);
        ElementsActions.click(backBtn);
    }

    private void addAndAcceptVerifyingMemberFlow(
            String giverId,
            String secondEmail,
            String secondPassword
    ) {

        addVerifyingMember(giverId);

        secondLoginFlow(secondEmail, secondPassword);

        ElementsActions.click(notificationBtn);
        ElementsActions.click(ngoInvitation);
        ElementsActions.click(acceptInvitation);

        ElementsActions.isDisplayed(backToCommunitiesBtn);
    }

    private void executeModeratorCommunityMainFlow(String communityName) {

        openModeratorCommunity(communityName);

        createPostWithPhotoAndComments();

        editAndDeletePostThenUnfollowUsingSecondDots(communityName);


        editCommunityDetails();

        logCommunityStat(
                "Moderator Community",
                "Moderator main flow executed successfully"
        );
    }

    @Step("Execute Moderator Community Scenario")
    protected void executeModeratorCommunityScenario(
            String communityName,
            String giverId,
            String secondEmail,
            String secondPassword,
            String email,
            String password
    ) {

        executeModeratorCommunityMainFlow(communityName);

        addAndAcceptVerifyingMemberFlow(giverId, secondEmail, secondPassword);

        removeVerifyingMemberFlow(communityName, giverId, email, password);

        verifyNeedyProfilesFlow();
    }
    @Step("Execute Moderator Community Scenario")
    public void executeCreationCommunityScenario(
            String communityName,
            String giverId,
            String secondEmail,
            String secondPassword,
            String email,
            String password
    ) {

        executeModeratorCommunityMainFlow(communityName);

        addAndAcceptVerifyingMemberFlow(giverId, secondEmail, secondPassword);

        removeVerifyingMemberFlow(communityName, giverId, email, password);

        manageCreationNeedyVerificationFlow();

    }

}
