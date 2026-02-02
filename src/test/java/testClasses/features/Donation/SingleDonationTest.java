package testClasses.features.Donation;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import screens.android.AndroidDonationScreen;
import screens.android.AndroidLoginScreen;
import utils.model.SingleDonationTestData;
import utils.testFactory.DataProviders;

public class SingleDonationTest {

    @Test(dataProvider = "singleDonationData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can complete Single donation with exact needed amount")
    public void testSingleDonationExactAmount(SingleDonationTestData data) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(data.email(), data.password());

        AndroidDonationScreen donationScreen = new AndroidDonationScreen();
        donationScreen.donationWithExactNeededAmount();
    }

    @Test(dataProvider = "singleDonationData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify error is shown if donation amount is less than minimum")
    public void testSingleDonationBelowMin(SingleDonationTestData data) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(data.email(), data.password());

        AndroidDonationScreen donationScreen = new AndroidDonationScreen();
        donationScreen.donationBelowMinAmount("49");
    }

    @Test(dataProvider = "singleDonationData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify error is shown if donation amount is more than actual needed amount")
    public void testSingleDonationAboveMax(SingleDonationTestData data) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(data.email(), data.password());

        AndroidDonationScreen donationScreen = new AndroidDonationScreen();
        donationScreen.donationAboveMaxAmount();
    }

    @Test(dataProvider = "singleDonationData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can make another donation without completing the full needed amount")
    public void testSingleDonationWithMakeAnotherDonation(SingleDonationTestData data) {

        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(data.email(), data.password());

        AndroidDonationScreen donationScreen = new AndroidDonationScreen();
        donationScreen.donationWithMakeAnotherDonation();
    }

}
