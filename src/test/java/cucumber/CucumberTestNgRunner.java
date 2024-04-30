package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/cucumber",
glue = "stepdefinations",
monochrome=true,
tags = "@regression and @smoke",
plugin = {"html:target/cucumber-reports.html"})
public class CucumberTestNgRunner extends AbstractTestNGCucumberTests{

}
