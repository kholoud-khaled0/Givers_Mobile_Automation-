package utils.common;

public class TestContext {
    private static volatile String latestEmailFromLogin;

    public static synchronized void setLatestEmailFromLogin(String email) {
        latestEmailFromLogin = email;
    }

    public static synchronized String getLatestEmailFromLogin() {
        return latestEmailFromLogin;
    }
}
