package starter.reqres.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresReponses;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetSingleUserStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body page should be email {string} and firstName {string}")
    public void responseBodyPageShouldBeEmailAndFirstName(String email, String firstname) {
        SerenityRest.then()
                .body(ReqresReponses.EMAIL, equalTo(email))
                .body(ReqresReponses.FNAME, equalTo(firstname));
    }

    @And("Get Single user JSON Schema Validator")
    public void getSingleUserJSONSchemaValidator() {
        File jsonReq = new File(Constant.JSON_REQ_SCHEMA+"SingleUserValidator/GetSingleUserValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonReq));
    }

    // invalid id

    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id) {
        reqresAPI.getSingleUserInvalidId(id);

    }

    @When("Send request get single user with invalid id")
    public void sendRequestGetSingleUserWithInvalidId() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    // single not found
    @Given("Get single user not found with id {int}")
    public void getSingleUserNotFoundWithIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user not found")
    public void sendRequestGetSingleUserNotFound() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }


}
