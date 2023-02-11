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

public class RegisterUserStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

// register user valid
    @Given("Register user with valid json")
    public void registerUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterUser/PostRegisterUserSuccess.json");
        reqresAPI.postRegisterSuccess(jsonReq);

    }

    @When("Send request post register user success")
    public void sendRequestPostRegisterUserSuccess() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCESS);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdIdAndToken(int id, String token) {
        SerenityRest.then().
                body(ReqresReponses.ID,equalTo(id))
                .body(ReqresReponses.TOKEN,equalTo(token));

    }

    @And("validate json schema success register user")
    public void validateJsonSchemaSuccessRegisterUser() {
       File jsonReq = new File(Constant.JSON_REQ_SCHEMA+"RegisterUserValidator/PostRegisterSuccessJsonSchemaValidator.json");
       SerenityRest.then()
               .assertThat()
               .body(JsonSchemaValidator.matchesJsonSchema(jsonReq));
    }



// register user invalid without email
    @Given("Register user without email invalid json")
    public void registerUserWithoutEmailInvalidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterUser/PostRegisterUserWithoutFieldEmail.json");
        reqresAPI.postRegisterInvalid(jsonReq);
    }

    @When("Send request post register without email")
    public void sendRequestPostRegisterWithoutEmail() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_INVALID);
    }

    @And("Response body should show message {string}")
    public void responseBodyShouldShowMessage(String error) {
        SerenityRest.then().body(ReqresReponses.ERROR,equalTo(error));
    }

    @And("Validate json schema without email register user")
    public void validateJsonSchemaWithoutEmailRegisterUser() {
        File json = new File(Constant.JSON_REQ_SCHEMA+"RegisterUserValidator/PostRegisterWithoutEmailOrPasswordValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//invalid password
    @Given("Register user without password invalid json")
    public void registerUserWithoutPasswordInvalidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterUser/PostRegisterUserWithoutFieldPassword.json");
        reqresAPI.postRegisterInvalid(jsonReq);
    }

    @And("Validate json schema without password register user")
    public void validateJsonSchemaWithoutPasswordRegisterUser() {
        File json = new File(Constant.JSON_REQ_SCHEMA+"RegisterUserValidator/PostRegisterWithoutEmailOrPasswordValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));

    }

    @When("Send request post register without password")
    public void sendRequestPostRegisterWithoutPassword() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_INVALID);
    }

}

