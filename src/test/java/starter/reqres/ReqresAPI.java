package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String BASE_URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static String GET_LIST_USERS =
            BASE_URL + "/api/users?page={page}";
    public static String POST_CREATE_USER =
            BASE_URL + "/api/users";


    @Step("Get List Users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Post Create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
