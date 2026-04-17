package utils.appium.driverManager;

import io.appium.java_client.AppiumDriver;
import utils.common.LogsUtils;
import utils.common.PropertiesUtils;



public class DriverManager {
   static  ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        String platformName= PropertiesUtils.getProperty("platformName");
        if(driver.get() == null) {
            if("Android".equalsIgnoreCase(platformName)){
               driver.set(new AndroidFactory().createDriver());
            } else if("iOS".equalsIgnoreCase(platformName)) {
              driver.set(new IosDriverFactory().createDriver());
            } else {
                LogsUtils.error("Unsupported platform: " + platformName);
                throw new IllegalArgumentException("Unsupported platform: " + platformName);
            }
        }
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }


    public static void setDriver(AppiumDriver appiumDriver) {
        driver.set(appiumDriver);
    }

}
