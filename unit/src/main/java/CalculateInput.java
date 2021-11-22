import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateInput {
    public static void main(String[] args) throws IOException {
        Math math = new Math();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int oneArgument;
        int twoArgument;
        while ((input = bufferedReader.readLine()) != null) {
            if (input.contains("сложение")) {
                String[] result = input.split(" ");
                oneArgument = Integer.parseInt(result[1]);
                twoArgument = Integer.parseInt(result[2]);
                math.sumTest(oneArgument, twoArgument);

            } else if (input.contains("вычитание")) {
                String[] result = input.split(" ");
                oneArgument = Integer.parseInt(result[1]);
                twoArgument = Integer.parseInt(result[2]);
                math.deductionTest(oneArgument, twoArgument);
            } else if (input.contains("деление")) {
                String[] result = input.split(" ");
                oneArgument = Integer.parseInt(result[1]);
                twoArgument = Integer.parseInt(result[2]);
                math.divisionTest(oneArgument, twoArgument);
            } else if (input.contains("умножение")) {
                String[] result = input.split(" ");
                oneArgument = Integer.parseInt(result[1]);
                twoArgument = Integer.parseInt(result[2]);
                math.multiplicationTest(oneArgument, twoArgument);
            }
            else
                System.out.println("Больше функций не поддерживается");
                return;


        }
    }
}
