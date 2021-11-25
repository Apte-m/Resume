package settings;

import focktory.Browsers;
import focktory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import paige.RegisterPaige;

public class Settings {
    private static WebDriver driver;
    protected RegisterPaige registerPaige;


    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void start() {


        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getWebDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        registerPaige = new RegisterPaige();


    }

    @AfterMethod
    public void stop() {
           driver.quit();

    }
}
