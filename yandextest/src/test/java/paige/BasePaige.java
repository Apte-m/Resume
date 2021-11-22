package paige;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static settings.Settings.getDriver;

public abstract class BasePaige {
    protected WebDriver webDriver;
    protected WebDriverWait wait;


    public BasePaige() {
        this.webDriver = getDriver();
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

    }
}
