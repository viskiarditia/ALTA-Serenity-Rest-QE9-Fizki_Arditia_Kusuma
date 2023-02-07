package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDefinitions {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then().body("page",equalTo(page));
    }

    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(ReqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
        reqresAPI.postCreateUser(jsonReq);
    }

    @When("Send request pos create user")
    public void sendRequestPosCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Create")
    public void statusCodeShouldBeCreate(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body("name",equalTo(name)).body("job",equalTo(job));
    }
}
