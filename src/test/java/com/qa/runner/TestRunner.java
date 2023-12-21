package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/resources/featurefile",
		glue = "stepDefinition",
		dryRun = false,
		monochrome = false,
		plugin = {"pretty","html:Report/cucumber-reports.html"}
		//,tags = "@CurrentlyWorking"
		)

public class TestRunner {

}

