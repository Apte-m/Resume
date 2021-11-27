package step;

import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import paige.RegisterPaige;


public class VerificationStep extends RegisterPaige {
    ResultStep resultStep = new ResultStep();
    SoftAssertions softly = new SoftAssertions();

    public void verificationPaige() {
        String user = name.getText();
        Assert.assertEquals(user, "Фомина Елена Сергеевна");
    }

    public void verificationUrl() {
        softly.assertThat(resultStep.correctUrl())
                .asString()
                .contains("302")
                .contains("200");


    }
}


