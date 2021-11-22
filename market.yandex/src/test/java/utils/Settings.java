package utils;

import facktory.Browsers;
import facktory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import paige.MethodPaige;

public class Settings {
    private static WebDriver driver;
    protected static MethodPaige paige;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void start() {


        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getWebDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        paige = new MethodPaige();

    }

    @AfterMethod
    public void stop() {
        //   driver.quit();

    }
}
