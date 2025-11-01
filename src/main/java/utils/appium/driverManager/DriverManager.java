package utils.appium.driverManager;

import io.appium.java_client.AppiumDriver;
import utils.appium.ServerManager;
import utils.common.LogsUtils;
import utils.common.PropertiesUtils;

public class DriverManager {

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        String platformName = PropertiesUtils.getProperty("platformName");

        try {
            // ✅ نبدأ السيرفر لو مش شغال
            ServerManager.startService();

            // ✅ نحاول نفضي port 8100 قبل البدء (لتفادي UiAutomator2 port busy)
            try {
                Runtime.getRuntime().exec("npx kill-port 8100");
                Thread.sleep(1000);
                System.out.println("[INFO] Cleared UiAutomator2 port 8100 before new session");
            } catch (Exception e) {
                System.out.println("[WARN] Could not clear port 8100: " + e.getMessage());
            }

            if (driver.get() == null) {
                if ("Android".equalsIgnoreCase(platformName)) {
                    driver.set(new AndroidFactory().createDriver());
                } else if ("iOS".equalsIgnoreCase(platformName)) {
                    driver.set(new IosDriverFactory().createDriver());
                } else {
                    LogsUtils.error("Unsupported platform: " + platformName);
                    throw new IllegalArgumentException("Unsupported platform: " + platformName);
                }
            }
        } catch (Exception e) {
            LogsUtils.error("❌ Failed to initialize driver: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
                System.out.println("✅ Driver session closed successfully");
            } catch (Exception e) {
                System.out.println("[WARN] Failed to quit driver: " + e.getMessage());
            } finally {
                driver.remove();
            }

            // ✅ بعد كل تيست نوقف السيرفر
            ServerManager.stopService();
        }
    }

    public static void setDriver(AppiumDriver appiumDriver) {
        driver.set(appiumDriver);
    }
}
