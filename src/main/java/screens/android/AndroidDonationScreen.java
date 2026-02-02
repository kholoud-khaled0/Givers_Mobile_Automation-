package screens.android;

import io.qameta.allure.Step;
import screens.base.DonationScreen;

import static utils.appium.ElementsActions.scrollToBottom;
import static utils.appium.Waits.waitForUIStability;

public class AndroidDonationScreen extends DonationScreen {

    @Step("User completes Easy Give donation flow")
    public void completeEasyGiveDonation() {

        clickOnEasyGiveButton();
        clickOnPlusIcon(0);
        clickOnPlusIcon(1);
        clickOnShowGiversProposalButton();
        clickOnRefreshProposalButton();
        clickOnCreateEasyGiveDonationButton();

        waitForUIStability();

        clickOnAddNewCardButton();
        waitForUIStability();

        enterCardNumber("4111 1111 1111 1111");
        enterExpiryDate("12/29");
        enterCVV("123");
        enterCardHolderName("TEST");

        clickOnPayFromOutsideButton();
        clickOnSubmitButton();

        waitForUIStability();
        clickOnMakeAnotherDonationButton();
    }

    // =========================
    // SINGLE DONATION – EXACT
    // =========================
    @Step("Verify user can complete Single donation with exact needed amount")
    public void donationWithExactNeededAmount() {

        clickOnNeedyButton();

        donateToNeedyByIndex(null);
    }

    // =========================
    // MAKE ANOTHER DONATION
    // =========================
    @Step("Verify user can make another donation without finishing the needed amount")
    public void donationWithMakeAnotherDonation() {

        clickOnNeedyButton();

        donateToNeedyByIndex(null);

        scrollToBottom();
        clickOnMakeAnotherDonationButton();
    }

    // =========================
    // BELOW MIN AMOUNT
    // =========================
    @Step("User attempts Single donation below minimum amount")
    public void donationBelowMinAmount(String belowMinAmount) {

        clickOnNeedyButton();

        donateToNeedyByIndex(Integer.parseInt(belowMinAmount));
    }

    // =========================
    // ABOVE MAX AMOUNT
    // =========================
    @Step("User attempts Single donation above maximum needed amount")
    public void donationAboveMaxAmount() {

        clickOnNeedyButton();

        donateToNeedyByIndex(
                getActualNeededAmountFromDonationScreen() + 1000
        );
    }
}
