package starter.reqres.StepDefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class ReqresStatusCode {

    // status code 200 OK
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {SerenityRest.then().statusCode(ok);
    }

    // status code 201 created
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    // status code 204 no content
    @Then("Status code should be {int} no Content")
    public void statusCodeShouldBeNoContent(int delete) {
        SerenityRest.then().statusCode(delete);
    }

    // status code 400 Bad Request
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
    // status code 404 NOT FOUND
    @Then("Should return status Code {int} Not Found")
    public void shouldReturnStatusCodeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }


}
