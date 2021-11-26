package step;

import paige.RegisterPaige;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class ResultStep {
    RegisterPaige registerPaige = new RegisterPaige();


    public int correctUrl()  {
        HttpURLConnection connection =
                null;
        try {
            connection = (HttpURLConnection)
                    new URL("https://lmslite47vr.demo.mirapolis.ru/mira")
                            .openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.setRequestMethod("HEAD");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int responseCode = 0;
        try {
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseCode;
    }

    public VerificationStep stepInputPaigeAndVerificationUser() {
        registerPaige.goTo()
                .inputData();
        return new VerificationStep();
    }
}
