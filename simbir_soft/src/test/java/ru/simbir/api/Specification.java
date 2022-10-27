package ru.simbir.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class Specification {



    @Bean
    public RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addHeader("Authorization", "OAuth y0_AgAAAABlo8lZAADLWwAAAADSbf7ETsKUXaugRMmXgECuOQEw-TNpTjA")
                .setBaseUri("https://cloud-api.yandex.net")
                .setContentType(ContentType.JSON)
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new RequestLoggingFilter())
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

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
