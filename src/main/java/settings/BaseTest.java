package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    private static final ThreadLocal<EventFiringWebDriver> driverThreadLocal = new ThreadLocal<>();

    public static EventFiringWebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("firefox") String browser) {
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=en");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("intl.accept_languages", "en");
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unknown browser: " + browser);
        }

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        WebDriverListener webDriverListener = new WebDriverListener();
        eventDriver.register(webDriverListener);

        driverThreadLocal.set(eventDriver);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        BasePage.setDriver(eventDriver);
    }

    @AfterMethod
    public void tearDown() {
        EventFiringWebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
