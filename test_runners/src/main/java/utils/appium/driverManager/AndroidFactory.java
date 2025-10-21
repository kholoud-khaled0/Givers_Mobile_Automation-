package utils.appium.driverManager;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import utils.appium.ServerManager;
import utils.common.PropertiesUtils;

public class AndroidFactory implements DriverFactory{
    @Override
    public  AppiumDriver createDriver() {
            UiAutomator2Options options = (UiAutomator2Options) setCapabilities();
            return new AppiumDriver(ServerManager.getServiceUrl(), options);
    }

    @Override
    public   Capabilities setCapabilities() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName(PropertiesUtils.getProperty("deviceName", "Android Device"));
        options.setApp(PropertiesUtils.getProperty("appPath"));
        options.setAutomationName("UiAutomator2");
        options.setCapability("systemPort", PropertiesUtils.getProperty("port", "8100"));
        if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
            options.headless();
        }
        return options;
    }
}
