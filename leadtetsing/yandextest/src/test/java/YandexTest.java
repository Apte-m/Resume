import org.testng.annotations.Test;
import settings.Settings;

public class YandexTest extends Settings {
    @Test
    public void testYandex() {
        paige.goTo()
                .clickAndRedirectMail()
                .writeInfoAndSubmit();

    }
}
