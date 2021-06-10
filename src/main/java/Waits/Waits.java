package Waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waits {
    private WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger(Waits.class);

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement waitFluentlyForElement(int timeOut, int pollingEvery, WebElement element) {
        try {
            logger.debug("Waiting max " + timeOut + " for " + element + " to be visible, pooling every " + pollingEvery + " seconds.");


            WebDriverWait wait = (WebDriverWait) new FluentWait(this.driver)
                    .withTimeout(timeOut, TimeUnit.SECONDS)
                    .pollingEvery(pollingEvery, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.visibilityOf(element));
            logger.debug("Element " + element + " appeared on page.");
        } catch (Exception  e){
            logger.debug("Element " + element + " didn't appeared on page.");
            e.printStackTrace();
        }
        return element;
    }

    public void implicit(int implicitTimeOut){
        driver.manage().timeouts().implicitlyWait(implicitTimeOut, TimeUnit.SECONDS);
        logger.debug("Implicitly wait set to " + implicitTimeOut + TimeUnit.SECONDS);
    }
}


