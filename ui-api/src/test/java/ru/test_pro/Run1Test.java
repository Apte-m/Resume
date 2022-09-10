package ru.test_pro;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber1.json"},
        dryRun = false,
        features = "src/test/resources/features/features_1",
        tags = "(not @skip)",
        glue = {"ru.test_pro"}
)
public class Run1Test {

    @AfterClass
    public static void afterClass(){

    }
}
