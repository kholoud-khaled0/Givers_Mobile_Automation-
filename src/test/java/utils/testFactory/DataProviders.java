package utils.testFactory;

import org.testng.annotations.DataProvider;
import utils.common.JsonUtils;
import utils.model.LoginTestData;
import utils.model.RegisterTestData;
import utils.model.ResetPasswordTestData;
import utils.model.PersonalInformationTestData;

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
        Object[][] data = new Object[personalInformationDataList.length][1];
        for (int i = 0; i < personalInformationDataList.length; i++) {
            data[i][0] = personalInformationDataList[i];
        }
        return data;
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
}
