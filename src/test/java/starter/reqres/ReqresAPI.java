package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String GET_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER_INVALID = Constant.BASE_URL+"/apo/user/{id}";
    public static String POST_CREATE_NEW_USER_INVALID = Constant.BASE_URL+"/api/users";
    public static String POST_REGISTER_SUCCESS = Constant.BASE_URL+"/api/register";
    public static String POST_REGISTER_INVALID = Constant.BASE_URL+"/api/register";
    public  static String POST_LOGIN_SUCCESS = Constant.BASE_URL+"/api/login";
    public static String POST_LOGIN_INVALID = Constant.BASE_URL+"/api/login";

    @Step("Get List Users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get List User Invalid Parameter")
    public void getListUserInvalid(String page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Post Create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get Single User")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Get single user invalid id")
    public void getSingleUserInvalidId(String id){
        SerenityRest.given().
                pathParam("id", id);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete User")
    public void deleteuser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Delete User Invalid")
    public void deleteUserInvalid(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Post Create new user invalid")
    public void postCreateNewUserInvalid(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user success")
    public void postRegisterSuccess(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register user invalid")
    public void postRegisterInvalid(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Login success")
    public void loginSuccess(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Login User Invalid")
    public void loginUserInvalid(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);

    }

}
