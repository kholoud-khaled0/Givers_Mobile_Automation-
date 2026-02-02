package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.appium.ElementsActions;
import utils.appium.Waits;
import utils.common.LogsUtils;

import java.time.Duration;

import static utils.appium.Waits.*;
import static utils.appium.driverManager.DriverManager.getDriver;

public abstract class DonationScreen {

    /* ========== Locators ========== */
    protected static final By easyGiveBtn =
            AppiumBy.androidUIAutomator("new UiSelector().description(\"\uE804, Easy Give!\")");
    protected static final By decrementCounterBtn =
            AppiumBy.accessibilityId("Decrement counter button");
    protected static final By incrementCounterBtn =
            AppiumBy.accessibilityId("Increment counter button");
    protected static final By showGiversProposalBtn =
            AppiumBy.accessibilityId("Show Givers Proposal");
    protected static final By createEasyGiveDonationBtn =
            AppiumBy.accessibilityId("Create Easy Give donation button");
    protected static final By refreshProposalBtn =
            AppiumBy.accessibilityId("Refresh proposal");
    protected static final By addNewCardBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"+ New card\")");
    protected static final By numberOfCardField =
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"number\")");
    protected static final By expiryDataField =
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"expiry\")");
    protected static final By cvvField =
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"cvc\")");
    protected static final By nameOfCardField =
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"name\")");
    protected static final By payFromOutsideBtn =
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"payFromOutsideButton\")");
    protected static final By submitBtn =
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"acssubmit\")");
    protected static final By cancelBtn =
            AppiumBy.accessibilityId("Cancel");
    protected static final By getReceiptBtn =
            AppiumBy.accessibilityId("\uE828, Get PDF receipt");
    public static final By makeAnotherDonationBtn =
            AppiumBy.accessibilityId("Make Another Donation");
    protected static final By needyBtn =
            AppiumBy.accessibilityId("\uE822, Needy");
    protected static final By donateNowBtn =
            AppiumBy.accessibilityId("Donate Now, \uF178");
    protected static final By donateNowAfterSetAmountBtn =
            AppiumBy.accessibilityId("Donate now button");
    protected static final By amountField =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");

    protected static final By paymentSuccessMsg =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Payment success!\")");


    public By paidAmountText(String amount) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"" + amount + " EGP\")"
        );
    }

    /* ========== Dynamic Locators ========== */
    public static By plusIcon(int instance) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"\uE838\").instance(" + instance + ")"
        );
    }

    public static By minusIcon(int instance) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"\uE830\").instance(" + instance + ")"
        );
    }

    public By amountField(String amount) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + amount + "\")"
        );
    }

    /* ========== Steps ========== */
    @Step("User clicks on Easy Give button")
    public void clickOnEasyGiveButton() {
        ElementsActions.click(easyGiveBtn);
    }

    @Step("User clicks on Needy button")
    public void clickOnNeedyButton() {
        ElementsActions.click(needyBtn);
    }

    @Step("User clicks on Donate Now button")
    public void clickOnDonateNowButton() {
        waitForElementToBeVisibleForPayment(donateNowBtn);
        ElementsActions.click(donateNowBtn);
    }

    @Step("User clicks on Donate Now after setting amount")
    public void clickOnDonateNowAfterSetAmountBtn() {
        waitForElementToBeVisibleForPayment(donateNowAfterSetAmountBtn);
        ElementsActions.click(donateNowAfterSetAmountBtn);
    }

    @Step("User clicks on increment counter button")
    public void clickOnIncrementCounterButton() {
        ElementsActions.click(incrementCounterBtn);
    }

    @Step("User clicks on decrement counter button")
    public void clickOnDecrementCounterButton() {
        ElementsActions.click(decrementCounterBtn);
    }

    @Step("User clicks on Show Givers Proposal button")
    public void clickOnShowGiversProposalButton() {
        ElementsActions.click(showGiversProposalBtn);
    }

    @Step("User clicks on Create Easy Give Donation button")
    public void clickOnCreateEasyGiveDonationButton() {
        ElementsActions.click(createEasyGiveDonationBtn);
    }

    @Step("User clicks on Refresh Proposal button")
    public void clickOnRefreshProposalButton() {
        ElementsActions.click(refreshProposalBtn);
    }

    @Step("User clicks on Add New Card button")
    public void clickOnAddNewCardButton() {
        waitForUIStability();
        waitForElementToBeVisibleForPayment(addNewCardBtn);
        ElementsActions.click(addNewCardBtn);
    }

    @Step("User enters card number: {cardNumber}")
    public void enterCardNumber(String cardNumber) {
        waitForElementToBeVisibleForPayment(numberOfCardField);
        ElementsActions.setValue(numberOfCardField, cardNumber);
    }

    @Step("User enters expiry date: {expiryDate}")
    public void enterExpiryDate(String expiryDate) {
        ElementsActions.setValue(expiryDataField, expiryDate);
    }

    @Step("User enters CVV")
    public void enterCVV(String cvv) {
        ElementsActions.setValue(cvvField, cvv);
    }

    @Step("User enters card holder name: {name}")
    public void enterCardHolderName(String name) {
        ElementsActions.setValue(nameOfCardField, name);
    }

    @Step("User clicks on Pay From Outside button")
    public void clickOnPayFromOutsideButton() {
        waitForElementToBeClickableForPayment(payFromOutsideBtn);
        ElementsActions.click(payFromOutsideBtn);
    }
    protected static final By allNeedies =
            AppiumBy.androidUIAutomator(
                    "new UiSelector()" +
                            ".className(\"android.view.ViewGroup\")" +
                            ".descriptionContains(\"EGP raised\")"
            );

    @Step("Select random needy dynamically")
    protected void selectRandomNeedy() {

        int maxScrolls = 5;
        int scrollCount = 0;

        while (scrollCount < maxScrolls) {

            var needies = ElementsActions.findElements(allNeedies);

            if (!needies.isEmpty()) {
                int randomIndex = new java.util.Random().nextInt(needies.size());
                needies.get(randomIndex).click();

                return;
            }

            ElementsActions.scrollDownSmall();
            scrollCount++;
        }

        throw new AssertionError("No needy found after scrolling");
    }


    @Step("User clicks on Submit button")
    public void clickOnSubmitButton() {
        waitForElementToBeVisibleForPayment(submitBtn);
        waitForElementToBeClickableForPayment(submitBtn);
        ElementsActions.click(submitBtn);
    }

    @Step("User clicks on Cancel button")
    public void clickOnCancelButton() {
        waitForElementToBeVisibleForPayment(cancelBtn);
        ElementsActions.click(cancelBtn);
    }

    @Step("User clicks on Get Receipt button")
    public void clickOnGetReceiptButton() {
        waitForElementToBeVisibleForPayment(getReceiptBtn);
        ElementsActions.click(getReceiptBtn);
    }

    @Step("User clicks on Make Another Donation button")
    public void clickOnMakeAnotherDonationButton() {
        waitForElementToBeVisibleForPayment(makeAnotherDonationBtn);
        ElementsActions.click(makeAnotherDonationBtn);
    }

    @Step("User clicks on plus icon with instance {instance}")
    public void clickOnPlusIcon(int instance) {
        ElementsActions.click(plusIcon(instance));
    }

    @Step("User clicks on minus icon with instance {instance}")
    public void clickOnMinusIcon(int instance) {
        ElementsActions.click(minusIcon(instance));
    }

    @Step("User sets donation amount to {amount}")
    public void setAmountValue(String amount) {
        waitForElementToBeVisible(amountField);
        ElementsActions.clear(amountField);
        ElementsActions.setValue(amountField, amount);
        if (amount.length() >= 4) {
            char lastDigit = amount.charAt(amount.length() - 1);
            ElementsActions.sendKeys(amountField, String.valueOf(lastDigit));
        }
    }

    @Step("Set donation amount {amount} and check for min/max error")
    public boolean setAmountAndStopIfError(String amount) {
        setAmountValue(amount);
        waitForUIStability();

        By maxAmountErrorLocator = AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"can not exceed\")"
        );
        By minAmountErrorLocator = AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"can not be less than\")"
        );

        boolean isErrorDisplayed = ElementsActions.isDisplayed(maxAmountErrorLocator)
                || ElementsActions.isDisplayed(minAmountErrorLocator);

        if (isErrorDisplayed) {
            LogsUtils.warn("Error message displayed for amount: " + amount + ". Stopping the flow.");
            return true;
        } else {
            LogsUtils.info("No error message for amount: " + amount + ". Continuing flow.");
            clickOnDonateNowAfterSetAmountBtn();
            return false;
        }
    }


    @Step("User completes payment with new card")
    public void completePaymentWithNewCard() {
        clickOnAddNewCardButton();
        waitForUIStability();
        enterCardNumber("4111 1111 1111 1111");
        enterExpiryDate("12/29");
        enterCVV("123");
        enterCardHolderName("TEST");
        clickOnPayFromOutsideButton();
        waitForUIStability();
        clickOnSubmitButton();
    }

    protected int getRaisedAmountFromDonationScreen() {

        By raisedText =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"EGP raised\")"
                );

        Waits.waitForElementToBeVisible(raisedText);

        String text = ElementsActions.getText(raisedText);
        // مثال: "0 EGP raised"

        String number = text.replaceAll("[^0-9]", "");

        return Integer.parseInt(number);
    }
    protected int getMonthlyTargetAmountFromDonationScreen() {

        By targetText =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"Monthly target\")"
                );

        // 👈 لازم نستنى ده تحديدًا
        Waits.waitForElementToBeVisible(targetText);

        String text = ElementsActions.getText(targetText);
        // مثال: "Monthly target: 48441 EGP"

        String number = text.replaceAll("[^0-9]", "");

        return Integer.parseInt(number);
    }


    public int getRaisedOfAmount() {
        By raisedOfAmount =
                AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Raised of\")");
        waitForElementToBeVisibleForPayment(raisedOfAmount);
        String raisedText = ElementsActions.getText(raisedOfAmount);
        String amountOnly = raisedText.replaceAll("[^0-9]", "");
        return Integer.parseInt(amountOnly);
    }
    @Step("Get actual needed amount from donation screen")
    protected int getActualNeededAmountFromDonationScreen() {

        int raised  = getRaisedAmountFromDonationScreen();
        int target  = getMonthlyTargetAmountFromDonationScreen();

        LogsUtils.info("Raised = " + raised + ", Target = " + target);

        return target - raised;
    }


    public static void waitForElementToBeVisibleForPayment(By locator) {
        waitForElementToBeVisible(locator, Duration.ofSeconds(120));
    }

    public static void waitForElementToBeClickableForPayment(By locator) {
        waitForElementToBeClickable(locator, Duration.ofSeconds(120));
    }

    public int getTargetAmount() {
        By targetAmount = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"EGP\")");
        ElementsActions.scrollToElement(targetAmount);
        waitForElementToBeVisibleForPayment(targetAmount);
        String targetText = ElementsActions.getText(targetAmount);
        String amountOnly = targetText.replaceAll("[^0-9]", "");
        return Integer.parseInt(amountOnly);
    }

    public int getActualNeededAmount() {
        int target = getTargetAmount();
        int raised = getRaisedOfAmount();
        return raised - target;
    }
    @Step("Verify payment success message and paid amount {expectedAmount}")
    public void assertPaymentSuccessAndAmount(int expectedAmount) {

        // Assert success message
        waitForElementToBeVisibleForPayment(paymentSuccessMsg);
        boolean successDisplayed = ElementsActions.isDisplayed(paymentSuccessMsg);

        if (!successDisplayed) {
            throw new AssertionError("Payment success message is NOT displayed");
        }

        // Assert paid amount
        By amountLocator = paidAmountText(String.valueOf(expectedAmount));
        waitForElementToBeVisibleForPayment(amountLocator);

        String actualAmountText = ElementsActions.getText(amountLocator);

        if (!actualAmountText.contains(String.valueOf(expectedAmount))) {
            throw new AssertionError(
                    "Paid amount is incorrect. Expected: "
                            + expectedAmount + " EGP but found: " + actualAmountText
            );
        }

        LogsUtils.info("Payment success verified with correct amount: " + expectedAmount + " EGP");
    }

    @Step("User donates to needy dynamically")
    public void donateToNeedyByIndex(Integer amount) {

        // 1️⃣ اختار Needy
        selectRandomNeedy();

        // 2️⃣ Donate Now
        clickOnDonateNowButton();

        int actualNeededAmount =
                (amount != null)
                        ? amount
                        : getActualNeededAmountFromDonationScreen();

        setAmountValue(String.valueOf(actualNeededAmount));

        boolean hasError =
                setAmountAndStopIfError(String.valueOf(actualNeededAmount));

        if (!hasError) {
            completePaymentWithNewCard();
            waitForUIStability();
            clickOnCancelButton();
            assertPaymentSuccessAndAmount(actualNeededAmount);
        }
    }

    @Step("User get Another Donate to needy with index {index}")
    public void getAnotherDonate( Integer amount) {

        int actualNeededAmount = (amount != null) ? amount : getActualNeededAmount();
        System.out.println("Actual needed amount = " + actualNeededAmount);

        setAmountValue(String.valueOf(actualNeededAmount));

        boolean hasError = setAmountAndStopIfError(String.valueOf(actualNeededAmount));
        if (!hasError) {
            completePaymentWithNewCard();
            waitForUIStability();
            clickOnCancelButton();
            assertPaymentSuccessAndAmount(actualNeededAmount);
        }
    }
    protected static final By raisedAmountText =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"EGP raised\")"
            );
    protected WebElement getNeedyCardByRaisedText() {

        Waits.waitForElementToBeVisible(raisedAmountText);

        WebElement raisedText =
                getDriver().findElement(raisedAmountText);

        return raisedText.findElement(
                By.xpath("./ancestor::android.view.ViewGroup")
        );
    }
    @Step("Select needy using raised amount text")
    public void selectNeedyByRaisedAmount() {

        int maxScrolls = 10;

        for (int i = 0; i < maxScrolls; i++) {
            try {
                WebElement needyCard = getNeedyCardByRaisedText();
                needyCard.click();
                return;
            } catch (Exception e) {
                ElementsActions.scrollDownSmall();
            }
        }

        throw new RuntimeException(
                "Needy card with 'EGP raised' not found after scrolling"
        );
    }
    @Step("User donates to needy using raised amount anchor")
    public void donateToNeedy(Integer amount) {

        selectNeedyByRaisedAmount();   // 🔥 الحل الثابت
        clickOnDonateNowButton();

        int donationAmount =
                (amount != null) ? amount : getActualNeededAmount();

        setAmountValue(String.valueOf(donationAmount));

        boolean hasError =
                setAmountAndStopIfError(String.valueOf(donationAmount));

        if (!hasError) {
            completePaymentWithNewCard();
            waitForUIStability();
            clickOnCancelButton();
            assertPaymentSuccessAndAmount(donationAmount);
        }
    }

}
