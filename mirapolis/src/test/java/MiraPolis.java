import jdk.jfr.Description;
import org.testng.annotations.Test;
import settings.Settings;

public class MiraPolis extends Settings {


    @Description("Проверка конрректного пользователя")
    @Test
    public void runTask() {
        step.stepInputPaigeAndVerificationUser()
                .verificationPaige();

    }
}
