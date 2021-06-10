package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(WebListener.class);

    @Override
    public void beforeClickOn(WebElement element, WebDriver webDriver) {
        logger.info(">>>>>>>>> Clicking on element: " + element.getText() + " <<<<<<<<<");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver webDriver) {
        logger.info(">>>>>>>>> After clicking on element: " + element.getText() + " <<<<<<<<<");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info(">>>>>>>>> Before navigate: Navigating to " + url + " <<<<<<<<<");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info(">>>>>>>>> After navigate: Navigating to " + url + " <<<<<<<<<");
    }
}