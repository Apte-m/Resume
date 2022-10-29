package ru.simbir.page.pop_up;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbir.page.Page;
import ru.simbir.page.Explicit;

import java.util.HashMap;

@Service
public class CreatDirectoryPopUp implements Page, Explicit {
    @Autowired
    WebDriver webDriver;
    @Override
    public By getElements(String element) {
        HashMap<String, By> seleniumElement = new HashMap<>();
        seleniumElement.put("имя дирректории", By.cssSelector("*.Textinput_view_default .Textinput-Control"));
        seleniumElement.put("сохранить", By.xpath("//*[contains(text(),'Сохранить')]"));



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
}
