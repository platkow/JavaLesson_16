package configuration;

import Pages.WebListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BrowserEnvironment {
    private String browserName = "chrome";
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private int webBrowserImplicitTimeOut;
    private boolean attachScreenShot;
    private Logger logger;
    private WebDriver webDriver;
    private WebListener webListener;
    private EventFiringWebDriver driver;

    public BrowserEnvironment() {
        this.headlessBrowser = false;
        this.webElementTimeOut = 10;
        this.webBrowserImplicitTimeOut = 5;
        this.attachScreenShot = true;
        logger = LoggerFactory.getLogger(BrowserEnvironment.class);
        this.browserName = PropertyStore.BROWSER.isSpecified() ? PropertyStore.BROWSER.getValue() : this.browserName;
        this.initBrowserSettings();
    }


    public String getBrowserName() {
        return this.browserName;
    }


    public boolean isHeadlessBrowser() {
        return this.headlessBrowser;
    }

    public int getWebBrowserImplicitTimeOut() {
        return this.webBrowserImplicitTimeOut;
    }


    public boolean isAttachScreenShotEnabled() {
        return this.attachScreenShot;
    }

    public int getWebElementTimeOut() {
        return this.webElementTimeOut;
    }

    private void initBrowserSettings() {
        this.webElementTimeOut = PropertyStore.BROWSER_WEBELEMENT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_WEBELEMENT_TIMEOUT.getIntValue() : this.webElementTimeOut;
        this.webBrowserImplicitTimeOut = PropertyStore.BROWSER_IMPLICIT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_IMPLICIT_TIMEOUT.getIntValue() : this.webBrowserImplicitTimeOut;
        this.attachScreenShot = PropertyStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertyStore.BROWSER_ATTACH_SCREENSHOT.getBoolean() : this.attachScreenShot;
        this.headlessBrowser = PropertyStore.BROWSER_HEADLESS.getBoolean();
    }

    public WebDriver getDriver() {
        EventFiringWebDriver driver;
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                webDriver = new ChromeDriver(optionsChrome);
                driver = new EventFiringWebDriver(webDriver);
                webListener = new WebListener();
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                webDriver = new FirefoxDriver(optionsFirefox);
                driver = new EventFiringWebDriver(webDriver);
                webListener = new WebListener();
                driver.get(System.getProperty("appUrl"));
                break;
            default:
                InternetExplorerOptions optionsdefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver(optionsdefault);
                driver = new EventFiringWebDriver(webDriver);
                webListener = new WebListener();
                driver.get(System.getProperty("appUrl"));
        }
        this.driver = driver;
        return this.driver;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }


    public void setHeadlessBrowser(boolean headlessBrowser) {
        this.headlessBrowser = headlessBrowser;
    }

    public void setWebElementTimeOut(int webElementTimeOut) {
        this.webElementTimeOut = webElementTimeOut;
    }

    public void setWebBrowserImplicitTimeOut(int webBrowserImplicitTimeOut) {
        this.webBrowserImplicitTimeOut = webBrowserImplicitTimeOut;
    }

    public void setAttachScreenShot(boolean attachScreenShot) {
        this.attachScreenShot = attachScreenShot;
    }


}
