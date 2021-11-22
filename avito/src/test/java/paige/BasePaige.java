package paige;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static settings.Settings.getWebDriver;

public class BasePaige {
    WebDriver webDriver;
    WebDriverWait wait;


    public BasePaige() {
        this.webDriver = getWebDriver();
        PageFactory.initElements(webDriver,this);
        wait =  new WebDriverWait(webDriver, 5);
    }
}
