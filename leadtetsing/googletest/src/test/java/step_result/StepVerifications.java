package step_result;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import paige.BasePaige;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StepVerifications extends BasePaige {
    Step verification = new Step();

    public void verification() {


        List<WebElement> result = webDriver.findElements(By.xpath("//*[@class='LC20lb DKV0Md']"));
        assertThat(result.stream().count()).isEqualTo(10)
                .as("Результат не соответсвует числу 10");
        assertThat(result.stream().map(s -> s.getText()).allMatch(s -> s.contains("C804")
                || s.contains("М.Видео")));


    }
}
