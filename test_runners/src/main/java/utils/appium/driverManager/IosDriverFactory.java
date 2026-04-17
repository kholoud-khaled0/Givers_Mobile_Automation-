package utils.appium.driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Capabilities;
import utils.appium.ServerManager;
import utils.common.PropertiesUtils;

public class IosDriverFactory implements DriverFactory {


    @Override
    public  AppiumDriver createDriver() {
            XCUITestOptions options = (XCUITestOptions) setCapabilities();
            return new AppiumDriver(ServerManager.getServiceUrl(),options);
    }

    @Override
    public  Capabilities setCapabilities() {
      XCUITestOptions options = new XCUITestOptions();
      options.setPlatformName("iOS");
      options.setDeviceName(PropertiesUtils.getProperty("deviceName", "iPhone Device"));
      options.setPlatformVersion(PropertiesUtils.getProperty("platformVersion", "16.0"));
      options.setApp(PropertiesUtils.getProperty("appPath"));
      options.setAutomationName("XCUITest");
      options.setCapability("wdaLocalPort", PropertiesUtils.getProperty("port", "8200"));
        if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
            options.headless();
        }
      return options;
    }
}
