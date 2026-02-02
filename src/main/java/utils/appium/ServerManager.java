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
            String appiumMainJsPath = "C:\\Users\\Kholoud\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

            AppiumServiceBuilder builder = new AppiumServiceBuilder()
                    .withAppiumJS(new File(appiumMainJsPath))
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
        try {
            if (instance == null || !instance.isRunning()) {
                getInstance().start();
                System.out.println(" Appium server started at: " + getInstance().getUrl());
            } else {
                System.out.println("[INFO] Appium server already running.");
            }
        } catch (Exception e) {
            System.out.println(" Failed to start Appium server: " + e.getMessage());
        }
    }

    public static void stopService() {
        try {
            if (instance != null && instance.isRunning()) {
                instance.stop();
                System.out.println(" Appium server stopped.");
            } else {
                System.out.println("[INFO] No Appium server to stop.");
            }
        } catch (Exception e) {
            System.out.println("[WARN] Error stopping Appium server: " + e.getMessage());
        }
    }

    public static URL getServiceUrl() {
        return getInstance().getUrl();
    }
}
