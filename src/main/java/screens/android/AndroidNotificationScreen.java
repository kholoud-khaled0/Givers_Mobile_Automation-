package screens.android;

import io.qameta.allure.Step;
import screens.base.NotificationScreen;

public class AndroidNotificationScreen extends NotificationScreen {

    @Step("Open notifications and verify notifications exist")
    public AndroidNotificationScreen openAndVerifyNotifications() {

        openNotifications();
        verifyNotificationsExist();
        verifyNotificationStructure();

        return this;
    }
}
