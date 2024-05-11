package service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import model.Pet;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {

    private static final String BE_API_URL = "http://localhost:8080";

    private RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BE_API_URL)
                .setBasePath("pets")
                .setContentType(ContentType.JSON)
                .build();
    }

    public List<Pet> getAll() {
        return given()
                .spec(getRequestSpec())
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", Pet.class);
    }

    public ValidatableResponse getPetRawResponse(long id) {
        return given()
                .spec(getRequestSpec())
                .when()
                .pathParam("id", id)
                .get()
                .then();
    }

    public Pet getPet(long id) {
        return getPetRawResponse(id)
                .statusCode(200)
                .extract()
                .as(Pet.class);
    }

    public ValidatableResponse postPetRawResponse(Pet pet) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(pet)
                .post()
                .then();
    }

    public Pet postPet(Pet pet) {
        return postPetRawResponse(pet)
                .statusCode(201)
                .extract()
                .as(Pet.class);
    }

    public void deletePet(long id) {
        given()
                .spec(getRequestSpec())
                .when()
                .pathParam("id", id)
                .delete()
                .then()
                .statusCode(200);
    }
}
