import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


public class Utils {

    public static Response create() {
        RequestSpecification httpRequest = RestAssured.given();

        return httpRequest
                .given()
                .baseUri("http://213.239.217.15:9090/api/v3/store/inventory")
                .basePath("/inventory")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .extract().response();

    }

    public static Response post() {
        RequestSpecification httpRequests = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("id", 10);
        request.put("petId", 198772);
        request.put("shipDate", "2021-09-22T19:58:14.718Z");
        request.put("status", "approved");
        request.put("complete", true);


        return httpRequests
                .given()
                .body(request.toJSONString())
                .contentType(ContentType.JSON)
                .when().post("http://213.239.217.15:9090/api/v3/store/order")
                .then()
                .statusCode(200)
                .extract()
                .response();


    }

    public static Response getPet() {
        RequestSpecification httpRequests = RestAssured.given();
        return httpRequests
                .given()
                .contentType(ContentType.XML)
                .when().get("http://213.239.217.15:9090/api/v3/store/order/10")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }


    public static Response deletePet() {
        RequestSpecification httpRequests = RestAssured.given();
        return httpRequests
                .given()
                .when().delete("http://213.239.217.15:9090/api/v3/store/order/10")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}

