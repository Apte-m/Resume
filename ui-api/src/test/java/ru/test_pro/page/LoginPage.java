package ru.test_pro.page;

import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginPage implements Page {


    @Override
    public By getElements(String element) {
        HashMap<String, By> seleniumElement = new HashMap<>();
        seleniumElement.put("email", By.xpath("//input[@name='email']"));
        seleniumElement.put("password", By.xpath("//input[@name='password']"));
        seleniumElement.put("come in", By.xpath("//*[@name='go']"));

        return seleniumElement.get(element);
    }

    @Override
    public By getElementsCollection(String element) {
        HashMap<String, By> seleniumElement = new HashMap<>();
        seleniumElement.put("коллекции", By.xpath("//*[@class='form__field-label']"));

        return seleniumElement.get(element);
    }


    @Override
    public By getElementsContainsText(String element) {
        return By.xpath("//*[@class='" + element + "']");
    }
}
