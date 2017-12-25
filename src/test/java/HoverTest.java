import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by sargis on 12/21/17.
 */
public class HoverTest {
    private ChromeDriver driver;
    private HoverPage hoverPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/sargis/dev/chromedriver/chromedriver");
        driver = new ChromeDriver();
        hoverPage = new HoverPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void dropdownSelect() {
        assertTrue(hoverPage.isHeaderNotDisplayed());
        hoverPage.hoverAvatar();
        assertTrue(hoverPage.isHeaderDisplayed());
    }

}
