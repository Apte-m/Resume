import org.testng.annotations.Test;
import settings.Settings;

public class MiraPolis extends Settings {

    @Test
    public void runTask() {
        registerPaige.goTo().
                inputData()
                .verificationUser();
    }
}
