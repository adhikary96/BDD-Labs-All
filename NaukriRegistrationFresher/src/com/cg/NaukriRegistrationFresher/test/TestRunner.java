 package com.cg.NaukriRegistrationFresher.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"Features"}, glue= {"com.cg.NaukriRegistrationFresher.stepdefinitions"}, tags= {"@Test"})
public class TestRunner {

}
