package utils;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Utils {
    private static final String URL = "https://reqres.in/api";
    private static final String PATH = "/users/2";

    public static ValidatableResponse get() {
        RequestSpecification httpRequest = given();

        return httpRequest
                .given()
                .baseUri(URL)
                .basePath(PATH)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"));


    }

}

