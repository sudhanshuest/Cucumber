package testBase;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class) 
@CucumberOptions
(
		features=".//features/Search.feature",
		glue="stepDefination",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
)		
public class TestRunner {

}
