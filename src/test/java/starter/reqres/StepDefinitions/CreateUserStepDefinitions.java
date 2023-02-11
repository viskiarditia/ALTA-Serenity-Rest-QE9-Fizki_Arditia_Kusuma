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

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;
    //valid data
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UserReqBody.json");
        reqresAPI.postCreateUser(jsonReq);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }


    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body(ReqresReponses.NAME,equalTo(name))
                .body(ReqresReponses.JOB,equalTo(job));
    }

    //negative case 1 without field name
    @Given("Post create new user without field name in json")
    public void postCreateNewUserWithoutFieldNameInJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"CreateNewUser/PostCreateNewUserWithoutFieldName.json");
        reqresAPI.postCreateNewUserInvalid(jsonReq);
    }

    @When("Send request post create new user without field name")
    public void sendRequestPostCreateNewUserWithoutFieldName() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER_INVALID);
    }

    @And("Validate post create user json schema")
    public void validateGetCreateUserJsonSchema() {
        File jsonSchemaCreateUser = new File(Constant.JSON_REQ_SCHEMA+"CreateNewUserValidator/PostCreateNewUserJSONSchemaValidator.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaCreateUser));

    }

    //negative case 1 without job
    @Given("Post create new user without field job in json")
    public void postCreateNewUserWithoutFieldJobInJson() {
        File jsonSchemaCreateUserWithoutJob = new File(Constant.JSON_REQ_BODY+"CreateNewUser/PostCreateNewUserWithoutFieldJob.json");
        reqresAPI.postCreateNewUserInvalid(jsonSchemaCreateUserWithoutJob);
    }

    @When("Send request post create new user without field job")
    public void sendRequestPostCreateNewUserWithoutFieldJob() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER_INVALID);
    }

    // negative case with empty name
    @Given("Pos create new user with empty name")
    public void posCreateNewUserWithEmptyName() {
       File jsoReq = new File(Constant.JSON_REQ_BODY+"CreateNewUser/PostCreateNewUserWithoutFieldName.json");
       reqresAPI.postCreateNewUserInvalid(jsoReq);
    }

    @When("Send request post create new user with empty name")
    public void sendRequestPostCreateNewUserWithEmptyName() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER_INVALID);
    }

    //negative case with empty job
    @Given("Post create new user with empty job")
    public void postCreateNewUserWithEmptyJob() {
        File jsoReq = new File(Constant.JSON_REQ_BODY+"CreateNewUser/PostCreateNewUserWithEmptyJob.json");
        reqresAPI.postCreateNewUserInvalid(jsoReq);
    }

    @When("Send request post create new user with empty job")
    public void sendRequestPostCreateNewUserWithEmptyJob() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER_INVALID);
    }
}
