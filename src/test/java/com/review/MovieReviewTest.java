package com.review;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MovieReviewTest extends BaseTest {

    private final String movieId = "2";
    private String authToken;

    @BeforeClass
    public void getAuthToken() {
        // Obtain authentication token
        authToken = given()
                .contentType(ContentType.JSON)
                .body(new JSONObject().put("email", "example@user.com").put("password", "Demo@123").toString())
                .post("/v1/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }

    @Test
    public void canSubmitAReview() throws IOException {
        String testCaseId = "TC_001";
        String scenario = "Successful Review Submission";
        JSONObject requestParams = new JSONObject();
        requestParams.put("rating", 4);
        requestParams.put("review", "A new and enjoyable movie!");

        Response response = given()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .body(requestParams.toString())
                .pathParam("movieId", movieId)
                .when()
                .post("/v1/movies/{movieId}/reviews")
                .then()
                .statusCode(either(equalTo(200)).or(equalTo(409)))
                .extract()
                .response();

        if (response.getStatusCode() == 200 && response.getBody().asString().contains("movie_id")) {
            System.out.println("========================================");
            System.out.println("Scenario: " + scenario);
            System.out.println("Status: Passed");
            System.out.println("========================================");
            System.out.println("API Response Body:");
            System.out.println(response.getBody().asString());

            Assert.assertTrue(response.getBody().asString().contains("\"review\":\"A new and enjoyable movie!\""));
            Assert.assertTrue(response.getBody().asString().contains("\"rating\":4"));
            Assert.assertTrue(response.getBody().asString().contains("\"id\":"));
        }
        else if (response.getStatusCode() == 409) {

            System.out.println("========================================");
            System.out.println("Scenario: Review Submission");
            System.out.println("Status: Passed (Duplicate)");        //  Indicate Duplicate
            System.out.println("========================================");
            System.out.println("API Response Body:");
            System.out.println(response.getBody().asString());
            Assert.assertTrue(response.getBody().asString().contains("\"message\":\"You have already submitted a review for this movie.\""));
        }
    }

    @Test(dependsOnMethods = "canSubmitAReview")
    public void cannotSubmitMoreThanOneReview() throws IOException {
        String testCaseId = "TC_002";
        String scenario = "Preventing Duplicate Reviews";
        JSONObject requestParams = new JSONObject();
        requestParams.put("rating", 5);
        requestParams.put("review", "Attempting a duplicate review.");

        Response response = given()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .body(requestParams.toString())
                .pathParam("movieId", movieId)
                .when()
                .post("/v1/movies/{movieId}/reviews")
                .then()
                .statusCode(409)
                .body("message", equalTo("You have already submitted a review for this movie."))
                .extract()
                .response();

    }
}