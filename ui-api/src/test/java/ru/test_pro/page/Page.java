package ru.test_pro.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface Page {

    By getElements(String element);

    List <WebElement> getElementsList(String element);

    String getElementsString(String element);
}
