package paige;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MethodsPaige extends BasePaige {
    @FindBy(xpath = "//div[@class='main-select-JJyaZ main-location-XUs1_']")
    private WebElement category;

    @FindBy(xpath = "//input[@data-marker='search-form/suggest']")
    private WebElement search;

    @FindBy(xpath = "//div[@class='main-select-zU2Cl main-location-bH9Vg']")
    private WebElement searchCity;

    @FindBy(xpath = "//input[@data-marker='popup-location/region/input']")
    private WebElement inputElement;

    @FindBy(css = "#category")
    private WebElement categorySelector;

    @FindBy(css = "[data-marker='popup-location/save-button']")
    private WebElement button;

    @FindBy(xpath = "(//span[@class='checkbox-label-OmC9T text-text-LurtD text-size-s-BxGpL text-color-default-_QyDA'])[6]")
    private WebElement clickTheAction;

    @FindBy(xpath = "//div[@class='index-topPanel-McfCA']//select[@class='select-select-IdfiC']")
    private WebElement priceGeneral;

    @FindBy(xpath = "//div[@class='index-topPanel-McfCA']//option[@value='2']")
    private WebElement choosePrice;

    @FindBy(xpath = "//span[@class='price-text-E1Y7h text-text-LurtD text-size-s-BxGpL']")
    List<WebElement> info;


    public MethodsPaige() {
        super();
    }

    public MethodsPaige goTo() {
        webDriver.navigate().to("https://www.avito.ru/");
        return this;
    }

    public MethodsPaige searchCategory(Category category) {
        Select select = new Select(categorySelector);
        select.selectByVisibleText(category.getValue());
        return this;
    }

    public MethodsPaige searchOnTheWord(String word) {
        search.click();
        search.sendKeys(word + Keys.RETURN);
        return this;
    }

    public MethodsPaige clickTheSearch() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchCity.click();
        return this;
    }

    public MethodsPaige setSearchCity(String city) {
        inputElement.sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='" + city + "']")));
        inputElement.sendKeys(Keys.RETURN);
        return this;
    }

    public MethodsPaige clickTheButton() {
        button.click();
        return this;
    }

    public MethodsPaige scroll() {
        Actions action = new Actions(webDriver);
        action.moveToElement(clickTheAction).click().perform();
        return this;
    }

    public MethodsPaige clickPriceTheGeneral() {
        priceGeneral.click();
        return this;
    }

    public MethodsPaige clickNeedPrice() {
        choosePrice.click();
        return this;
    }

    public void info(int number) {
        info.stream()
                .map((s) -> s.getText())
                .limit(number)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


}
