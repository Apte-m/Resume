package ru.test_pro.step;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Затем;
import cucumber.api.java.ru.И;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import ru.test_pro.service.PageMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;

@Slf4j
public class CommonStepUI {

    @Autowired
    private PageMap pageMap;
    @Autowired
    WebDriver webDriver;




    @Дано("переходим на {string} и вводим для эедемента {string} значение в поле {string}")
    public void goToAndInputText(String page, String element, String text) {
        webDriver.findElement(pageMap.getSelectedPage(page)
                        .getElements(element)).sendKeys(text);


    }

    @Затем("на {string} нажать {string}")
    public void click(String page, String element) {
         webDriver.findElement(pageMap.getSelectedPage(page)
                        .getElements(element))
                 .click();



    }

    @И("проверяем, что url соотвествует {string}")
    public void checkToPageAndUrl(String url) {
        assertEquals(webDriver.getCurrentUrl(), url);
    }


    @Затем("на {string}  провереям наличие текста  {string} и он равен ожидаемому {string}")
    public void checkText(String page, String expected, String actual) {
        assertEquals(webDriver.findElement(pageMap.getSelectedPage(page)
                                .getElementsContainsText(expected))
                        .getText(), actual);
    }


    @Затем("на {string}  провереям наличие  {string}")
    public void checkToCollection(String page, String element, Map<String, String> map) {
        List<WebElement> elements = webDriver.findElements(pageMap.getSelectedPage(page)
                        .getElementsCollection(element));


        assertThat(elements.stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList())
                , hasItems(map.get("Почта"), map.get("Пароль"), map.get("Другое")));
    }


}



