package settings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import paige.MethodsPaige;
import utils.Browser;
import utils.DriverFactory;

public class Settings {
    private static WebDriver webDriver;
    protected MethodsPaige paige;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    @BeforeMethod
    public void runPaige() {
        webDriver = DriverFactory.getWebDriver(Browser.CHROME);
        webDriver.manage().window().maximize();
        paige = new MethodsPaige();
    }

    @AfterMethod
    public void stopPaige() {
        webDriver.quit();
    }
}
