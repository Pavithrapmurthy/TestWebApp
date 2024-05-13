package runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"}, glue = {"stepDefination"}, plugin = {"pretty"}, monochrome = true)
public class NewTest extends AbstractTestNGCucumberTests{
}
