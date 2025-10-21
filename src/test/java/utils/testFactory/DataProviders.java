package utils.testFactory;

import org.testng.annotations.DataProvider;
import utils.common.JsonUtils;
import utils.model.LoginTestData;

public class DataProviders {

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
}
