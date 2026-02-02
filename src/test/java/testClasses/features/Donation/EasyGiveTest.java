package testClasses.features.Donation;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import screens.android.AndroidDonationScreen;
import screens.android.AndroidLoginScreen;
import utils.model.EasyGiveTestData;
import utils.testFactory.DataProviders;

@Feature("Easy Give Feature")
@Story("Easy Give Donation Flow")
public class EasyGiveTest {

    @Test(dataProvider = "easyGiveData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can complete Easy Give donation flow successfully")
    public void testEasyGiveFullFlow(EasyGiveTestData data) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(data.email(), data.password());

        // ------------------- Easy Give Flow ------------------- //
        AndroidDonationScreen donationScreen = new AndroidDonationScreen();
        donationScreen.completeEasyGiveDonation();
    }
}
