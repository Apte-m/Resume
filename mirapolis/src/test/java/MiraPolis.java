import jdk.jfr.Description;
import org.testng.annotations.Test;
import settings.Settings;
import step.VerificationStep;

public class MiraPolis extends Settings {


    @Description("Проверка конрректного пользователя")
    @Test
    public void checkUser() {
        step.stepInputPaigeAndVerificationUser()
                .verificationPaige();

    }

    @Test
    public void checkUrl() {
        VerificationStep verificationStep = new VerificationStep();
        verificationStep.verificationUrl();

    }
}
