package api.Steps;

import api.Specs.Specifications;
import api.ValueObject.Model.LoginModel;
import api.ValueObject.Model.LoginViewModel;
import api.ValueObject.Model.TokenViewModel;
import api.ValueObject.Result.CreateUserResult;
import api.ValueObject.Result.GetUserResult;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static api.Assertions.AccountAssert.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import io.qameta.allure.restassured.AllureRestAssured;

public class AccountSteps {
    @DisplayName("CreateUserStep")
    @Step
    public static CreateUserResult CreateUserStep(LoginViewModel login){
        Specifications.InstallSpecifications(Specifications.requestAccountSpec(), Specifications.responseSpecStatus(201));

        CreateUserResult resp = given()
                .when()
                .body(login)
                .post("User")
                .then().log().all()
                .extract().body().as(CreateUserResult.class);

        SuccessfulUserCreationAssert(login, resp);

        return resp;
    }

    @DisplayName("GetUserStep")
    @Step
    public static void GetUserStep(CreateUserResult user, TokenViewModel token){
        Specifications.InstallSpecifications(Specifications.requestAccountSpec(), Specifications.responseSpecStatus(200));
        GetUserResult resp = given()
                .header(
                        "Authorization", "Bearer " + token.getToken()
                )
                .when()
                .get("User/" + user.getUserId())
                .then().log().all()
                .log().headers()
                .extract().body().as(GetUserResult.class);

        SuccessfulUserGetAssert(user, resp);
    }

    @DisplayName("DeleteUserStep")
    @Step
    public static void DeleteUserStep(CreateUserResult user, TokenViewModel token){
        Specifications.InstallSpecifications(Specifications.requestAccountSpec(), Specifications.responseSpecStatus(204));

        given()
                .header(
                        "Authorization", "Bearer " + token.getToken()
                )
                .when()
                .delete("User/" + user.getUserId())
                .then().log().all();
    }

    @DisplayName("GenerateTokenStep")
    @Step
    public static TokenViewModel GenerateTokenStep(LoginViewModel login){
        Specifications.InstallSpecifications(Specifications.requestAccountSpec(), Specifications.responseSpecStatus(200));
        TokenViewModel resp = given()
                .filter(new AllureRestAssured())
                .when()
                .body(login)
                .post("GenerateToken")
                .then().log().all()
                .extract().body().as(TokenViewModel.class);

        SuccessfulAuthorizationAssert(resp);

        return resp;
    }

    @DisplayName("LoginUserStep")
    @Step
    public static LoginModel LoginUserStep(LoginViewModel login){
        Specifications.InstallSpecifications(Specifications.requestAccountSpec(), Specifications.responseSpecStatus(200));
        LoginModel resp = given()
                .when()
                .body(login)
                .post("Login")
                .then().log().all()
                .extract().body().as(LoginModel.class);

        SuccessfulLoginAssert(login, resp);
        return resp;
    }
}
