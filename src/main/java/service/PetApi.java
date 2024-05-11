package service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
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
}
