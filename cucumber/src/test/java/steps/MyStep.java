package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyStep {
    public WebDriver webDriver;
    public WebElement webElement;



    @Before
    public void run() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);


    }

    @After
    public void quit() {

        webDriver.quit();
    }


    @Пусть("открыт ресурс авито")
    public void открытРесурсАвито() {
        webDriver.get("https://www.avito.ru/");

    }


    @И("в выпадающем списке категорий выбрана  {category}")
    public void вВыпадающемСпискеКатегорийВыбрана(Category category) {
        Select select = new Select(webDriver.findElement(By.cssSelector("#category")));
        select.selectByVisibleText(category.value);

    }


    @И("в поле поиска введено значение {word}")
    public void вПолеПоискаВведеноЗначение(String value) {
        webElement = webDriver.findElement(By.xpath("//input[@type='text']"));
        webElement.click();
        webElement.sendKeys(value);

    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void кликнутьПоВыпадающемуСпискуРегиона() {
        webDriver.findElement(By.cssSelector("[data-marker='search-form/region']")).click();
    }

    @Тогда("в поле регион введено значение {word}")
    public void вПолеРегионВведеноЗначение(String value) {
        webElement = webDriver.findElement(By.xpath("//input[@class='suggest-input-rORJM']"));
        webElement.sendKeys(value);

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='" + value + "']")));
        webElement.sendKeys(Keys.ENTER);
        webElement.click();


    }

    @И("нажата кнопка показать объявления")
    public void нажатаКнопкаПоказатьОбъявления() {
        webDriver.findElement(By.cssSelector("[data-marker='popup-location/save-button']")).click();
    }


    @Тогда("открылась страница результаты по запросу {word}")
    public void открыласьСтраницаРезультатыПоЗапросу(String value) {
        String temp = "";
        String checkWord = webDriver.findElement(By.xpath("//h1[@class='page-title-text-t2wF6 page-title-inline-_UqSl']")).getText();
        String[] result = checkWord.split(" ");
        for (String r : result) {
            if (r.contains(value)) {
                temp = r;
            }
        }

        Assert.assertTrue(temp.equals("«" + value + "»"));

    }


    @И("активирован чекбокс только с доставкой")
    public void активированЧекбоксТолькоСДоставкой() {
        WebElement delivery = webDriver.findElement(By.xpath("//label[@class='checkbox-checkbox-KO_ws checkbox-size-s-tYC2A']//span[@data-marker='delivery-filter/text']"));
        if (delivery.isDisplayed()) {
            if (!delivery.isSelected()) {
                delivery.click();
            }
        } else {
            System.out.println("Доставки на товар нет");
        }
    }



    @И("в выпадающем списке сортировки выбрано значение {sort}")
    public void вВыпадающемСпискеСортировкиВыбраноЗначение(Sort sort) {
        webDriver.findElement(By.xpath("//div[@class='index-topPanel-McfCA']//select[@class='select-select-IdfiC']")).click();
        webDriver.findElement(By.xpath(sort.value)).click();

    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public void вКонсольВыведеноЗначениеНазванияИЦеныКоличествоПервыхТоваров(int size) {
        List<WebElement> price = webDriver.findElements(By.xpath("//span[@class='price-text-E1Y7h text-text-LurtD text-size-s-BxGpL']"));
        for (int i = 0; i < size; i++) {
            System.out.println(price.get(i).getText());
        }


    }

    @ParameterType(".*")
    public Category category(String category) {
        return Category.valueOf(category);
    }

    @ParameterType(".*")
    public Sort sort(String sort) {
        return Sort.valueOf(sort);
    }


}
