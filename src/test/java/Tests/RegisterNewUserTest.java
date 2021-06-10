package Tests;

import Pages.MainPage;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

public class RegisterNewUserTest extends TestBase {
    MainPage mainPage = new MainPage(driver);

    @Test
    public void shouldOpenRegistrationPage(){
        mainPage.openLoginPage()
                .openRegisterNewUserPage()
                .registerNewUser();
    }
}
