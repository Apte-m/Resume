package ru.simbir.step;

import cucumber.api.java.BeforeStep;
import cucumber.api.java.ru.Затем;
import cucumber.api.java.ru.И;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import ru.simbir.service.PageMap;

@Slf4j
public class CommonStepUI {

    @Autowired
    private PageMap pageMap;
    @Autowired
    WebDriver webDriver;




    @Затем("на {string} для елемента {string} ввести {string}")
    public void sendEmail(String page, String element, String text) {
//        Тут специально метод воткнул ,чтобы было видно как можно вызвать интерфейс в конфигах задал 3 сек по дефолту
//        pageMap.explicitWat(page).explicitWait(element);


        webDriver.findElement(pageMap.getSelectedPage(page)
                        .getElements(element))
                .sendKeys(text, Keys.RETURN);
    }


    @Затем("на {string} нажать на {string}")
    public void clickElement(String page, String element) {
        pageMap.explicitWat(page).explicitWait(element);

        webDriver.findElement(pageMap.getSelectedPage(page)
                        .getElements(element))
                .click();
    }

    @Затем("на {string}  переместить {string}")
    public void moveTo(String page, String elementOne) {
        pageMap.explicitWat(page)
                .explicitWait(elementOne);

        pageMap.move(page)
                .moveToElement(elementOne);

    }

    @Затем("на {string} выполнить двойной клик {string}")
    public void completedDoubleClick(String page, String element) {
        pageMap.explicitWat(page)
                .explicitWait(element);

        Actions actions = new Actions(webDriver);

        actions.moveToElement(webDriver.findElement(pageMap
                        .getSelectedPage(page)
                        .getElements(element)))
                .doubleClick()
                .release()
                .build()
                .perform();

    }

    @И("на {string} проверить файлы по имени {string}")
    public void checkedFile(String page, String nameFile) {
        webDriver.findElement(pageMap.getSelectedPage(page)
                        .getElements(nameFile))
                .isDisplayed();
    }
}



