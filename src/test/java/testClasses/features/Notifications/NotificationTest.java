package testClasses.features.Notifications;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import screens.android.AndroidLoginScreen;
import screens.android.AndroidNotificationScreen;
import utils.model.CommunityTestData;
import utils.model.LoginTestData;
import utils.testFactory.DataProviders;

public class NotificationTest {
    @Test(
            dataProvider = "loginData", dataProviderClass = DataProviders.class
    )
    @Severity(SeverityLevel.CRITICAL)
    @Description(
            "Verify user can search for a community by name and execute scenario based on type"
    )
    public void testValidateNotification(LoginTestData loginTestData) {
        AndroidLoginScreen loginScreen = new AndroidLoginScreen();
        loginScreen.loginWithSkip(
                loginTestData.email(),
                loginTestData.password()
        );
        AndroidNotificationScreen notificationScreen = new AndroidNotificationScreen();
        notificationScreen.openAndVerifyNotifications();

    }
    }
