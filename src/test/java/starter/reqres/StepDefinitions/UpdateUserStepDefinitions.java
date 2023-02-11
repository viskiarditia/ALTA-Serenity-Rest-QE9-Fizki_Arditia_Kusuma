package starter.reqres.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.reqres.ReqresAPI;

import java.io.File;

public class UpdateUserStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    //update valid data
    @Given("Update user with valid json parameter id {int}")
    public void updateUserWithValidJsonParameterIdId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UserReqBody.json");
        reqresAPI.putUpdateUser(id,jsonReq);
    }

    @When("Send request put updater user")
    public void sendRequestPutUpdaterUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }


    //update valid data with empty name
    @Given("Put update user with empty name on id {int}")
    public void putUpdateUserWithEmptyNameOnIdId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UpdateUser/PutUpdateUserWithEmptyName.json");
        reqresAPI.putUpdateUser(id,jsonReq);
    }

    @When("Send request put update user with empty name")
    public void sendRequestPutUpdateUserWithEmptyName() {
        SerenityRest.when().post(ReqresAPI.PUT_UPDATE_USER);
    }

    //update valid data with empty job
    @Given("Put update user with empty job on id {int}")
    public void putUpdateUserWithEmptyJobOnIdId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UpdateUser/PutUpdateUserWithEmptyJob.json");
        reqresAPI.putUpdateUser(id,jsonReq);
    }

    @When("Send request put update user with empty job")
    public void sendRequestPutUpdateUserWithEmptyJob() {
        SerenityRest.when().post(ReqresAPI.PUT_UPDATE_USER);
    }

    //update valid data without field name

    @Given("Put update user without field name on id {int}")
    public void putUpdateUserWithoutFieldNameOnIdId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UpdateUser/PutUpdateUserWithoutFieldName.json");
        reqresAPI.putUpdateUser(id,jsonReq);
    }

    @When("Send request put update user without field name")
    public void sendRequestPutUpdateUserWithoutFieldName() {
        SerenityRest.when().post(ReqresAPI.PUT_UPDATE_USER);
    }

    //update valid data without field job
    @Given("Put update user without field job on id {int}")
    public void putUpdateUserWithoutFieldJobOnIdId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UpdateUser/PutUpdateUserWithoutFieldJob.json");
        reqresAPI.putUpdateUser(id,jsonReq);
    }

    @When("Send request put update user without field job")
    public void sendRequestPutUpdateUserWithoutFieldJob() {
        SerenityRest.when().post(ReqresAPI.PUT_UPDATE_USER);
    }
}
