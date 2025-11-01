package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.android.AndroidActions;
import utils.appium.ElementsActions;
import utils.common.assertions.AssertionManager;

public abstract class WelcomeScreen {

    protected static final By continueBtn = AppiumBy.accessibilityId("Continue");
    protected static final By skipBtn = AppiumBy.accessibilityId("Skip");
    protected static final By letsGoBtn = AppiumBy.accessibilityId("Let's Go!");

    protected static final By signUpPageTitle = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Let's Sign You up First!\")"
    );

    // -------- Actions -------- //

    @Step("Click Continue button")
    public void clickContinue() {
        ElementsActions.click(continueBtn);
    }

    @Step("Click Skip button")
    public void clickSkip() {
        ElementsActions.click(skipBtn);
    }

    @Step("Click Let's Go button")
    public void clickLetsGo() {
        ElementsActions.click(letsGoBtn);
    }

    // -------- Assertions -------- //

    @Step("Verify that Sign Up page is displayed")
    public void verifySignUpPageIsDisplayed() {
        boolean isDisplayed = AndroidActions.isElementDisplayed(signUpPageTitle, 6);
        AssertionManager.assertTrue(
                isDisplayed,
                "Expected 'Let's Sign You up First!' title to be visible on Sign Up page"
        );
    }

    // -------- Abstract Scenarios -------- //

    public abstract void skipFlow();
    public abstract void continueThenSkipFlow();
    public abstract void fullContinueFlow();
}
