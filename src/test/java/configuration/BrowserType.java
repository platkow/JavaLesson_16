
package configuration;

public enum BrowserType {
    IE,
    FIREFOX,
    CHROME,
    SAFARI,
    EDGE,
    UNKNOWN;

    private static BrowserType browserType;

    private BrowserType() {
    }

    public static BrowserType setBrowser(String envBrowser) {
        try {
            browserType = valueOf(envBrowser);
        } catch (IllegalArgumentException var2) {
            browserType = UNKNOWN;
        }

        return browserType;
    }

    public static BrowserType getBrowser() {
        return browserType;
    }

    public static String getName() {
        return browserType.name();
    }

    public static void initBrowserType() {
        setBrowser(EnvironmentProperty.getInstance().getBrowserEnvironment().getBrowserName().toUpperCase());
    }
}
