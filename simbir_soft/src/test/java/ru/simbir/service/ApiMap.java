package ru.simbir.service;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Service;
import ru.simbir.api.Disck;
import ru.simbir.api.Get;

@AllArgsConstructor
@Service
public class ApiMap {

    @NotNull
    private Disck disck;

    public Get get(String page) throws NoSuchElementException {
        switch (page.toLowerCase()) {
            case "яндекс диск":
                return disck;

            default:
                throw new IllegalStateException("указан несуществующий эндпоинт: " + page.toLowerCase());
        }
    }
}
