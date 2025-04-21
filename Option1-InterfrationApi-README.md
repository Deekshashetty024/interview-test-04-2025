# QA Assessment - API Integration Tests

This repository contains the API integration tests developed for the Kmbal Movie Reviews API as part of the QA assessment. The tests are implemented using two different approaches:

## 1. Automated Tests (RestAssured, Java, TestNG)

The automated test suite, written in Java using TestNG and RestAssured, can be found in the following directories:

* **`src/test/java/com/review/`**:
  * [`MovieReviewTest.java`](./src/test/java/com/review/MovieReviewTest.java) - Contains the main automated test cases using Rest Assured and TestNG.
  * [`BaseTest.java`](./src/test/java/com/review/BaseTest.java) - Contains the base setup for Rest Assured, defining the base URI and enabling logging.
* **`src/test/resources/`**:
  * [`testng.xml`](./src/test/resources/testing.xml) - The TestNG suite definition file used to configure and run the tests.
* **`ProjectDetails-Docs/`**:
  * [`TestDocumentation.md`](./ProjectDetails-Docs/TestDocumentation.md) - Detailed documentation covering the setup, execution, test cases, and design of the automated tests.
 
**To run the automated tests:**

1.  Ensure you have Java (JDK 17 or higher) and Maven installed.
2.  Navigate to the root directory of this repository in your terminal.
3.  Execute the command: `mvn test`

## 2. Integration-PostmanTests

The Postman collection and environment files are located in the following directory:

* **`Integration-PostmanTests/postman-tests/`**:
  * [`Movies-postman-collection.json`](./Integration-PostmanTests/postman-tests/Movies-postman-collection.json) - The Postman collection containing the API requests and tests.
  * [`Movies-API-postman-environment.json`](./Integration-PostmanTests/postman-tests/Movies-API-postman-environment.json) - The Postman environment file (contains API URL and credentials).
  * [`POSTMAN-README.md`](./Integration-PostmanTests/POSTMAN-README.md) - Detailed instructions on how to run the tests within Postman.

**To run the Postman tests:**

1.  Ensure you have the Postman application installed.
2.  Import the `Movies-postman-collection.json` and (optionally) the `Movies-API-postman-environment.json` files into Postman.
3.  Refer to the [`POSTMAN-README.md`](./Integration-PostmanTests/POSTMAN-README.md) file for detailed instructions on how to run the tests within Postman.

---

Thank you for reviewing this submission.