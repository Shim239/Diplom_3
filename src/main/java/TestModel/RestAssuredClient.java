package TestModel;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RestAssuredClient {

    protected final String URL = "https://stellarburgers.nomoreparties.site/api";
    protected final RequestSpecification reqSpec = given()
            .baseUri (URL)
            .header("Content-type", "application/json");
}
