package paige;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.OptionalInt;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MethodPaige extends BasePaige {
    @FindBy(className = "CheckboxCaptcha-Anchor")
    WebElement captcha;
    @FindBy(xpath = "(//*[@data-tid-prop='89fe4462'])[1]")
    WebElement catalog;
    @FindBy(xpath = "//*[contains(text(),'Зоотовары')]")
    WebElement animalsProducts;
    @FindBy(xpath = "(//*[contains(text(),'Лакомства')])[1]")
    WebElement foodCat;
    @FindBy(name = "Цена от")
    WebElement priceOne;
    @FindBy(name = "Цена до")
    WebElement priceTwo;
    @FindBy(xpath = "(//*[@type='radio'])[1]")
    WebElement radioButtonDelivery;
    @FindBy(xpath = "(//*[@type='checkbox'])[2]")
    WebElement dreamisProduct;
    @FindBy(xpath = "(//*[@type='checkbox'])[7]")
    WebElement molinaProduct;
    @FindBy(xpath = "(//*[@class='_1FODI'])[1]")
    WebElement firstProduct;
    @FindBy(xpath = "(//*[@data-tid='b9e1d6c3'])[2]")
    WebElement secondProduct;
    @FindBy(xpath = "//*[contains(text(),'Сравнить')]")
    WebElement compare;
    @FindBy(xpath = "//*[@class='_2f75n PzFNv cia-cs']")
    List<WebElement> compareName;
    @FindBy(xpath = "(//*[@data-tid='b9e1d6c3'])[1]")
    WebElement deleteProduct;


    public MethodPaige() {
        super();
    }

    public MethodPaige goTo() {
        // https://bot.sannysoft.com/
        driver.navigate().to("https://market.yandex.ru");
        new WebDriverWait(driver, 5);
        if (captcha.isDisplayed()) {
            captcha.click();
        }
        return this;


    }

    public MethodPaige clickCatalog() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-tid-prop='89fe4462'])[1]")));
        catalog.click();
        return this;


    }

    public MethodPaige navigateAnimalsProductsAndClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='_1hPrb cia-cs'])[6]")));
        actions.moveToElement(animalsProducts).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Лакомства')])[1]")));
        foodCat.click();
        return this;

    }

    public MethodPaige installFilters() {
        priceOne.sendKeys("50");
        priceTwo.sendKeys("150");


        executor.executeScript("arguments[0].click();", radioButtonDelivery);
        actions.moveToElement(dreamisProduct);
        executor.executeScript("arguments[0].click();", dreamisProduct);
        return this;

    }

    public MethodPaige goToFirstProductAndCompare() {
        new WebDriverWait(driver, 3);
        executor.executeScript("arguments[0].click();", firstProduct);
        return this;
    }

    public MethodPaige chanceFilters() {
        executor.executeScript("arguments[0].click();", dreamisProduct);
        executor.executeScript("arguments[0].click();", molinaProduct);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Лакомства для кошек Molina')])[1]")));
        executor.executeScript("arguments[0].click();", secondProduct);

        return this;


    }

    public MethodPaige compareProduct() {
        executor.executeScript("arguments[0].click();", compare);
        return this;
    }

    public MethodPaige compareNameAndPrice() {
        assertThat(compareName.stream()
                .map((n) -> n.getText())
                .allMatch(s -> s.contains("Dreamies") && s.contains("Molina")))
                .as("Не одного из параметров ввода");

        List<WebElement> lists = driver.findElements(By.xpath("//*[@data-autotest-currency='₽']"));
        OptionalInt result = lists.stream()
                .mapToInt(s -> Integer.parseInt(s.getAttribute("data-autotest-value")))
                .max();

        assertThat(result.getAsInt() > 300).as("Значение меньше 300 рублей");

        executor.executeScript("arguments[0].click();", deleteProduct);

        String resultName = compareName.stream()
                .map((n) -> n.getText()).toString();

        Assert.assertFalse(resultName.equalsIgnoreCase("Dreamies"), "содержит продукт Dreamies ");
        return this;


    }


}
