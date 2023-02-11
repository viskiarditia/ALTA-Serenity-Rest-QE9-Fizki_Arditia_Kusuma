package starter.reqres.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.reqres.ReqresAPI;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetListUserStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;
    //scenario 1
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {

        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then().body("page",equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_REQ_SCHEMA+"ListUserValidator/GetListUserJSONSchemaValidator.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Get list user with exceed parameter page {int}")
    public void getListUserWithExceedParameterPagePage(int page) {
        reqresAPI.getListUsers(page);
    }

    @Given("Get list user with invalid parameter page {string}")
    public void getListUserWithInvalidParameterPage(String page) {
        reqresAPI.getListUserInvalid(page);
    }


    // buat invalid page
}
