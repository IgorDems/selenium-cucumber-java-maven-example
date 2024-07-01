package cucumberOption;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/searchProduct.feature",
        glue =  "stepDefinitions",
        //        dryRun = true,
        monochrome = true
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
