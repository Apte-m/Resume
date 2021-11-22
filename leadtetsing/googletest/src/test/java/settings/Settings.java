package settings;

import facktory.Browser;
import facktory.FactoryBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import paige.MethodPaige;
import step_result.Step;

public class Settings {
    private static WebDriver driver;
    protected MethodPaige paige;
    protected Step step;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void upPaige() {
        driver = FactoryBrowser.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        paige = new MethodPaige();
        step = new Step();


    }

    @AfterMethod
    public void downPaige() {
      //  driver.quit();

    }
}
