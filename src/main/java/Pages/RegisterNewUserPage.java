package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class RegisterNewUserPage extends BasePage{
    public RegisterNewUserPage(WebDriver driver) {
        super(driver);
    }

    Random random = new Random();

    @FindBy(css = "#id_gender1")
    private WebElement genderMaleRadio;

    @FindBy(css = "#customer_firstname")
    private WebElement customerFirstName;

    @FindBy(css = "#customer_lastname")
    private WebElement customerLastName;

    @FindBy(css = "#passwd")
    private WebElement password;

    @FindBy(css = "#days")
    private WebElement days;

    @FindBy(css = "#months")
    private WebElement months;

    @FindBy(css = "#years")
    private WebElement years;

    @FindBy(css = "#company")
    private WebElement company;

    @FindBy(css = "#address1")
    private WebElement address;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#id_state")
    private WebElement state;

    @FindBy(css = "#postcode")
    private WebElement postcode;

    @FindBy(css = "#id_country")
    private WebElement country;

    @FindBy(css = "#phone_mobile")
    private WebElement phone_mobile;

    @FindBy(css = "#alias")
    private WebElement aliasAddress;

    @FindBy(css = "#submitAccount")
    private WebElement submitAccountBtn;

    public void registerNewUser(){
        click(genderMaleRadio);
        sendKeys(customerFirstName, "Jan");
        sendKeys(customerLastName, "Kowalski");
        sendKeys(password, "Baza321");

        new Select(days).selectByValue("2");
        new Select(months).selectByVisibleText("May");
        new Select(years).selectByValue("2000");

        sendKeys(customerFirstName, "Jan");
        sendKeys(customerLastName, "Kowalski");
        sendKeys(company, "IBM");
        sendKeys(address, "Star Street 25");
        sendKeys(city, "Los Angeles");
        sendKeys(phone_mobile, "698789854");
        sendKeys(aliasAddress, "Fame Street 58");

        click(submitAccountBtn);
    }
}
