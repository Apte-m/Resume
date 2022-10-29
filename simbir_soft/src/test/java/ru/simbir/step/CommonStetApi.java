package ru.simbir.step;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Затем;
import dto.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.simbir.service.ApiMap;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class CommonStetApi {
    @Autowired
    private ApiMap apiMap;


    @Дано("эндпоинт {string} получаем и проверяем количество файлов")
    public void getFile(String endpoint) {
       File  file =  apiMap.get(endpoint).get().as(File.class);


        System.out.println("=====================");
        System.out.println("Количестов файлов");
        System.out.println(file.getItems().size());
        System.out.println("=====================");
    }
}
