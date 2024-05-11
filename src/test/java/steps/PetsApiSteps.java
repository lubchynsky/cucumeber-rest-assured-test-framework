package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.PetModel;
import service.PetApi;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class PetsApiSteps {
    private PetApi petApi;
    private List<PetModel> allPets;


    @Given("we have pets be api")
    public void setupBePetAPi() {
        petApi = new PetApi();
    }

    @When("we get all pets")
    public void getAllPets() {
        allPets = petApi.getAll();
    }

    @Then("there should be some pets returned")
    public void assertThereAreSomePetsReturned() {
        assertThat("There should be some pets returned from BE api", allPets, hasSize(greaterThan(0)));
    }
}
