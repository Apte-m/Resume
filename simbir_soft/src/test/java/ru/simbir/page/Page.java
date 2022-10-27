package ru.simbir.page;

import org.openqa.selenium.By;

public interface Page {

    By getElements(String element);

    By getElementsCollection(String element);

    By getElementsContainsText(String element);
}
