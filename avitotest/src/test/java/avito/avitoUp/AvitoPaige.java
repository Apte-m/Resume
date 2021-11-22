package avito.avitoUp;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Feature("Тестирование страницы AVITO")
public class AvitoPaige {

    public WebDriver webDriver;
    public WebElement webElement;
    public WebDriverWait wait;


    By category = By.xpath("//div[@class='main-select-JJyaZ main-location-XUs1_']");
    By search = By.xpath("//input[@type='text']");
    By searchCity = By.xpath("//input[@class='suggest-input-rORJM']");


    public AvitoPaige(WebDriverWait wait) {
        this.wait = wait;
    }

    public AvitoPaige(WebElement webElement) {
        this.webElement = webElement;
    }

    public AvitoPaige(WebDriver webDriver) {
        this.webDriver = webDriver;

    }


    @Attachment(value = "Screenshot", type = "image/png")
    @Step("Поиск города по значению {city}")

    public AvitoPaige SearchCity(String city) {

        webElement = webDriver.findElement(searchCity);
        webElement.sendKeys(city);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='" + city + "']")));

        webElement.sendKeys(Keys.ENTER);
        webElement.click();
        return this;

    }


    @Attachment(value = "Screenshot", type = "image/png")
    @Step("Пиоск xpath")
    public AvitoPaige clickTheSearch(String key) {
        webElement = webDriver.findElement(search);
        webElement.click();
        webElement.sendKeys(key);
        return this;

    }

    @Attachment(value = "Screenshot", type = "image/png")
    @Step("Проверка url")
    public AvitoPaige openPaige() {
        webDriver.manage().window().maximize();
        webDriver.get("https://www.avito.ru/");
        saveScreenshotPNG(webDriver);
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    @Step("Поиск категории ")
    public AvitoPaige clickTheProduct() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(category).click();
        saveScreenshotPNG(webDriver);
        return this;

    }

    @Attachment(value = "Screenshot", type = "image/png")
    @Step("Поиск селектора по значению ")
    public AvitoPaige searchSelector(String key) {
        webDriver.findElement(By.cssSelector(key)).click();
        saveScreenshotPNG(webDriver);
        return this;

    }

    @Attachment(value = "Screenshot", type = "image/png")
    @Step("Пиоск xpath c прокруткой станриницы ")
    public AvitoPaige searchScrollXpath(String key) {
        WebElement scroll = webDriver.findElement(By.xpath(key));
        Actions action = new Actions(webDriver);
        action.moveToElement(scroll).click().perform();

        saveScreenshotPNG(webDriver);
        return this;
    }


    @Attachment(value = "Screenshot", type = "image/png")
    @Step("Пиоск xpath ")
    public AvitoPaige searchXpath(String key) {
        webDriver.findElement(By.xpath(key)).click();
        saveScreenshotPNG(webDriver);
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    @Step("Поиск css селектора значение {value}")
    public AvitoPaige searchCssSelector(String locator, String value) {
        Select select = new Select(webDriver.findElement(By.cssSelector(locator)));
        select.selectByVisibleText(value);
        saveScreenshotPNG(webDriver);
        return this;

    }

    @Step("Вывод цены певых 3 принтеров")
    public AvitoPaige info() {
        String info = webDriver.findElement(By.xpath("//div[@class='index-content-_KxNP']")).getText();
        List<String> result = new ArrayList<>();

        String[] temp = info.split(".*[руб]");
        for (String word : temp) {

            for (int i = 0; i < 3; i++) {
                if (word.contains("₽")) {
                    result.add(word);
                }
            }
        }
        System.out.print(result.get(0));
        System.out.print(result.get(3));
        System.out.print(result.get(6));

        return this;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}



