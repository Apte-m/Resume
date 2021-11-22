package settings;

import facktory.Browser;
import facktory.FactoryBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import paige.MethodPaige;

public class Settings {
    private static WebDriver driver;
    protected MethodPaige paige;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void upPaige() {
        driver = FactoryBrowser.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        paige = new MethodPaige();


    }

    @AfterMethod
    public void downPaige() {
        driver.quit();

    }
}
