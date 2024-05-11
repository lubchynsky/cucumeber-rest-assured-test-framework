package service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import model.PetModel;

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

    public List<PetModel> getAll() {
        return given()
                .spec(getRequestSpec())
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", PetModel.class);
    }

    public ValidatableResponse getPetRawResponse(long id) {
        return given()
                .spec(getRequestSpec())
                .when()
                .pathParam("id", id)
                .get()
                .then();
    }

    public PetModel getPet(long id) {
        return getPetRawResponse(id)
                .statusCode(200)
                .extract()
                .as(PetModel.class);
    }

    public ValidatableResponse postPetRawResponse(PetModel petModel) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(petModel)
                .post()
                .then();
    }

    public PetModel postPet(PetModel petModel) {
        return postPetRawResponse(petModel)
                .statusCode(201)
                .extract()
                .as(PetModel.class);
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
