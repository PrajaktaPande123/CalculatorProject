package Steps;

import Pages.PageCal;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepClass {
    PageCal page1=new PageCal();
    @Given("Opening calculator webpage")
    public void openingCalculatorWebpage() {
       page1.open();
    }
    @When("Entering {string} in the calculator")
    public void enteringNInTheCalculator(String arg0) throws InterruptedException {
        page1.enternumber(arg0);
    }

    @And("Enter operator {string} in the calculator")
    public void enterOperatorOpInTheCalculator(String op) throws InterruptedException {
        page1.enteroperator(op);
    }

    @Then("Checking result as per {string}")
    public void checkingResultAsPerExpected(String expected) throws InterruptedException {
    page1.checkResult(expected);

    }

}
