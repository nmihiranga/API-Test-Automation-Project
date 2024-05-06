package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

public class Products {

    public int statusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;

    @Given("I hit the url of get products API endpoint")
    public void I_hit_the_url_of_get_products_API_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I pass the url of products to the request")
    public void I_pass_the_url_of_products_to_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
    }

    @Then("I receive the response code as 200")
    public void I_receive_the_response_code_as_200() {
        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode, 200);
    }

    @Then("I verify that the rate of the first product is {}")
    public void I_verify_that_the_rate_of_the_first_product_is(String rate) {
        body = response.getBody();
        String responseBody = body.asString();
        JsonPath jsnPath = response.jsonPath();

        String s = jsnPath.getJsonObject("rating[0].rate").toString();
        assertEquals(rate, s);
    }
}