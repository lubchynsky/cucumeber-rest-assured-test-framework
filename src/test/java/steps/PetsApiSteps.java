package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Pet;
import service.PetApi;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetsApiSteps {
    private PetApi petApi;
    private List<Pet> allPets;
    private Pet createdPet;


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

    @When("we create pet with name {}, type as {} and age {}")
    public void weCreatePetWithNameTypeAndAge(String name, String type, int age) {
        Pet petToBeCreated = new Pet(name, type, age);
        createdPet = petApi.postPet(petToBeCreated);
    }

    @Then("pet should be created with name {}, type as {} and age {}")
    public void createdPetShouldHaveExactNameTypeAndAge(String name, String type, int age) {
        assertThat("Name should be same", createdPet.getName(), equalTo(name));
        assertThat("Type should be same", createdPet.getType(), equalTo(type));
        assertThat("Age should be same", createdPet.getAge(), equalTo(age));

    }
}
