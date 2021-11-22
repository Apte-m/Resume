package paige;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MethodPaige extends BasePaige {
    @FindBy(name = "q")
    WebElement search;


    public MethodPaige() {
        super();
    }

    public MethodPaige goTo() {
        webDriver.navigate().to("https://www.google.com/");
        return this;
    }

    public MethodPaige inputString() {
        executor.executeScript("arguments[0].click();", search);
        search.sendKeys("купить кофемашину bork c804" + Keys.RETURN);
        return this;

    }


}
