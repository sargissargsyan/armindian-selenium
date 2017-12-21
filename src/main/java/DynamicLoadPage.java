import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by sargis on 12/21/17
 */
public class DynamicLoadPage extends BasePage {
    private By startButton = By.id("start");
    private By finishText = By.id("finish");
    private By loadingText = By.id("loading");

    public DynamicLoadPage(WebDriver webDriver) {
        super(webDriver);
        visit("http://the-internet.herokuapp.com/dynamic_loading/1");
    }


}
