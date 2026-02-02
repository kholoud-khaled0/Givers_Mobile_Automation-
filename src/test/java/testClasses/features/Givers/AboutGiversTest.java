package testClasses.features.Givers;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import screens.android.AndroidGiversScreen;
import screens.android.AndroidLoginScreen;
import utils.common.assertions.AssertionManager;
import utils.model.LoginTestData;
import utils.testFactory.DataProviders;

public class AboutGiversTest {
//    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
//    @Severity(SeverityLevel.NORMAL)
//    @Description("Verify About Us page opens and has visible dynamic content")
//    public void testAboutUsFlow(LoginTestData testData) {
//
//        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
//        loginScreen.loginWithSkip(testData.email(), testData.password());
//
//        AndroidGiversScreen givers = new AndroidGiversScreen();
//        givers.openMoreMenu();
//
//        // Open and verify About Us page dynamically
//        givers.openAndVerifyAboutUsPage();
//
//        // Navigate back
//        givers.goBack();
//
//        AssertionManager.assertAll(null);
//    }
//    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
//    @Severity(SeverityLevel.NORMAL)
//    @Description("Verify Terms & Conditions page opens and displays content")
//    public void testTermsConditionsFlow(LoginTestData testData) {
//        AndroidLoginScreen login = new AndroidLoginScreen();
//        login.loginWithSkip(testData.email(), testData.password());
//
//        AndroidGiversScreen givers = new AndroidGiversScreen();
//        givers.openMoreMenu();
//        givers.openAndVerifyTermsConditionsPage();
//        givers.goBack();
//        AssertionManager.assertAll(null);
//    }
//
//    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
//    @Severity(SeverityLevel.NORMAL)
//    @Description("Verify Privacy Policy page opens and displays content")
//    public void testPrivacyPolicyFlow(LoginTestData testData) {
//        AndroidLoginScreen login = new AndroidLoginScreen();
//        login.loginWithSkip(testData.email(), testData.password());
//
//        AndroidGiversScreen givers = new AndroidGiversScreen();
//        givers.openMoreMenu();
//        givers.openAndVerifyPrivacyPolicyPage();
//        givers.goBack();
//        AssertionManager.assertAll(null);
//    }
//
//    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
//    @Severity(SeverityLevel.NORMAL)
//    @Description("Verify Community Guidelines page opens and displays content")
//    public void testCommunityGuidelinesFlow(LoginTestData testData) {
//        AndroidLoginScreen login = new AndroidLoginScreen();
//        login.loginWithSkip(testData.email(), testData.password());
//
//        AndroidGiversScreen givers = new AndroidGiversScreen();
//        givers.openMoreMenu();
//        givers.openAndVerifyCommunityGuidelinesPage();
//        givers.goBack();
//        AssertionManager.assertAll(null);
//    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify FAQs page opens and displays content")
    public void testFAQsFlow(LoginTestData testData) {
        AndroidLoginScreen login = new AndroidLoginScreen();
        login.loginWithSkip(testData.email(), testData.password());

        AndroidGiversScreen givers = new AndroidGiversScreen();
        givers.openMoreMenu();
        givers.openAndVerifyFAQsPage();
        givers.goBack();
        AssertionManager.assertAll(null);
    }
//    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Verify language can be changed from English to Arabic and back")
//    public void testChangeLanguageFlow(LoginTestData testData) {
//
//        AndroidLoginScreen login = new AndroidLoginScreen();
//        login.loginWithSkip(testData.email(), testData.password());
//
//        AndroidGiversScreen givers = new AndroidGiversScreen();
//        givers.openMoreMenu();
//
//        // Execute language change scenario
//        givers.changeLanguageAndVerifyFlow();
//
//        AssertionManager.assertAll(null);
//    }

}

