package ru.test_pro.service;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Service;
import ru.test_pro.api.CrudEntity;
import ru.test_pro.api.Post;

@AllArgsConstructor
@Service
public class ApiMap {

    @NotNull
    private Post post;

    public CrudEntity getCrud(String page) throws NoSuchElementException {
        switch (page.toLowerCase()) {
            case "запись":
                return post;

            default:
                throw new IllegalStateException("указан несуществующий эндпоинт: " + page.toLowerCase());
        }
    }
}
