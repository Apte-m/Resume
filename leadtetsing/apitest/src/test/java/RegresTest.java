import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import utils.Utils;


public class RegresTest {
    ValidatableResponse response;


    @Description("Проверка пользователя 'Janet'")
    @Test
    public void getUser() {

        response = Utils.get();


    }

}

