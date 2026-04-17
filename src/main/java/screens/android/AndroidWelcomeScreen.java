package screens.android;

import io.qameta.allure.Step;
import screens.base.WelcomeScreen;

public class AndroidWelcomeScreen extends WelcomeScreen {

    @Override
    @Step("Flow 1: Click Skip directly and verify Sign Up screen")
    public void skipFlow() {
        clickSkip();
        verifySignUpDisplayed();
    }

    @Override
    @Step("Flow 2: Click Continue, then Skip, and verify Sign Up screen")
    public void continueThenSkipFlow() {
        clickContinue();
        clickSkip();
        verifySignUpDisplayed();
    }

    @Override
    @Step("Flow 3: Click Continue twice, then Let's Go, and verify Sign Up screen")
    public void fullContinueFlow() {
        clickContinue();
        clickContinue();
        clickLetsGo();
        verifySignUpDisplayed();
    }
}
