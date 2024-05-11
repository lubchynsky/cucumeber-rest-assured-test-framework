package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DummySteps {

    @Given("there is pets be endpoint")
    public void thereIsPetsBeEndpoint() {
        System.out.println("given");
    }

    @When("we send get")
    public void weSendGet() {
        System.out.println("when");
    }

    @Then("you will receive all pets")
    public void you_wiyouWillReceiveAllPets() {
        System.out.println("then");
    }

}
