package api.Tests;

import api.Specs.Specifications;
import api.ValueObject.AddListOfBooks;
import api.ValueObject.CollectionOfIsbn;
import api.ValueObject.Model.LoginModel;
import api.ValueObject.Model.LoginViewModel;
import api.ValueObject.Model.TokenViewModel;
import api.ValueObject.Result.CreateUserResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static api.Steps.AccountSteps.*;
import static api.Steps.BookStoreSteps.AddListOfBooksStep;
import static api.Steps.BookStoreSteps.GetAllBooksStep;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTests {

    /*@BeforeEach
    public void InstallSpecs(){
        Specifications.InstallSpecifications(
                Specifications.requestAccountSpec(),
                Specifications.responseSpecStatus(200)
        );
    }*/

    @Test
    @DisplayName("Create, Login, Get And Delete Client")
    public void CreateGetAndDeleteClient(){
        LoginViewModel login = new LoginViewModel("asdf", "Qwerty@1234");
        CreateUserResult user = CreateUserStep(login);
        TokenViewModel token = GenerateTokenStep(login);
        LoginUserStep(login);
        GetUserStep(user, token);
        DeleteUserStep(user, token);
    }

    @Test
    @DisplayName("Create, Login, Get, Add List of Books And Delete Client")
    public void CreateAddBooksAndDeleteClient(){
        LoginViewModel login = new LoginViewModel("asdf", "Qwerty@1234");
        CreateUserResult user = CreateUserStep(login);
        TokenViewModel token = GenerateTokenStep(login);
        LoginModel loginModel = LoginUserStep(login);
        GetUserStep(user, token);
        List<CollectionOfIsbn> isbnList = GetAllBooksStep();
        AddListOfBooksStep(loginModel, isbnList);
        DeleteUserStep(user, token);
    }
}
