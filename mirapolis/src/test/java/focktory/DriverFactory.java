package focktory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver webDriver;

    public static WebDriver getWebDriver(Browsers browser) {
        switch (browser) {
            case CHROME:

                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:

                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;

        }
        return webDriver;
    }
}
