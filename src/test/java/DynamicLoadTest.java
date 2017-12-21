import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sargis on 12/21/17.
 */
public class DynamicLoadTest {
    private ChromeDriver driver;
    private DynamicLoadPage dynamicLoadPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/sargis/dev/chromedriver/chromedriver");
        driver = new ChromeDriver();
        dynamicLoadPage = new DynamicLoadPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void dynamicLoad() {

    }

}
