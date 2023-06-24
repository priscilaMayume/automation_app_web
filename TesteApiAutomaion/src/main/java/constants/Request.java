package constants;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Request {

    public static Response doPostRequest(String body, Endpoint endpoint) {
        return given()
                .baseUri(endpoint.getEndpoint())
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body(body)
                .log().all()
                .post();
    }

    public static Response doPutRequest(String body, Endpoint endpoint) {
        return given()
                .baseUri(endpoint.getEndpoint())
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body(body)
                .log().all()
                .when()
                .put();
    }

    public static Response doPatchRequest(String body, Endpoint endpoint) {
        return given()
                .baseUri(endpoint.getEndpoint())
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body(body)
                .log().all()
                .when()
                .patch();
    }

    public static Response doGetRequest(Endpoint endpoint) {
        return given().
                contentType(ContentType.JSON).
                when().
                get(endpoint.getEndpoint());
    }

    public static Response doDeleteRequest(Endpoint endpoint) {
        return given().
                contentType(ContentType.JSON).
                when().log().all()
                .delete(endpoint.getEndpoint());
    }
}
