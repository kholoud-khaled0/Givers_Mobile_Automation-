package screens.android;

import io.qameta.allure.Step;
import screens.base.DonationScreen;

import java.util.HashMap;
import java.util.Map;

import static utils.appium.ElementsActions.scrollToBottom;
import static utils.appium.Waits.waitForUIStability;

public class AndroidDonationScreen extends DonationScreen {

    public Map<String, String> completeEasyGiveDonation() {

        clickOnEasyGiveButton();
        clickOnPlusIcon(0);
        clickOnPlusIcon(1);

        clickOnShowGiversProposalButton();
        clickOnRefreshProposalButton();
        clickOnCreateEasyGiveDonationButton();

        waitForUIStability();

        String amount = getDonationAmountFromUI();
        String commission = getBankCommissionFromUI();

        clickOnAddNewCardButton();
        waitForUIStability();

        enterCardNumber("4111 1111 1111 1111");
        enterExpiryDate("12/29");
        enterCVV("123");
        enterCardHolderName("TEST");

        clickOnPayFromOutsideButton();
        clickOnSubmitButton();

        waitForUIStability();


        Map<String, String> result = new HashMap<>();
        result.put("amount", amount);
        result.put("commission", commission);

        return result;
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
