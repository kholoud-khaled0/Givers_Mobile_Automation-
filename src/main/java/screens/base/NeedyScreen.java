package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.appium.ElementsActions;
import utils.appium.Waits;
import utils.common.DocumentData;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static utils.appium.Waits.*;

public abstract class NeedyScreen {
    protected static final By moreBtn =
            AppiumBy.accessibilityId("\uE821, More");
    protected static final By needyCheckBtn =
            AppiumBy.accessibilityId("Needy Check");
    protected static final By needyCheckTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Needy Check\")");
    protected static final By idField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"The needy's national ID number\")");
    protected static final By nameField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"The full name as it appears in the national ID\")");
    protected static final By checkBtn =
            AppiumBy.accessibilityId("Check Now");
    protected static final By existingHousehold =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Existing household member\")");
    protected static final By existingNeedy =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"There is a needy profile with the entered national ID number currently under verification.\")");

    protected static final By notExisting =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"We didn’t find any profile using this ID!\")");
    protected static final By createANeedyProfileBtn =
            AppiumBy.accessibilityId("Create A Needy Profile");
    protected static final By sortBtn =
            AppiumBy.accessibilityId("\uE85D");
    protected static final By createANeedyProfileTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Create A Needy Profile\")");
    protected static final By recordBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\uE8A0\")");
    protected static final By stopRecordBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\uE8A2\")");
    protected static final By deleteRecordBtn =
            AppiumBy.accessibilityId("\uE840");
    protected static final By playRecordBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\uE8A3\")");
    protected static final By recordIsExist =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(29)");
    protected static final By nameNeedyField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"First name\")");
    protected static final By NIDField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"National ID number\")");
    protected static final By nameNIDField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Full name as in national ID\")");
    protected static final By arrow =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\uE819\").instance(1)");
    protected static final By dropdown =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"select-dropdown-trigger\").instance(2)");
    protected static final By motherNameField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Mother's first name\")");
    protected static final By phoneNumberField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter number\")");
    protected static final By addAnotherNumberField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Add another number\")");
    protected static final By phoneNumberField2 =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter number\").instance(1)");
    protected static final By showDatePickerBtn =
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"showDatePickerBtn\").instance(1)");
    protected static final By btn_next =
            AppiumBy.id("btn-next");
    protected static final By shutterBtn =
            AppiumBy.accessibilityId("Shutter");
    protected static final By doneBtn =
            AppiumBy.accessibilityId("Done");
    protected static final By launchCameraBtn =
            AppiumBy.accessibilityId("launch-camera");
    protected static final By uploadProfilePictureTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Upload Profile Picture\")");
    protected static final By imageCameraBox =
            AppiumBy.className("android.view.ViewGroup");
    protected static final By file_list_item =
            AppiumBy.accessibilityId("file-list-item");
    protected static final By selectYearDropDownList =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Select year\")");
    protected static final By nextBtn =
            AppiumBy.accessibilityId("Next");
    protected static final By backBtn =
            AppiumBy.accessibilityId("Back");
    protected static final By calendar_trigger_button =
            AppiumBy.accessibilityId("calendar-trigger-button");
    protected static final By diseaseTypeField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter the types of chronic diseases\")");
    protected static final By monthlyHealthExpensesNeededField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"0\")");
    protected static final By chronic_diseases_documents =
            AppiumBy.accessibilityId("chronic-diseases-documents");
    protected static final By partial_DisabilityBtn =
            AppiumBy.accessibilityId("Partial Disability");
    protected static final By fully_DisabilityBtn =
            AppiumBy.accessibilityId("Fully Disabled");
    protected static final By switchBtn =
            AppiumBy.accessibilityId("disability-consent-toggle");
    protected static final By saveAsDraftBtn =
            AppiumBy.accessibilityId("Save as draft");
    protected static final By myLocationBtn =
            AppiumBy.accessibilityId("Google Map");
    protected static final By addressField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter address details here\")");
    protected static final By amountField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter amount\")");
    protected static final By addMemberBtn =
            AppiumBy.accessibilityId("\uE838, Add Member");
    protected static final By memberIsEmployedSwitch =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Member is employed\")");
    protected static final By select_dropdown_trigger =
            AppiumBy.accessibilityId("select-dropdown-trigger");
    protected static final By addMemberConfirmationBtn =
            AppiumBy.accessibilityId("Add Member");
    protected static final By relationshipTypeField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter relationship type\")");
    public static final By storyField =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)");
    public static final By notesField =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");
    protected static final By submitBtn =
            AppiumBy.accessibilityId("Submit");
    protected static final By dateField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Select date\")");
    protected static final By checkBox =
            AppiumBy.className("android.widget.CheckBox");
    protected static final By searchByNeedyIDField =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Search by Needy ID\")");
    protected static final By filterBtn =
            AppiumBy.accessibilityId("\uE81F");
    protected static final By useCurrentLocationCheckBox =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Use my current location\")");
    protected static final By presenceOfDependantsCheckBox =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Presence of dependants\")");
    protected static final By applyFiltersBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Apply Filters\")");
    protected static final By needyBtn =
            AppiumBy.accessibilityId("\uE822, Needy");


    @Step("Tap 'More' button")
    public void tapMoreButton() {
        ElementsActions.click(moreBtn);
    }
    @Step("Tap 'NeedyCheck' button")
    public void tapNeedyCheckButton() {
        ElementsActions.click(needyCheckBtn);
    }

    @Step("Check if 'Needy Check' title is displayed")
    public boolean isNeedyCheckDisplayed() {
        return ElementsActions.isDisplayed(needyCheckTitle);
    }

    @Step("Set ID: {ID}")
    public void setID(String ID) {
        ElementsActions.setValue(idField, ID);
    }
    @Step("Set Name: {Name}")
    public void setName(String Name) {
        ElementsActions.setValue(nameField, Name);
    }

    @Step("Tap 'check' button")
    public void tapCheckButton() {
        ElementsActions.click(checkBtn);
    }
    // ========================= Assertions ========================= //

    @Step("Verify Existing Household Member is displayed")
    public boolean isExistingHouseholdDisplayed() {
        return ElementsActions.isDisplayed(existingHousehold);
    }

    @Step("Verify Existing Household Member is displayed")
    public boolean isExistingNeedyDisplayed() {
        return ElementsActions.isDisplayed(existingNeedy);
    }

    @Step("Verify 'Not Existing' message is displayed")
    public boolean isNotExistingDisplayed() {
        return ElementsActions.isDisplayed(notExisting);
    }
    @Step("Select day: {day}")
    public void selectDay(String day) {
        By dayBtn = AppiumBy.xpath("//android.widget.Button[@content-desc='" + day + "']");
        ElementsActions.click(dayBtn);
    }


    @Step("Tap Needy button")
    public void tapNeedyButton() {
        ElementsActions.click(needyBtn);
    }


    public void selectFromDropdownByDescription(String value) {
        By option = AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + value + "\")"
        );
        waitForElementToBeVisibleForNeedy(option);
        ElementsActions.click(option);
    }
    public static By dropdownByInstance(int index) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"select-dropdown-trigger\").instance(" + index + ")"
        );
    }
    public static By documentsByType(String type) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + type + "\")"
        );
    }


    protected static By uploadButtonFullText(String text) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + text + "\")"
        );
    }

// ========================= Actions / Steps ========================= //

    @Step("Tap Create A Needy Profile Button")
    public void tapCreateNeedyProfile() {
        waitForElementToBeVisibleForNeedy(createANeedyProfileBtn);
        ElementsActions.click(createANeedyProfileBtn);
    }


    @Step("Check Create A Needy Profile Title is displayed")
    public boolean isCreateNeedyProfileDisplayed() {
        waitForElementToBeVisibleForNeedy(createANeedyProfileTitle);
        return ElementsActions.isDisplayed(createANeedyProfileTitle);
    }

    @Step("Tap Record Button")
    public void tapRecord() {
        waitForElementToBeClickableForNeedy(recordBtn);
        ElementsActions.click(recordBtn);
    }
    @Step("Tap CheckBox Button")
    public void tapCheckBox() {
        waitForElementToBeClickableForNeedy(checkBox);
        ElementsActions.click(checkBox);
    }

    @Step("Tap Stop Record Button")
    public void tapStopRecord() {
        waitForElementToBeVisibleForNeedy(stopRecordBtn);
        ElementsActions.click(stopRecordBtn);
    }

    @Step("Tap Delete Record Button")
    public void tapDeleteRecord() {
        ElementsActions.click(deleteRecordBtn);
    }

    @Step("Tap Play Record Button")
    public void tapPlayRecord() {
        ElementsActions.click(playRecordBtn);
    }

    @Step("Check if record exists")
    public boolean isRecordExist() {
        waitForElementToBeVisibleForNeedy(recordIsExist);
        return ElementsActions.isDisplayed(recordIsExist);
    }

    @Step("Enter Needy First Name: {name}")
    public void setNeedyFirstName(String name) {
        ElementsActions.setValue(nameNeedyField, name);
    }

    @Step("Enter Amount : {amount}")
    public void setEnterAmount(String amount) {
        ElementsActions.setValue(amountField, amount);
    }

    @Step("Enter National ID: {nid}")
    public void setNationalID(String nid) {
        ElementsActions.setValue(NIDField, nid);
    }

    @Step("Enter Full Name as in National ID: {name}")
    public void setFullNameAsInNID(String name) {
        ElementsActions.setValue(nameNIDField, name);
    }

    @Step("Enter Mother First Name: {name}")
    public void setMotherName(String name) {
        ElementsActions.setValue(motherNameField, name);
    }

    @Step("Enter Phone Number: {phone}")
    public void setPhoneNumber(String phone) {
        waitForElementToBeVisibleForNeedy(phoneNumberField);
        ElementsActions.setValue(phoneNumberField, phone);
    }

    @Step("Tap Add Another Number")
    public void tapAddAnotherNumber() {
        ElementsActions.click(addAnotherNumberField);
    }

    @Step("Enter Second Phone Number: {phone}")
    public void setSecondPhoneNumber(String phone) {
        ElementsActions.setValue(phoneNumberField2, phone);
    }
    @Step("Enter dynamic date of birth")
    public void enterDynamicDate() {
        String generatedDate = generateDynamicDate();
        waitForElementToBeVisibleForNeedy(dateField);
        ElementsActions.setValue(dateField, generatedDate);
    }
    private String generateDynamicDate() {
        int day = (int) (Math.random() * 28) + 1;
        int month = (int) (Math.random() * 12) + 1;
        int year = (int) (Math.random() * 30) + 1990;

        return String.format("%02d/%02d/%04d", day, month, year);
    }


    @Step("Tap Launch Camera")
    public void tapLaunchCamera() {
        waitForElementToBeVisibleForNeedy(launchCameraBtn);
        ElementsActions.click(launchCameraBtn);
    }

    @Step("Tap Shutter Button")
    public void tapShutter() {
        waitForElementToBeVisibleForNeedy(shutterBtn);
        ElementsActions.click(shutterBtn);
    }

    @Step("Tap Done Button")
    public void tapDone() {
        waitForElementToBeVisibleForNeedy(doneBtn);
        ElementsActions.click(doneBtn);
    }

    @Step("Check Upload Profile Picture title displayed")
    public boolean isUploadProfilePictureDisplayed() {
        return ElementsActions.isDisplayed(uploadProfilePictureTitle);
    }

    @Step("Select Image from Camera Box")
    public void selectImageBox() {
        waitForElementToBeVisibleForNeedy(imageCameraBox);
        ElementsActions.click(imageCameraBox);
    }

    @Step("Select File from List")
    public void selectFileFromList() {
        ElementsActions.click(file_list_item);
    }


    @Step("Tap Next Button")
    public void tapNext() {
        waitForElementToBeVisibleForNeedy(nextBtn);
        waitForElementToBeClickableForNeedy(nextBtn);
        ElementsActions.click(nextBtn);
    }    @Step("Tap Back Button")
    public void tapBack() {
        waitForElementToBeVisibleForNeedy(backBtn);
        ElementsActions.click(backBtn);
    }

    @Step("Open Calendar")
    public void tapCalendarTrigger() {
        ElementsActions.click(calendar_trigger_button);
    }

    @Step("Enter Disease Types: {disease}")
    public void setDiseaseType(String disease) {
        ElementsActions.setValue(diseaseTypeField, disease);
    }

    @Step("Enter Monthly Health Expenses: {value}")
    public void setMonthlyHealthExpenses(String value) {
        ElementsActions.setValue(monthlyHealthExpensesNeededField, value);
    }

    @Step("Tap Chronic Diseases Documents")
    public void tapChronicDiseasesDocuments() {
        ElementsActions.click(chronic_diseases_documents);
    }

    @Step("Select Partial Disability")
    public void selectPartialDisability() {
        ElementsActions.click(partial_DisabilityBtn);
    }

    @Step("Select Fully Disabled")
    public void selectFullyDisability() {
        ElementsActions.click(fully_DisabilityBtn);
    }

    @Step("Toggle Disability Consent")
    public void toggleDisabilityConsent() {
        ElementsActions.click(switchBtn);
    }

    @Step("Tap Save As Draft")
    public void tapSaveAsDraft() {
        ElementsActions.click(saveAsDraftBtn);
    }

    @Step("Tap My Location")
    public void tapMyLocation() {
        Waits.waitForElementToBeVisible(myLocationBtn);
        ElementsActions.click(myLocationBtn);
    }

    @Step("Enter Address: {address}")
    public void setAddress(String address) {
        waitForElementToBeVisibleForNeedy(addressField);
        ElementsActions.setValue(addressField, address);
    }

    @Step("Tap Add Member Button")
    public void tapAddMember() {
        waitForElementToBeVisibleForNeedy(addMemberBtn);
        ElementsActions.click(addMemberBtn);
    }

    @Step("Toggle Member Is Employed")
    public void toggleMemberIsEmployed() {
        ElementsActions.click(memberIsEmployedSwitch);
    }

    @Step("Tap Dropdown Trigger")
    public void tapSelectDropdownTrigger() {
        ElementsActions.click(select_dropdown_trigger);
    }

    @Step("Tap Add Member Confirmation")
    public void tapAddMemberConfirmation() {
        waitForElementToBeVisibleForNeedy(addMemberConfirmationBtn);
        ElementsActions.click(addMemberConfirmationBtn);
    }

    @Step("Enter Relationship Type: {type}")
    public void setRelationshipType(String type) {
        ElementsActions.setValue(relationshipTypeField, type);
    }

    @Step("Enter Story: {story}")
    public void setStory(String story) {
        ElementsActions.setValue(storyField, story);
    }

    @Step("Enter Notes: {notes}")
    public void setNotes(String notes) {
        ElementsActions.setValue(notesField, notes);
    }

    @Step("Tap Submit Button")
    public void tapSubmit() {
        ElementsActions.click(submitBtn);
    }

    @Step("Select from dropdown with index: {index} and value: {value}")
    public void openDropdownAndSelect(int index, String value) {

        By dropdown = dropdownByInstance(index);
        waitForElementToBeVisibleForNeedy(dropdown);
        ElementsActions.click(dropdown);
        selectFromDropdownByDescription(value);
    }
    @Step("Select from dropdown with index: {index} and value: {value}")
    public void openDropdownAndSelectByValue(String dropDownName , String value) {
        selectFromDropdownByDescription(dropDownName);
        selectFromDropdownByDescription(value);
    }

    protected By dropdownByName(String dropDownName) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().descriptionContains(\"" + dropDownName + "\")"
        );
    }

    @Step("Select from dropdown '{dropDownName}' value '{value}'")
    protected void openDropdownAndSelectByName(String dropDownName, String value) {

        By dropdown = dropdownByName(dropDownName);

        Waits.waitForElementToBeVisible(dropdown);
        ElementsActions.click(dropdown);

        selectFromDropdownByDescription(value);

    }



    @Step("Upload document '{documentName}' using camera")
    public void uploadDocumentWithCamera(String documentName) {
        By documentBtn = documentsByType(documentName);
        ElementsActions.click(documentBtn);
        capturePhoto();
        Waits.waitForCameraDialogToDisappear();
    }


    public static By filePickerTriggerByInstance(int index) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"file-picker-trigger\").instance(" + index + ")"
        );
    }

    public void tapFilePickerTrigger(int index) {
        ElementsActions.click(filePickerTriggerByInstance(index));
    }


    @Step("Capture photo using camera")
    public  void capturePhoto() {

        tapLaunchCamera();


        tapShutter();   // take photo
        tapDone();      // confirm photo

        Waits.waitForCameraDialogToDisappear();
    }

    @Step("Select option with text: {optionText}")
    public void selectOptionByText(String optionText) {
        By option =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"" + optionText + "\")"
                );
        ElementsActions.click(option);
    }


    @Step("Record video using camera")
    public void recordVideo(int recordingSeconds) {

        tapLaunchCamera();

        tapShutter(); // start recording

        try {
            Thread.sleep(recordingSeconds * 1000L);
        } catch (InterruptedException ignored) {}

        tapShutter(); // stop recording
        tapDone();    // confirm video

        Waits.waitForCameraDialogToDisappear();
    }
    @Step("Tap Apply Filters button")
    public void tapApplyFiltersButton() {
        ElementsActions.click(applyFiltersBtn);
    }
    @Step("Tap Sort button")
    public void tapSortButton() {
        ElementsActions.click(sortBtn);
    }
    @Step("Select 'Presence of dependants' checkbox")
    public void selectPresenceOfDependants() {
        ElementsActions.click(presenceOfDependantsCheckBox);
    }
    @Step("Select 'Use my current location' checkbox")
    public void selectUseCurrentLocation() {
        ElementsActions.click(useCurrentLocationCheckBox);
    }
    @Step("Tap Filter button")
    public void tapFilterButton() {
        ElementsActions.click(filterBtn);
    }
    @Step("Search by Needy ID: {needyID}")
    public void searchByNeedyID(String needyID) {
        ElementsActions.setValue(searchByNeedyIDField, needyID);
    }
    @Step("Select school year: {year}")
    public void selectSchoolYear(String year) {

        ElementsActions.click(selectYearDropdown);
        waitForUIStability();

        ElementsActions.click(schoolYearOption(year));
        waitForUIStability();
    }
    @Step("Click Next until leaving Members of Household page")
    protected void clickNextUntilLeaveMembersOfHousehold() {

        By membersOfHouseholdTitle =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"Members of Household\")"
                );

        int maxTries = 5; // حماية من infinite loop
        int counter = 0;

        while (counter < maxTries && ElementsActions.isDisplayed(membersOfHouseholdTitle)) {

            Waits.waitForElementToBeClickable(nextBtn);
            tapNext();

            counter++;
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }

        if (ElementsActions.isDisplayed(membersOfHouseholdTitle)) {
            throw new AssertionError(
                    "Still on 'Members of Household' page after clicking Next"
            );
        }
    }

    protected boolean isAgeLessOrEqual24(String nationalId) {
        int century = Integer.parseInt(nationalId.substring(0, 1));
        int year = Integer.parseInt(nationalId.substring(1, 3));

        int birthYear = (century == 3 ? 2000 : 1900) + year;
        int currentYear = LocalDate.now().getYear();

        return (currentYear - birthYear) <= 24;
    }
    private final By selectYearDropdown =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"Select year, \uE819\")"
            );
    private By schoolYearOption(String value) {
        return AppiumBy.accessibilityId(value);
    }


    public static void waitForElementToBeVisibleForNeedy(By locator) {
        waitForElementToBeVisible(locator, Duration.ofSeconds(120));
    }

    public static void waitForElementToBeClickableForNeedy(By locator) {
        waitForElementToBeClickable(locator, Duration.ofSeconds(120));
    }
    @Step("Perform full registration flow")
    public abstract void performNeedyCheckFlow(String ID , String Name );
    public abstract void performCreateNeedyFlow( String ID,
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
                                                 String note);
}
