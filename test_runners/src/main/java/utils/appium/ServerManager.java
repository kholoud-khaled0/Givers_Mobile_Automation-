package utils.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.URL;

public class ServerManager {
    private static AppiumDriverLocalService instance;

    private static AppiumDriverLocalService getInstance() {
        if (instance == null) {
            // ✅ حددي مكان ملف Appium الرئيسي
            AppiumServiceBuilder builder = new AppiumServiceBuilder()
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723)
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                    .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                    .withArgument(GeneralServerFlag.LOG_NO_COLORS);

            instance = AppiumDriverLocalService.buildService(builder);
        }
        return instance;
    }

    public static void startService() {
        getInstance().start();
        System.out.println("✅ Appium server started at: " + getInstance().getUrl());
    }

    public static void stopService() {
        if (instance != null && instance.isRunning()) {
            instance.stop();
            System.out.println("🛑 Appium server stopped.");
        }
    }

    public static URL getServiceUrl() {
        return getInstance().getUrl();
    }
}
