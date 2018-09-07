package com.cg.project2.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"Features"}, glue= {"com.cg.project2.stepdefinitions"})
public class TestRunner {

}
