package br.com.alelo.steps;

import io.cucumber.java.*;


public class Hooks {

    public static Scenario scenario;

    @Before()
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
    }

//    @BeforeStep
//    public void beforeStep(Scenario scenario) {
//    }

//    @AfterStep
//    public void afterStep(Scenario scenario) {
//    }

//    @After
//    public void afterScenario(Scenario scenario) {
//    }
}
