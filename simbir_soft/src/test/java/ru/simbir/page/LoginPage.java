package ru.simbir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginPage implements Page,Explicit {

    @Autowired
    WebDriver webDriver;
    @Override
    public By getElements(String element) {
        HashMap<String, By> seleniumElement = new HashMap<>();
        seleniumElement.put("почта", By.cssSelector("#passp-field-login"));
        seleniumElement.put("пароль", By.cssSelector("#passp\\-field\\-passwd"));


        return seleniumElement.get(element);
    }

    @Override
    public By getElementsCollection(String element) {
        HashMap<String, By> seleniumElement = new HashMap<>();


        return seleniumElement.get(element);
    }


    @Override
    public By getElementsContainsText(String element) {
        return By.xpath("//*[@class='" + element + "']");
    }

    @Override
    public void explicitWait(String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getElements(text)));

    }
}
