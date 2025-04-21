# QA Assessment - Option 1: API Integration Tests(Postman)

This document outlines the API integration tests implemented using Postman for the Kmbal Movie Reviews API, as per Option 1 of the QA assessment instructions.

## Prerequisites

* **Postman Application:** You need to have the Postman application installed on your local machine.
* **Imported Collection:** The `Movies-postman-collection.json` file (included in this submission) needs to be imported into your Postman application.
* **Imported Environment (Optional):** The `Movies-API-postman-environment.json` file (if included) should also be imported into Postman. This environment contains the necessary variables for running the tests. If not imported, you may need to manually create an environment with the following variables:
    * `API_BASE_URL`: `http://localhost:8000/api` (or the URL where your API is running)
    * `USER_EMAIL`: `example@user.com`
    * `USER_PASSWORD`: `Demo@123`
    * `API_TOKEN`: (Initially empty, populated by the login request)
    * `MOVIE_ID`: `1` (or another valid movie ID you used for testing)

## Test Cases Implemented

This test suite covers the following scenarios as required by Option 1:

1.  **A user should be able to submit a review:** This is tested by sending a `POST` request to the `/api/v1/movies/:movieId/reviews` endpoint with a valid authentication token and review data.
2.  **A user should not be able to submit more than one review for a given movie:** This is tested by attempting to send a second `POST` request to the same endpoint with the same user and `movieId`. The API should return an error.

## How to Run the Tests

These tests are implemented within the "Store" request in the "Kmbal Movies" Postman collection. To verify both scenarios, please follow these steps in Postman:

1.  **Select the Environment:** Ensure the "Kmbal API Testing" environment (or your custom environment) is selected in the top right corner of Postman.
2.  **Log In:**
    * Navigate to the "Login" request in the collection.
    * Click "Send".
    * Verify that the response returns a `200 OK` status and a JSON body containing an `access_token` (which should automatically populate the `API_TOKEN` environment variable).
3.  **Test Review Submission and Duplicate Prevention:**
    * Navigate to the "Store" request (under Movies > Reviews).
    * Ensure the request body contains valid review data (e.g., `{"rating": 4, "review": "This movie was enjoyable."}`).
    * **Run the "Store" request for the first time.** Observe the "Test Results" tab. All tests should pass, indicating a successful review submission (`200 OK` status, response body containing review details).
    * **Run the "Store" request a second time (without changing any parameters).** Observe the "Test Results" tab again. This time, the tests should pass the assertions for the duplicate submission scenario (`409 Conflict` status, response body containing an error message about already submitting a review, and not containing review details).

## Assertions Implemented

The "Store" request includes conditional tests based on the HTTP status code:

* **For a successful submission (Expected Status Code: 200 OK):**
    * Verifies the status code is `200 OK`.
    * Verifies that the response body contains the submitted `review` text and `rating`.
    * Verifies that the response body contains the `movie_id` and `user_id`.
* **For a duplicate submission (Expected Status Code: 409 Conflict):**
    * Verifies the status code is `409 Conflict`.
    * Verifies that the response body contains an error message indicating that the user has already submitted a review for the movie.
    * Verifies that the response body does not contain the review details (`review`, `rating`, `movie_id`, `user_id` are undefined).
* **Unexpected Status Code:** Includes a test to fail if an unexpected status code is received.

## Assumptions

* The backend API is running locally at `http://localhost:8000`.
* The default user credentials (`example@user.com` / `Demo@123`) are valid for login.
* A movie with `MOVIE_ID` 1 (or another ID used) exists in the database.

## Submission Files

This submission includes:

* `postman-tests/Movies-postman-collection.json` (The Postman collection containing the tests)
* `postman-tests/Movies-API-postman-environment.json` (Optional: The Postman environment file)
* `POSTMAN-README.md`(Documentation)

Thank you for reviewing my submission.

