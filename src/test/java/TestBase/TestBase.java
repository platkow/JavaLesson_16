package TestBase;

import Waits.Waits;
import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger("TestBase.class");
    private static BrowserEnvironment browserEnvironment;
    public static EnvironmentProperty environmentProperty;
    private static Waits wait;


    @BeforeAll
    static void setUp() {
        logger.debug(">>>>>>>>> Start test >>>>>>>>>");
        environmentProperty = EnvironmentProperty.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        logger.debug("Driver initialized.");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.debug("Implicitly wait is running");
    }

    @AfterEach
    void afterEach() {
        logger.debug(">>>>>>>>> End test >>>>>>>>>");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        logger.debug("Driver closed.");
    }
}
