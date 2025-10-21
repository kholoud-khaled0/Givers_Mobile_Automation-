package utils.common;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;



public class PropertiesUtils {
    private static final ThreadLocal<Properties> properties = new ThreadLocal<>();
    private static final String ANDROID_PATH = "src/main/resources/Env/AndroidEnv.properties";
    private static final String IOS_PATH = "src/main/resources/Env/IosEnv.properties";

    public static void loadProperties(String platform) {
        if (properties.get() == null) {
            Properties props = new Properties();
            String path;

            if ("Android".equalsIgnoreCase(platform)) {
                path = ANDROID_PATH;
                LogsUtils.info("Loading Android properties from: " + path);
            } else   {
                path = IOS_PATH;
                LogsUtils.info("Loading iOS properties from: " + path);
            }

            try (InputStream is = Files.newInputStream(Path.of(path))) {
                props.load(is);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties for platform: " + platform, e);
            }

            properties.set(props);
        }
    }

    public static String getProperty(String key,String defaultValue) {
        Properties props = properties.get();
        if (props == null) {
            throw new IllegalStateException("Properties have not been loaded yet.");
        }
        return props.getProperty(key, defaultValue);
    }
    public static String getProperty(String key) {
        return getProperty(key, null);
    }

    public static void clearProperties() {
        properties.remove();
    }
}

