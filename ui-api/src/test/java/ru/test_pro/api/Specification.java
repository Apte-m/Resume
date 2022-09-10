package ru.test_pro.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
    public static RequestSpecification requestSpec() {

        return new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri("https://jsonplaceholder.typicode.com/posts")
                .setContentType(ContentType.JSON)
//             .addFilter(new ResponseLoggingFilter())
//              .addFilter(new RequestLoggingFilter())
                .build();
    }


    public static ResponseSpecification responseSpec(int status) {
        return new ResponseSpecBuilder()
                .build();
    }

    public static void installSpecification(RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }

    public static void installSpecification(RequestSpecification requestSpec) {
        RestAssured.requestSpecification = requestSpec;
    }

    public static void installSpecification(ResponseSpecification responseSpec) {
        RestAssured.responseSpecification = responseSpec;
    }
}
