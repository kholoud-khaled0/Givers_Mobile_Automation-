package screens.android;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.base.NeedyScreen;
import utils.appium.ElementsActions;
import utils.appium.Waits;
import utils.common.DocumentData;
import utils.common.MaritalStatusConfig;

import java.util.List;

import static utils.appium.ElementsActions.*;
import static utils.appium.Waits.waitForElementToBeVisible;
import static utils.appium.Waits.waitForUIStability;
import static utils.appium.driverManager.DriverManager.getDriver;

public class AndroidCreateNeedyProfileScreen extends NeedyScreen {

    @Step("Perform full Needy Profile flow from NeedyProfileTestData")
    @Override
    public void performCreateNeedyFlow(
            String ID,
            String firstName,
            String maritalStatus,
            String motherName,
            String phoneNumber,
            List<DocumentData> needyDocuments,
            List<DocumentData> memberDocuments,
            String state,
            String city,
            String address,
            String housingCondition,
            String amount,
            String relationShip,
            String story,
            String note
    ) {

        // ================== Basic Info ==================
        tapMoreButton();
        tapCreateNeedyProfile();
        isCreateNeedyProfileDisplayed();

        tapRecord();
        tapStopRecord();
        isRecordExist();

        setNeedyFirstName(firstName);
        setNationalID(ID);
        waitForUIStability();

        setFullNameAsInNID(firstName + " محمد أحمد ");
        waitForUIStability();
        enterDynamicDate();
        scrollDownSmall();
        openDropdownAndSelectByName( "Select marital status" , maritalStatus);
        scrollDown();
        setMotherName(motherName);
        setPhoneNumber(phoneNumber);
        // ================== Documents ==================
        // ================== Documents ==================
        scrollDown();
        waitForUIStability();

        List<DocumentData> filteredDocs = filterDocumentsByAge(ID, needyDocuments);
        uploadNeedyDocumentsByMaritalStatus(maritalStatus, filteredDocs);


        // ================== Address ==================
        tapNext();
        waitForUIStability();
        tapNext();
        waitForUIStability();

//        tapMyLocation();
//        tapDone();
        openDropdownAndSelectByName(  "Select state", state);
        openDropdownAndSelectByName("Select city", city);
        setAddress(address);
        openDropdownAndSelectByName("Select condition", housingCondition);

        // ================== Financial ==================
        tapNext();
        scrollDown();
        setEnterAmount(amount);
        tapCheckBox();
        tapNext();

        // ================== Add Member ==================
        tapAddMember();
        openDropdownAndSelectByName("Select relationship", relationShip);

        setNationalID(ID);
        setFullNameAsInNID(firstName + " خالد جمعه ");
        enterDynamicDate();
        setMotherName(motherName);

        scrollDown();
        processDocuments(memberDocuments, 2);

        tapAddMemberConfirmation();
        waitForUIStability();
        clickNextUntilLeaveMembersOfHousehold();

        // ================== Media ==================
        tapFilePickerTrigger(0);
        capturePhoto();

        scrollUntilElementVisible(storyField, 3);
        tapFilePickerTrigger(1);
        recordVideo(5);

        scrollUntilElementVisible(notesField, 3);
        setStory(story);
        setNotes(note);

        scrollDown();
        tapFilePickerTrigger(0);
        capturePhoto();

        scrollDownSmall();
        tapFilePickerTrigger(1);
        capturePhoto();

        tapSubmit();
    }

    // ============================================================
    // ================== Helpers ==================
    // ============================================================

    /**
     * Uploads:
     * - Fixed documents (National ID + Birth Certificate)
     * - One extra document based on marital status (if exists)
     */
    private void uploadNeedyDocumentsByMaritalStatus(
            String maritalStatus,
            List<DocumentData> baseDocuments
    ) {

        // ✅ 1) Fixed documents
        processDocuments(baseDocuments, 1);

        // ✅ 2) Normalize marital status
        String normalizedStatus = maritalStatus == null
                ? ""
                : maritalStatus.trim().toLowerCase();

        // ✅ 3) Extra document
        String extraDocument =
                MaritalStatusConfig.EXTRA_DOCUMENT_BY_STATUS.get(normalizedStatus);

        if (extraDocument == null) {
            return; // Single
        }

        uploadDocumentWithCamera(extraDocument);

        // Extra document requires date
        enterDynamicDate();

        waitForUIStability();
        scrollDown();
    }



    private final By uploadDocumentBtn =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"file-picker-trigger\").instance(0)"
            );

    /**
     * Handles document uploads
     * - National ID → TWO photos (no scroll between them)
     * - Other documents → ONE photo
     */
    private void processDocuments(List<DocumentData> documents, int dropdownIndex) {

        for (DocumentData doc : documents) {

            if ("national-id-documents".equals(doc.documentName())) {

                uploadDocumentWithCamera(doc.documentName());
                waitForUIStability();

                ElementsActions.click(uploadDocumentBtn);
                capturePhoto();
                waitForUIStability();

                scrollDown();

            } else {

                uploadDocumentWithCamera(doc.documentName());
                waitForUIStability();
                scrollDown();
            }

            // ✅ Dropdown logic
            if ("school-letter-document".equals(doc.documentName())) {
                selectSchoolYear("Primary four");
                scrollDown();

            } else if (doc.dropdownValue() != null) {

                openDropdownAndSelect(2, doc.dropdownValue());
            }

            waitForUIStability();
        }
    }


    @Step("Scroll down")
    public void scrollDown() {
        ElementsActions.scrollToBottom2();
    }

    public void smartWait() {
        for (int i = 0; i < 5; i++) {
            waitForUIStability();
            try {
                Thread.sleep(200);
            } catch (Exception ignored) {
            }
        }
    }

    // ============================================================
    // ================== Overrides ==================
    // ============================================================

    @Override
    public void performNeedyCheckFlow(String ID, String Name) {
        // Not used
    }

    @Override
    public void tapSubmit() {
        super.tapSubmit();
    }

    @Override
    public boolean isCreateNeedyProfileDisplayed() {
        return true;
    }
    private List<DocumentData> filterDocumentsByAge(String nationalId, List<DocumentData> documents) {
        boolean isYoung = isAgeLessOrEqual24(nationalId);

        return documents.stream()
                .filter(doc -> {
                    if (doc.documentName().equals("school-letter-document")) return isYoung;
                    if (doc.documentName().equals("birth-certificate-documents") && doc.dropdownValue() != null)
                        return isYoung;
                    return true;
                })
                .toList();
    }

    public boolean isAgeLessOrEqual24(String nationalId) {
        int century = Integer.parseInt(nationalId.substring(0, 1));
        int year = Integer.parseInt(nationalId.substring(1, 3));
        int birthYear = (century == 3 ? 2000 : 1900) + year;
        int currentYear = java.time.LocalDate.now().getYear();
        return (currentYear - birthYear) <= 24;
    }


    @Step("Scroll to element by text")
    protected void scrollToElement(By locator) {

        String text =
                getDriver()
                        .findElement(locator)
                        .getText();

        By scrollable =
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
                );

        getDriver().findElement(scrollable);
    }

}
