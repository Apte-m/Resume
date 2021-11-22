

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions (features = "src/test/resources", glue = "steps" )

public class AvitoTest extends AbstractTestNGCucumberTests {





}