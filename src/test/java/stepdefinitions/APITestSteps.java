package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITestSteps {

    private Response response;
    private String endpoint;

    @Before
    public void setUp() {
        System.out.println("🧪 Setting base URI for API testing...");
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Given("I have the API endpoint {string}")
    public void i_have_the_api_endpoint(String url) {
        this.endpoint = url;
    }

    @When("I send a GET request to the endpoint")
    public void i_send_a_get_request() {
        response = RestAssured.given()
                .when()
                .get(endpoint);
        System.out.println("✅ Response received: " + response.getBody().asString());
    }

    @Then("the response status code should be {int}")
    public void verify_status_code(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertThat("Status code should match", actualStatusCode, equalTo(expectedStatusCode));
    }

    @Then("the response should contain {string} with value {string}")
    public void the_response_should_contain(String key, String value) {
        String actualValue = response.jsonPath().getString(key);
        assertThat("Response body contains expected key and value", actualValue, equalTo(value));
    }
}
