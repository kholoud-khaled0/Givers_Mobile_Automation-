package testClasses.features.Needy;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import screens.android.AndroidCreateNeedyProfileScreen;
import screens.android.AndroidLoginScreen;
import utils.common.RandomNeedyDataGenerator;
import utils.common.assertions.AssertionManager;
import utils.model.NeedyProfileTestData;
import utils.testFactory.DataProviders;

public class CreateNeedyProfileTest {

    @Test(dataProvider = "needyProfileData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testNeedyProfileAgeAbove24(NeedyProfileTestData testData) {
        performNeedyTestFlow(testData, true);
    }

    @Test(dataProvider = "needyProfileData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testNeedyProfileAgeLessOrEqual24(NeedyProfileTestData testData) {
        performNeedyTestFlow(testData, false);
    }
    @Test(dataProvider = "needyProfileData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testNeedyProfile_Single(NeedyProfileTestData testData) {
        performNeedyTestFlow(testData, true);
    }
    @Test(dataProvider = "needyProfileData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testNeedyProfile_Married(NeedyProfileTestData testData) {
        performNeedyTestFlow(testData, true);
    }
    @Test(dataProvider = "needyProfileData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testNeedyProfile_Divorced(NeedyProfileTestData testData) {
        performNeedyTestFlow(testData, true);
    }
    @Test(dataProvider = "needyProfileData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testNeedyProfile_Widowed(NeedyProfileTestData testData) {
        performNeedyTestFlow(testData, true);
    }
    @Test(dataProvider = "needyProfileData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testNeedyProfile_Abandoned(NeedyProfileTestData testData) {
        performNeedyTestFlow(testData, true);
    }
    @Test(dataProvider = "needyProfileData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void testNeedyProfile_SpouseInPrison(NeedyProfileTestData testData) {
        performNeedyTestFlow(testData, true);
    }

    private void performNeedyTestFlow(NeedyProfileTestData testData, boolean isAbove24) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        AndroidCreateNeedyProfileScreen profileScreen = new AndroidCreateNeedyProfileScreen();

        // Generate dynamic values
        String dynamicFirstName = RandomNeedyDataGenerator.generateArabicName();
        String dynamicID = isAbove24
                ? RandomNeedyDataGenerator.generateNationalIdAgeAbove24()
                : RandomNeedyDataGenerator.generateNationalIdAgeLessOrEqual24();
        String dynamicMotherName = RandomNeedyDataGenerator.generateArabicMotherName();
        String dynamicPhone = RandomNeedyDataGenerator.generateValidEgyptianPhone();

        profileScreen.performCreateNeedyFlow(
                dynamicID,
                dynamicFirstName,
                testData.maritalStatus(),
                dynamicMotherName,
                dynamicPhone,
                testData.needyDocuments(),
                testData.memberDocuments(),
                testData.state(),
                testData.city(),
                testData.address(),
                testData.housingCondition(),
                testData.amount(),
                testData.relationShip(),
                testData.story(),
                testData.note()
        );

        AssertionManager.assertAll(null);
    }
}
