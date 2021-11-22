import org.testng.annotations.Test;
import settings.Settings;

public class GoogleTest extends Settings {
    @Test
    public void runGoogle() {

        step.stepByStep()
                .verification();

    }
}
