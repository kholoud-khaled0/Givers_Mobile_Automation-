package testClasses.features.Needy;

import org.testng.annotations.Test;
import screens.android.AndroidLoginScreen;
import screens.android.AndroidNeedyFunctionsScreen;
import utils.model.NeedyFunctionsTestData;
import utils.testFactory.DataProviders;

public class NeedyFunctionsTest {

    @Test(dataProvider = "needyFunctionsData", dataProviderClass = DataProviders.class)
    public void testSortNeedyFlow(NeedyFunctionsTestData testData) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        AndroidNeedyFunctionsScreen needyFunctionsScreen =
                new AndroidNeedyFunctionsScreen();

        // Apply sort
        needyFunctionsScreen.applySort(testData.dropDownValues());
    }

    @Test(dataProvider = "needyFunctionsData", dataProviderClass = DataProviders.class)
    public void testFilterNeedyFlow(NeedyFunctionsTestData testData) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        AndroidNeedyFunctionsScreen needyFunctionsScreen =
                new AndroidNeedyFunctionsScreen();

        // Apply filter with all values

        needyFunctionsScreen.applyFilter(
                testData.state(),
                testData.city(),
                testData.gender(),
                testData.needySituation(),
                testData.employmentStatus(),
                testData.housingStatus(),
                testData.healthCondition()
        );
    }
}
