package ru.simbir.api;

import io.restassured.response.Response;
import org.junit.Test;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;

@Service
public class Disck implements Get {

    @Override
    public Response get() {
        Specification.installSpecification(new Specification().requestSpec(), Specification.responseSpec(200));

        return given().when()
                .get("/v1/disk/resources/files");
    }

}
