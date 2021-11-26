package paige;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RegisterPaige extends BasePaige {
    @FindBy(name = "user")
    private WebElement user;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(className = "avatar-full-name")
    protected WebElement name;



    public RegisterPaige() {
        super();
    }


    public RegisterPaige goTo() {
        driver.navigate().to("https://lmslite47vr.demo.mirapolis.ru/mira");
        return this;
    }

    public RegisterPaige inputData() {
        user.sendKeys("fominaelena");
        password.sendKeys("1P73BP4Z" + Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Мои сертификаты')]")));
        return this;
    }


}
