package screens.android;

import io.qameta.allure.Step;
import screens.base.NeedyScreen;
import utils.appium.ElementsActions;
import utils.common.DocumentData;

import java.util.List;

public class AndroidNeedyFunctionsScreen extends NeedyScreen {


    @Step("Apply sort values one by one")
    public void applySort(List<String> values) {

        tapNeedyButton();

        for (String value : values) {
            openSortAndSelect(value);
        }
    }


    @Step("Apply Filter")
    public void applyFilter(
            String state,
            String city,
            String gender,
            String needySituation,
            String employmentStatus,
            String housingStatus,
            String healthCondition
    ) {

        tapNeedyButton();
        tapFilterButton();

        // State
        openDropdownAndSelectByName("State", state);

        // City
        openDropdownAndSelectByName("City", city);

        // Gender
        selectOptionByText(gender);

        scrollDown();

        // Other filters
        selectOptionByText(needySituation);
        selectOptionByText(employmentStatus);
        selectOptionByText(housingStatus);
        selectOptionByText(healthCondition);

        tapApplyFiltersButton();
    }


    @Step("Scroll down")
    public void scrollDown() {
        ElementsActions.scrollToBottom2();
    }
    @Step("Open sort and select value: {value}")
    private void openSortAndSelect(String value) {
        tapSortButton();
        selectFromDropdownByDescription(value);
    }

    @Override
    public void performCreateNeedyFlow(String ID, String firstName, String maritalStatus, String motherName, String phoneNumber, List<DocumentData> needyDocuments, List<DocumentData> memberDocuments, String state, String city, String address, String housingCondition, String amount, String relationShip, String story, String note, String healthStatus, String disabilityLevel, List<String> disabilityTypes, String chronicDiseaseType, String monthlyExpenses) {

    }

    @Override
    public void performNeedyCheckFlow(String ID, String Name) {


    }
}
