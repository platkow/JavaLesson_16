package Tests;

import Pages.MainPage;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

public class MouseHoverTest extends TestBase {
    MainPage mainPage = new MainPage(driver);

    @Test
    public void shouldHoverOnLinks(){
        mainPage.mouseHoverWomen()
                .mouseHoverDresses()
                .mouseHoverTshirts();
    }
}
