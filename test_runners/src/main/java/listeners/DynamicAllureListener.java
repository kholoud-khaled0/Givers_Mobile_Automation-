package listeners;


import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import utils.common.LogsUtils;
import utils.common.PropertiesUtils;
import java.lang.reflect.Field;
import java.util.UUID;


public class DynamicAllureListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        Object testInstance = testResult.getInstance();
        try {
            Field storyField = testInstance.getClass().getField("story");
            Field descriptionField = testInstance.getClass().getField("description");
            String story = (String) storyField.get(testInstance);
            String description = (String) descriptionField.get(testInstance);
            if (story != null ) {
                Allure.label("story", story);
            }
            if (description != null) {
                Allure.getLifecycle().updateTestCase(tc -> tc.setDescription(description));
            }
            Allure.getLifecycle().updateTestCase(tc->
                    tc.setHistoryId(UUID.nameUUIDFromBytes((PropertiesUtils.getProperty("platformName")+story + description).getBytes()).toString())
            );
        } catch (Exception e) {
            LogsUtils.error("Failed to set story or description: " + e.getMessage());
        }
    }

}
