package utils.testFactory;

import org.testng.annotations.DataProvider;
import utils.common.JsonUtils;
import utils.model.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DataProviders {

    // ---------------- Login Data ---------------- //
    private final LoginTestData[] loginTestDataList = JsonUtils.readJson(
            "src/test/resources/loginTestData.json",
            LoginTestData[].class
    );

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        Object[][] data = new Object[loginTestDataList.length][1];
        for (int i = 0; i < loginTestDataList.length; i++) {
            data[i][0] = loginTestDataList[i];
        }
        return data;
    }

    // ---------------- Register Data ---------------- //
    private final RegisterTestData[] registerTestDataList = JsonUtils.readJson(
            "src/test/resources/registerTestData.json",
            RegisterTestData[].class
    );

    @DataProvider(name = "registerData")
    public Object[][] registerData() {
        Object[][] data = new Object[registerTestDataList.length][1];
        for (int i = 0; i < registerTestDataList.length; i++) {
            data[i][0] = registerTestDataList[i];
        }
        return data;
    }

    // ---------------- Reset Password Data ---------------- //
    private final ResetPasswordTestData[] resetPasswordTestDataList = JsonUtils.readJson(
            "src/test/resources/resetPasswordTestData.json",
            ResetPasswordTestData[].class
    );

    @DataProvider(name = "resetPasswordData")
    public Object[][] resetPasswordData() {
        Object[][] data = new Object[resetPasswordTestDataList.length][1];
        for (int i = 0; i < resetPasswordTestDataList.length; i++) {
            data[i][0] = resetPasswordTestDataList[i];
        }
        return data;
    }

    // ---------------- Personal Information Data ---------------- //
    private final PersonalInformationTestData[] personalInformationDataList = JsonUtils.readJson(
            "src/test/resources/PersonalInformationTestData.json",
            PersonalInformationTestData[].class
    );
    @DataProvider(name = "personalInformationData")
    public Object[][] personalInformationData() {
        return Arrays.stream(personalInformationDataList)
                .filter(data ->
                        data.story() != null &&
                                !data.story().toLowerCase().contains("delete account")
                )
                .map(data -> new Object[]{data})
                .toArray(Object[][]::new);
    }


    // ---------------- Delete Account Data (Filtered) ---------------- //
    private final PersonalInformationTestData[] deleteAccountDataList = JsonUtils.readJson(
            "src/test/resources/PersonalInformationTestData.json",
            PersonalInformationTestData[].class
    );

    @DataProvider(name = "deleteAccountData")
    public Object[][] deleteAccountData() {
        return Arrays.stream(personalInformationDataList)
                .filter(data -> data.story() != null &&
                        data.story().toLowerCase().contains("delete account"))
                .map(data -> new Object[]{data})
                .toArray(Object[][]::new);
    }
    // ---------------- Forgot Password Data ---------------- //
    private final ForgotPasswordTestData[] forgotPasswordDataList = JsonUtils.readJson(
            "src/test/resources/ForgotPasswordTestData.json",
            ForgotPasswordTestData[].class
    );

    @DataProvider(name = "forgotPasswordData")
    public Object[][] forgotPasswordData() {
        Object[][] data = new Object[forgotPasswordDataList.length][1];
        for (int i = 0; i < forgotPasswordDataList.length; i++) {
            data[i][0] = forgotPasswordDataList[i];
        }
        return data;
    }
    // ---------------- Needy Check Data ---------------- //
    private final NeedyTestData[] needyTestDataList = JsonUtils.readJson(
            "src/test/resources/NeedyTestData.json",
            NeedyTestData[].class
    );

    @DataProvider(name = "needyCheckData")
    public Object[][] needyCheckData(Method method) {
        switch (method.getName()) {

            case "testExistingHouseholdMemberFlow":
                return new Object[][] { { needyTestDataList[0] } };

            case "testIncorrectIDFlow":
                return new Object[][] { { needyTestDataList[1] } };

            case "testMismatchedNameFlow":
                return new Object[][] { { needyTestDataList[2] } };

            case "testExistingNeedyMemberFlow":
                return new Object[][] { { needyTestDataList[3] } };

            default:
                throw new RuntimeException(
                        "No test data mapped for method: " + method.getName()
                );
        }
    }


    private final NeedyProfileTestData[] createNeedyDataList =
            JsonUtils.readJson(
                    "src/test/resources/CreateNeedyProfileTestData.json",
                    NeedyProfileTestData[].class
            );

    @DataProvider(name = "needyProfileData")
    public Object[][] needyProfileData(Method method) {

        if (createNeedyDataList == null) {
            throw new RuntimeException("JSON file not found or empty: CreateNeedyProfileTestData.json");
        }

        switch (method.getName()) {

            case "testNeedyProfileAgeAbove24":
                return new Object[][] {
                        { createNeedyDataList[0] }
                };

            case "testNeedyProfileAgeLessOrEqual24":
                return new Object[][] {
                        { createNeedyDataList[1] }
                };

            default:
                return new Object[0][];
        }
    }

    // ---------------- Needy Functions Data ---------------- //
    private final NeedyFunctionsTestData[] needyFunctionsDataList =
            JsonUtils.readJson(
                    "src/test/resources/NeedyFunctionTestData.json",
                    NeedyFunctionsTestData[].class
            );

    @DataProvider(name = "needyFunctionsData")
    public Object[][] needyFunctionsData() {

        Object[][] data = new Object[needyFunctionsDataList.length][1];

        for (int i = 0; i < needyFunctionsDataList.length; i++) {
            data[i][0] = needyFunctionsDataList[i];
        }

        return data;
    }
    // ---------------- Easy Give Data ---------------- //
    private final EasyGiveTestData[] easyGiveTestDataList =
            JsonUtils.readJson(
                    "src/test/resources/DonationTestData.json",
                    EasyGiveTestData[].class
            );

    @DataProvider(name = "easyGiveData")
    public Object[][] easyGiveData() {

        if (easyGiveTestDataList == null) {
            throw new RuntimeException("JSON file not found or empty: easyGiveTestData.json");
        }

        Object[][] data = new Object[easyGiveTestDataList.length][1];

        for (int i = 0; i < easyGiveTestDataList.length; i++) {
            data[i][0] = easyGiveTestDataList[i];
        }

        return data;
    }

    private final SingleDonationTestData[] singleDonationTestDataList =
            JsonUtils.readJson(
                    "src/test/resources/SingleDonationTestData.json",
                    SingleDonationTestData[].class
            );

    @DataProvider(name = "singleDonationData")
    public Object[][] singleDonationData() {

        if (singleDonationTestDataList == null) {
            throw new RuntimeException(
                    "JSON file not found or empty: SingleDonationTestData.json"
            );
        }

        Object[][] data = new Object[singleDonationTestDataList.length][1];

        for (int i = 0; i < singleDonationTestDataList.length; i++) {
            data[i][0] = singleDonationTestDataList[i];
        }

        return data;
    }

// ---------------- Communities Data ---------------- //


        private static final CommunityTestData[] communityTestDataList =
                JsonUtils.readJson(
                        "src/test/resources/CommunityTestData.json",
                        CommunityTestData[].class
                );

        // =========================
        // 🔎 SEARCH ONLY DATA
        // =========================
        @DataProvider(name = "searchOnlyData")
        public static Object[][] searchOnlyData() {

            Object[][] data = Arrays.stream(communityTestDataList)
                    .filter(d ->
                            "SEARCH_ONLY".equalsIgnoreCase(d.scenarioType())
                    )
                    .map(d -> new Object[]{ d })
                    .toArray(Object[][]::new);

            if (data.length == 0) {
                throw new RuntimeException("No SEARCH_ONLY data found in CommunityTestData.json");
            }

            return data;
        }

        // =========================
        // 🔁 FULL COMMUNITY FLOW DATA
        // =========================
        @DataProvider(name = "fullCommunityFlowData")
        public static Object[][] fullCommunityFlowData() {

            Object[][] data = Arrays.stream(communityTestDataList)
                    .filter(d ->
                            "FULL_COMMUNITY_FLOW".equalsIgnoreCase(d.scenarioType())
                    )
                    .map(d -> new Object[]{ d })
                    .toArray(Object[][]::new);

            if (data.length == 0) {
                throw new RuntimeException("No FULL_COMMUNITY_FLOW data found in CommunityTestData.json");
            }

            return data;
        }

    private final CommunityTestData[] moderatorCommunityTestDataList =
            JsonUtils.readJson(
                    "src/test/resources/ModeratorCommunity.json",
                    CommunityTestData[].class
            );

    @DataProvider(name = "moderatorCommunityData")
    public Object[][] moderatorCommunityData() {

        if (moderatorCommunityTestDataList == null ||
                moderatorCommunityTestDataList.length == 0) {
            throw new RuntimeException(
                    "ModeratorCommunity.json is empty or not found"
            );
        }

        return Arrays.stream(moderatorCommunityTestDataList)
                .filter(d -> "MODERATOR".equalsIgnoreCase(d.scenarioType()))
                .map(d -> new Object[]{d})
                .toArray(Object[][]::new);
    }
    private final CommunityTestData[] creationCommunityTestDataList =
            JsonUtils.readJson(
                    "src/test/resources/CreationCommunityTestData.json",
                    CommunityTestData[].class
            );

    @DataProvider(name = "creationCommunityData")
    public Object[][] creationCommunityData() {

        if (creationCommunityTestDataList == null ||
                creationCommunityTestDataList.length == 0) {
            throw new RuntimeException(
                    "CreationCommunity.json is empty or not found"
            );
        }

        return Arrays.stream(creationCommunityTestDataList)
                .filter(d -> "CREATION".equalsIgnoreCase(d.scenarioType()))
                .map(d -> new Object[]{d})
                .toArray(Object[][]::new);
    }

}

