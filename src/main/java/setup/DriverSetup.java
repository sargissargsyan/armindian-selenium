package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER =
            System.getProperty("selenium.browser", "chrome");
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static void initDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    String chromeDriverLocation = System.getProperty("selenium.chromedriver",
                            "/Users/sargis/dev/selenium-drivers/chromedriver");
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    if (Boolean.valueOf(System.getProperty("selenium.remote", "true"))) {
                        initRemoteDriver(DesiredCapabilities.chrome());
                    } else {
                        driverThread.set(new ChromeDriver());
                    }
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
    }

    public static void initRemoteDriver(DesiredCapabilities capability) {
        capability.setCapability(CapabilityType.PLATFORM_NAME, "Linux");
        WebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("http://sargisgermany:d885cbd8-a6c5-472e-8517-42d1e9cea6bd@ondemand.saucelabs.com:80/wd/hub"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driverThread.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }


    public static void quitDriver() {
        getDriver().close();
        getDriver().quit();

    }
}
