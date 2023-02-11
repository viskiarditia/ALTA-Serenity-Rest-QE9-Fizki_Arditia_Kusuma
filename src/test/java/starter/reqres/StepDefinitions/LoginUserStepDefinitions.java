package starter.reqres.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresReponses;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    //login successfull
    @Given("Post login success")
    public void postLoginSuccess() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"LoginUser/PostLoginUserSuccess.json");
        reqresAPI.loginSuccess(jsonReq);
    }

    @When("Send request post login success")
    public void sendRequestPostLoginSuccess() {
        SerenityRest.when()
                .post(ReqresAPI.POST_LOGIN_SUCCESS);
    }

    @And("Response body page should contain token {string}")
    public void responseBodyPageShouldContainToken(String token) {
        SerenityRest.then().body(ReqresReponses.TOKEN,equalTo(token));
    }

    @And("Post login success json schema validator")
    public void postLoginSuccessJsonSchemaValidator() {
        File json = new File(Constant.JSON_REQ_SCHEMA+"LoginUserValidator/PostLoginSuccessJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //login invalid empty password
    @Given("Post login empty password")
    public void postLoginEmptyPassword() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"LoginUser/PostLoginUserEmptyPassword.json");
        reqresAPI.loginUserInvalid(jsonReq);
    }

    @When("Send request post login empty password")
    public void sendRequestPostLoginEmptyPassword() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_INVALID);
    }

    @And("Post login empty password json schema validator")
    public void postLoginEmptyPasswordJsonSchemaValidator() {
        File json = new File(Constant.JSON_REQ_SCHEMA+"LoginUserValidator/PostLoginWithoutEmailOrPasswordJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //login invalid password
    @Given("Post login invalid password")
    public void postLoginInvalidPassword() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"LoginUser/PostLoginUserInvalidPassword.json");
        reqresAPI.loginUserInvalid(jsonReq);
    }

    @When("Send request post login invalid password")
    public void sendRequestPostLoginInvalidPassword() {
        SerenityRest.when().post((ReqresAPI.POST_LOGIN_INVALID));
    }

    //login invalid email
    @Given("Post login invalid email")
    public void postLoginInvalidEmail() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"LoginUser/PostLoginUserInvalidEmail.json");
        reqresAPI.loginUserInvalid(jsonReq);
    }

    @When("Send request post login invalid email")
    public void sendRequestPostLoginInvalidEmail() {
        SerenityRest.when().post((ReqresAPI.POST_LOGIN_INVALID));
    }

    @And("Post login invalid email json schema validator")
    public void postLoginInvalidEmailJsonSchemaValidator() {
        File jsonSchema = new File(Constant.JSON_REQ_SCHEMA+"LoginUserValidator/PostLoginWithoutEmailOrPasswordJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //login empty email
    @Given("Post login empty email")
    public void postLoginEmptyEmail() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"LoginUser/PostLoginUserEmptyEmail.json");
        reqresAPI.loginUserInvalid(jsonReq);
    }

    @When("Send request post login empty email")
    public void sendRequestPostLoginEmptyEmail() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_INVALID);
    }

    @And("Post login empty email json schema validator")
    public void postLoginEmptyEmailJsonSchemaValidator() {
        File jsonSchema = new File(Constant.JSON_REQ_SCHEMA+"LoginUserValidator/PostLoginWithoutEmailOrPasswordJsonSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }
}
