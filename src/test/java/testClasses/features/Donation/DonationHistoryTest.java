package testClasses.features.Donation;

import org.testng.annotations.Test;
import screens.android.AndroidDonationScreen;
import screens.android.AndroidLoginScreen;
import utils.model.EasyGiveTestData;
import utils.testFactory.DataProviders;

public class DonationHistory {
    @Test(dataProvider = "easyGiveData", dataProviderClass = DataProviders.class)
    public void testDonationHistory(EasyGiveTestData data) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(data.email(), data.password());

        AndroidDonationScreen donationScreen = new AndroidDonationScreen();

        String amount = donationScreen.completeEasyGiveDonation();
        donationScreen.openMonthlyDonations();
        donationScreen.validateDonationHistory(amount);

        donationScreen.validateDonationDetails(amount);
    }

}
