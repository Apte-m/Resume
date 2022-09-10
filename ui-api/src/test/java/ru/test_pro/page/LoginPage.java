package ru.test_pro.page;

import com.sun.istack.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LoginPage implements Page {


    @Override
    public By getElements(String element) {
        HashMap<String, By> seleniumElement = new HashMap<>();
        seleniumElement.put("email", By.xpath("//input[@name='email']"));
        seleniumElement.put("password", By.xpath("//input[@name='password']"));
        return seleniumElement.get(element);
    }

    @Override
    public List<WebElement> getElementsList(String element) {
        return null;
    }

    @Override
    public String getElementsString(String element) {
        return null;
    }
}
