package testClasses.features.Donation;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import screens.android.AndroidDonationScreen;
import screens.android.AndroidLoginScreen;
import utils.model.EasyGiveTestData;
import utils.testFactory.DataProviders;

import java.util.Map;

public class DonationHistoryTest {
    @Test(dataProvider = "easyGiveData", dataProviderClass = DataProviders.class)
    @Description("Verify donation appears correctly in Monthly Donations with correct amount and commission")
    @Severity(SeverityLevel.CRITICAL)
    public void testDonationHistory(EasyGiveTestData data) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(data.email(), data.password());

        AndroidDonationScreen donationScreen = new AndroidDonationScreen();

        // Step 1: Complete donation
        Map<String, String> donationData = donationScreen.completeEasyGiveDonation();

        String amount = donationData.get("amount");
        String commission = donationData.get("commission");

        // Step 2: Navigate to history
        donationScreen.openHistoryDonations();

        // Step 3: Validate history
        donationScreen.validateDonationHistory(amount, commission);

        // Step 4: Validate details
        donationScreen.validateDonationDetails(amount, commission);
    }

}
