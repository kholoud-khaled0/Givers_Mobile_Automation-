package screens.android;

import io.qameta.allure.Step;
import screens.base.NeedyScreen;
import utils.common.DocumentData;

import java.util.List;

public class AndroidNeedyCheckScreen extends NeedyScreen {

    @Override
    @Step("Perform full Needy Check flow with ID: {ID} and Name: {Name}")
    public void performNeedyCheckFlow(String ID, String Name) {
        // 1️⃣ Tap More button
        tapMoreButton();

        // 2️⃣ Tap Needy Check button
        tapNeedyCheckButton();

        // 3️⃣ Verify we're on Needy Check page
        isNeedyCheckDisplayed();

        // 4️⃣ Enter ID
        setID(ID);

        // 5️⃣ Enter Name
        setName(Name);

        // 6️⃣ Tap Check button
        tapCheckButton();
    }

    @Override
    public void performCreateNeedyFlow( String ID,
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
                                        String note) {

    }


    // ========================= Optional helper methods ========================= //

    @Step("Verify if profile exists")
    public boolean isExistingProfile() {
        return isExistingHouseholdDisplayed();
    }

    @Step("Verify if profile exists")
    public boolean isExistingNeedyProfile() {
        return  isExistingNeedyDisplayed();
    }

    @Step("Verify if profile does NOT exist")
    public boolean isProfileNotFound() {
        return isNotExistingDisplayed();
    }
}
