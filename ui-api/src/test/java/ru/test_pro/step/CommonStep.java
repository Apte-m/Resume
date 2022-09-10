package ru.test_pro.step;

import cucumber.api.java.ru.Дано;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import ru.test_pro.service.PageMap;

@Slf4j
public class CommonStep {

    @Autowired
    private PageMap pageMap;
    @Autowired
    private Hooks hooks;

    private WebElement webElement;


    @Дано("переходим на {string} и вводим для эедемента {string} значение в поле {string}")
    public void goToAndInputText(String page, String element, String text) {
        webElement = hooks.webDriver.findElement(pageMap.getSelectedPage(page).getElements(element));
        webElement.sendKeys(text);


    }
}



