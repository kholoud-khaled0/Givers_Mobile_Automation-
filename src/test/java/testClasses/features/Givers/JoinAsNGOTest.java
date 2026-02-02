package testClasses.features.Givers;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import screens.android.AndroidLoginScreen;
import screens.android.AndroidGiversScreen;
import screens.base.GiversScreen;
import utils.common.assertions.AssertionManager;
import utils.model.LoginTestData;
import utils.testFactory.DataProviders;

@Feature("Givers Feature")
@Story("Join as NGO Flow")
public class JoinAsNGOTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can submit Join as NGO request dynamically")
    public void testJoinAsNGO(LoginTestData testData) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(testData.email(), testData.password());

        AndroidGiversScreen givers = new AndroidGiversScreen();
        givers.openMoreMenu();
        givers.scrollToJoinAsNGOAndClick();

        givers.verifyOnJoinAsNGOPage();

        String dynamicNGOName = "NGO" + GiversScreen.generateRandomString(6);
        String dynamicContact = "Contact" + GiversScreen.generateRandomString(5);
        String dynamicEmail = "ngo" + System.currentTimeMillis() + "@test.com";
        String dynamicPhone = "10" + (int)(Math.random() * 1000000000);


        givers.enterNGOData(dynamicNGOName, dynamicContact, dynamicEmail, dynamicPhone);

        givers.clickSubmitNGORequest();

        givers.verifyNGORequestSuccess();

        AssertionManager.assertAll(null);
    }
}
