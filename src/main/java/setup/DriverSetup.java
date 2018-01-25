package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER =
            System.getProperty("selenium.browser", "chrome");

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    String chromeDriverLocation = System.getProperty("selenium.chromedriver",
                            "/Users/sargis/dev/selenium-drivers/chromedriver");
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    try {
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new DesiredCapabilities());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
//                    driver.manage().window().fullscreen();
                    break;

                case "firefox":
                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver",
                            "/Users/sargis/dev/selenium-drivers/geckodriver");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
                    driver = new FirefoxDriver();
                    driver.manage().window().fullscreen();
                    break;
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            if(BROWSER.equals("firefox")){
                driver.close();
                driver = null;
            } else if (BROWSER.equals("chrome")) {
                driver.close();
                driver.quit();
                driver = null;
            }
        }
    }
}
