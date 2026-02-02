package screens.base;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.appium.ElementsActions;
import utils.appium.Waits;

import java.util.List;

import static utils.appium.driverManager.DriverManager.getDriver;

public class NotificationScreen {

    // ---------- Locators ----------
    protected static final By homeBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Home\")");

    protected static final By notificationsBtn =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"\")");

    protected static final By notificationsTitle =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Notifications\")");

    // Any notification item (dynamic – no static text)
    protected static final By notificationItems =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.view.ViewGroup\")" +
                            ".descriptionContains(\",\")"
            );

    // ---------- Actions ----------

    @Step("Open Notifications screen")
    public void openNotifications() {
        Waits.waitForElementToBeClickable(homeBtn);
        ElementsActions.click(homeBtn);

        Waits.waitForElementToBeClickable(notificationsBtn);
        ElementsActions.click(notificationsBtn);

        Waits.waitForElementToBeVisible(notificationsTitle);
    }

    @Step("Verify notifications exist and list is scrollable")
    public void verifyNotificationsExist() {

        boolean found = false;

        for (int i = 0; i < 3; i++) {
            List<WebElement> items =
                    getDriver().findElements(notificationItems);

            if (!items.isEmpty()) {
                found = true;
                break;
            }

            ElementsActions.scrollToBottom();
        }

        if (!found) {
            throw new AssertionError("No notifications found in Notifications screen");
        }
    }

    @Step("Verify notification content structure")
    public void verifyNotificationStructure() {

        List<WebElement> items =
                getDriver().findElements(notificationItems);

        if (items.isEmpty()) {
            throw new AssertionError("Notifications list is empty");
        }

        for (WebElement item : items) {
            String desc = item.getAttribute("content-desc");

            if (desc == null || !desc.contains(",")) {
                throw new AssertionError(
                        "Invalid notification content: " + desc
                );
            }
        }
    }
}
