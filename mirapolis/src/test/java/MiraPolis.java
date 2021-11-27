import jdk.jfr.Description;
import org.testng.annotations.Test;
import settings.Settings;

public class MiraPolis extends Settings {


    @Description("Проверка конрректного пользователя")
    @Test
    public void checkUser() {
        step.stepInputPaigeAndVerificationUser()
                .verificationPaige();

    }
    @Description("Проверка кода ответа ссылки")
    @Test
    public void checkUrl() {
        verificationStep.verificationUrl();

    }
}
