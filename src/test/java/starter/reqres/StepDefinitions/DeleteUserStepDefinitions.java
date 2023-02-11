package starter.reqres.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    //scenario 4
    @Given("Delete user with valid {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteuser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Given("Delete user with invalid {string}")
    public void deleteUserWithInvalid(String id) {
        reqresAPI.deleteUserInvalid(id);
    }


    // buat invalid delete id

}
