package stepdefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Products {

    public int statusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;

    // get products feature
    @Given("I hit the url of get products API endpoint")
    public void I_hit_the_url_of_get_products_API_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I pass the url of products in the request")
    public void I_pass_the_url_of_products_in_the_request() {
        httpRequest = given();
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

    // insert products feature
    @Given("I hit the url of post product API endpoint")
    public void I_hit_the_url_of_post_product_API_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "shoes");
        requestParams.put("price", 13.5);
        requestParams.put("description", "lorem ipsum");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("category", "foot wear");

        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.post("products");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

    @And("I pass the request body of product title {}")
    public void I_pass_the_request_body_of_product_title(String arg0) {
    }
}