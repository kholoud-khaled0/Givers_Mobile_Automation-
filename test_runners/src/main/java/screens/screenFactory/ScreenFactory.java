package screens.screenFactory;

import screens.android.AndroidLoginScreen;
import utils.common.PropertiesUtils;

public class ScreenFactory {

    public static AndroidLoginScreen getLoginScreen() {
        String platformName = PropertiesUtils.getProperty("platformName");

        if ("Android".equalsIgnoreCase(platformName)) {
            return new AndroidLoginScreen();
        } else {
            // مؤقتاً نرجع AndroidLoginScreen برضو لحد ما نضيف IosLoginScreen
            return new AndroidLoginScreen();
        }
    }
}
