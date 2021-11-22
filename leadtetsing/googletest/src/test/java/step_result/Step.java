package step_result;

import paige.MethodPaige;

public class Step {
    MethodPaige paige = new MethodPaige();

    public StepVerifications stepByStep() {
       paige.goTo()
               .inputString();
       return new StepVerifications();


    }
}
