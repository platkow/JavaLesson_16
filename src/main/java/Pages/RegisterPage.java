package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#email_create")
    private WebElement emailField;

    @FindBy(css = "#SubmitCreate")
    private WebElement createAccountBtn;

    public RegisterNewUserPage openRegisterNewUserPage(){
        sendKeys(emailField, "jkowalski@wp.pl");
        click(createAccountBtn);
        return new RegisterNewUserPage(getDriver());
    }
}
