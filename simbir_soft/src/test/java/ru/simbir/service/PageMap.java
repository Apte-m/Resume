package ru.simbir.service;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Service;
import ru.simbir.page.*;
import ru.simbir.page.pop_up.CreatDirectoryPopUp;

@AllArgsConstructor
@Service
public class PageMap {

    @NotNull
    private LoginPage loginPage;

    @NotNull
    private DiskPage diskPage;
    @NotNull
    private CreatDirectoryPopUp directoryPopUp;


    public Page getSelectedPage(String page) throws NoSuchElementException {
        switch (page.toLowerCase()) {
            case "страница авторизации":
                return loginPage;
            case "страница яндекс диск":
                return diskPage;
            case "дирректория":
                return directoryPopUp;

            default:
                throw new IllegalStateException("указана несуществующая страница: " + page.toLowerCase());
        }
    }


    public Explicit explicitWat(String page) throws NoSuchElementException {
        switch (page.toLowerCase()) {
            case "страница авторизации":
                return loginPage;
            case "страница яндекс диск":
                return diskPage;
            case "дирректория":
                return directoryPopUp;
            default:
                throw new IllegalStateException("указана несуществующая страница: " + page.toLowerCase());
        }
    }


    public MoveToElement move(String page) throws NoSuchElementException {
        switch (page.toLowerCase()) {
            case "страница яндекс диск":
                return diskPage;
            default:
                throw new IllegalStateException("указана несуществующая страница: " + page.toLowerCase());
        }
    }

}
