import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HomeTaskApiTest extends Utils {
    @Before
    @Test
    public void getMap() throws JsonProcessingException {
        Response response = Utils.create();
        Map<String, Integer> map = new ObjectMapper().readValue(response.getBody().asString(), HashMap.class);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            Assert.assertTrue(map.containsValue("HTTP 404 Not Found"));
        }
    }

    @Before
    @Test
    public void postMap() throws JsonProcessingException {
        Response response = Utils.post();
        Map<String, Integer> map = new ObjectMapper().readValue(response.getBody().asString(), HashMap.class);
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
            Assert.assertTrue(map.containsValue(true));

        }
    }
    @Before
    @Test
    public void putMap() throws JsonProcessingException {
        Response response = Utils.getPet();
        Map<String, Object> map = new ObjectMapper().readValue(response.getBody().asString(), HashMap.class);
        for (Map.Entry<String, Object> e : map.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
            Assert.assertTrue(map.containsValue(true));


        }
    }
    @After
    @Test
    public void delete() throws JsonProcessingException {
        Utils.deletePet();


    }
}

