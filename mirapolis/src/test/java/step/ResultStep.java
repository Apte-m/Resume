package step;

import paige.RegisterPaige;

public class ResultStep  {
    RegisterPaige registerPaige = new RegisterPaige();

    public VerificationStep stepInputPaigeAndVerificationUser (){
        registerPaige.goTo()
                .inputData();
            return new VerificationStep();
    }
}
