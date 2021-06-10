package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".login")
    private WebElement signInBtn;

    //widoczne po zalogowaniu
    @FindBy(css = ".user-info a.hidden-sm-down")
    private WebElement signOutBtn;

    @FindBy(css = ".account")
    private WebElement userName;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenLnk;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    private WebElement dressesLnk;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    private WebElement tshirtsLnk;

    public String getUserName() {
        return userName.getText();
    }

    public MainPage mouseHoverWomen(){
        logger.info("Mouse hover on women link.");
        mouseHover(womenLnk);
        return this;
    }

    public MainPage mouseHoverDresses(){
        logger.info("Mouse hover on dresses link.");
        mouseHover(dressesLnk);
        return this;
    }

    public MainPage mouseHoverTshirts(){
        logger.info("Mouse hover on T-shirts link.");
        mouseHover(tshirtsLnk);
        return this;
    }

    public RegisterPage openLoginPage(){
        click(signInBtn);
        return new RegisterPage(getDriver());
    }
}

