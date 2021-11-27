package settings;

import focktory.Browsers;
import focktory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import step.ResultStep;
import step.VerificationStep;


public class Settings {
    private static WebDriver driver;
    protected ResultStep step;
    protected VerificationStep verificationStep ;



    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void start() {


        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getWebDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        step = new ResultStep();
        verificationStep = new VerificationStep();



    }

    @AfterMethod
    public void stop() {
         driver.quit();

    }
}
