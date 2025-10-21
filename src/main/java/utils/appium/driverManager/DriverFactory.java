package utils.appium.driverManager;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Capabilities;

interface DriverFactory {

    abstract AppiumDriver createDriver() ;

    abstract Capabilities setCapabilities() ;
}
