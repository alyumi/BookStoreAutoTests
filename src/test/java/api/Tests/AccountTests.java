package api.Tests;

import api.Parameters.UsersParameters;
import api.ValueObject.CollectionOfIsbn;
import api.ValueObject.Model.LoginModel;
import api.ValueObject.Model.LoginViewModel;
import api.ValueObject.Model.TokenViewModel;
import api.ValueObject.Result.CreateUserResult;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;

import static api.Steps.AccountSteps.*;
import static api.Steps.BookStoreSteps.AddListOfBooksStep;
import static api.Steps.BookStoreSteps.GetAllBooksStep;

public class AccountTests {

    CreateUserResult userResult;
    TokenViewModel token;

    @AfterEach
    public void TearDown(){
        DeleteUserStep(userResult, token);
    }

    @ParameterizedTest
    @DisplayName("Create User")
    @Description("This test attempts to create user using generated user token")
    @Severity(SeverityLevel.CRITICAL)
    @ArgumentsSource(UsersParameters.class)
    public void CreateUser(LoginViewModel user){
        userResult = CreateUserStep(user);
        token = GenerateTokenStep(user);
    }

    @ParameterizedTest
    @DisplayName("Create, Login And Get Client")
    @Severity(SeverityLevel.NORMAL)
    @ArgumentsSource(UsersParameters.class)
    public void CreateAndGetClient(LoginViewModel user){
        userResult = CreateUserStep(user);
        token = GenerateTokenStep(user);
        LoginUserStep(user);
        GetUserStep(userResult, token);
    }

    @ParameterizedTest
    @DisplayName("Create, Login, Get, Add List of Books Client")
    @Severity(SeverityLevel.CRITICAL)
    @ArgumentsSource(UsersParameters.class)
    public void CreateAddAndBooksClient(LoginViewModel user){
        userResult = CreateUserStep(user);
        token = GenerateTokenStep(user);
        LoginModel loginModel = LoginUserStep(user);
        GetUserStep(userResult, token);
        List<CollectionOfIsbn> isbnList = GetAllBooksStep();
        AddListOfBooksStep(loginModel, isbnList);
    }
}
