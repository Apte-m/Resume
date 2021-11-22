package paige;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;

public class MethodPaige extends BasePaige {

    @FindBy(xpath = "//*[contains(text(),'Войти')]")
    private WebElement entry;
    @FindBy(className = "Textinput-Control")
    private WebElement entryMail;
    @FindBy(id = "passp-field-passwd")
    private WebElement password;


    public MethodPaige() {
        super();
    }

    public MethodPaige goTo() {
        webDriver.navigate().to("https://yandex.ru/");
        return this;
    }

    public MethodPaige clickAndRedirectMail() {
        entry.click();
        return this;

    }


    public MethodPaige writeInfoAndSubmit() {
        entryMail.sendKeys("Atabek-Sergeevich" + Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-passwd")));
        password.sendKeys("852258asd" + Keys.RETURN);
        return this;

    }
}
