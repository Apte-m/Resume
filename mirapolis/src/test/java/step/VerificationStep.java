package step;

import org.testng.Assert;
import paige.RegisterPaige;

public class VerificationStep extends RegisterPaige {


    ResultStep resultStep = new ResultStep();

    public void verificationPaige() {
        resultStep.stepInputPaigeAndVerificationUser();
        Assert.assertEquals(name.getText(), "Фомина Елена Сергеевна");
    }

}
