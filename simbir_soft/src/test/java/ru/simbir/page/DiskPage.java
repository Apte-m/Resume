package ru.simbir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DiskPage implements Page, Explicit, MoveToElement {
    @Autowired
    WebDriver webDriver;

    @Override
    public By getElements(String element) {
        HashMap<String, By> seleniumElement = new HashMap<>();
        seleniumElement.put("создать", By.cssSelector("[class*='Button2_view_raised Button2_size_m Button2_width_max']"));
        seleniumElement.put("создать папку", By.cssSelector("[class*='file-icon_size_m file-icon_dir_p']"));
        seleniumElement.put("файлы", By.cssSelector(".listing-item__fields"));
        seleniumElement.put("имя файла", By.xpath("(//*[contains(text(),'Тест')])[2]"));

        return seleniumElement.get(element);

    }

    @Override
    public By getElementsCollection(String element) {

        return null;
    }

    @Override
    public By getElementsContainsText(String element) {
        return null;
    }

    @Override
    public void explicitWait(String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getElements(text)));

    }

    @Override
    public void moveToElement(String element) {
        Actions actions = new Actions(webDriver);

        List<WebElement> webElementOne = webDriver.findElements(getElements(element));
        actions.moveToElement(webElementOne.get(0)).click()
                .clickAndHold()
                .moveToElement(webElementOne.get(1))
                .release()
                .build()
                .perform();

    }
}
