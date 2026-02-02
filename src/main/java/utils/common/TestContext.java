package utils.common;

public class TestContext {

    private static volatile String latestEmailFromLogin;
    private static volatile String latestPasswordFromRegister;

    // ===== Email =====
    public static synchronized void setLatestEmailFromLogin(String email) {
        latestEmailFromLogin = email;
    }

    public static synchronized String getLatestEmailFromLogin() {
        return latestEmailFromLogin;
    }

    // ===== Old Password (from Register) =====
    public static synchronized void setLatestPasswordFromRegister(String password) {
        latestPasswordFromRegister = password;
    }

    public static synchronized String getLatestPasswordFromRegister() {
        return latestPasswordFromRegister;
    }

    // ===== Optional: Clear Context =====
    public static synchronized void clear() {
        latestEmailFromLogin = null;
        latestPasswordFromRegister = null;
    }
}
