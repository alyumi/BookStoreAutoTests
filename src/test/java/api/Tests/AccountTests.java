package api.Tests;

import api.Parameters.UsersParameters;
import api.ValueObject.CollectionOfIsbn;
import api.ValueObject.Model.LoginModel;
import api.ValueObject.Model.LoginViewModel;
import api.ValueObject.Model.TokenViewModel;
import api.ValueObject.Model.User;
import api.ValueObject.Result.CreateUserResult;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    public void CreateUser(LoginViewModel login){
        userResult = CreateUserStep(login);
        token = GenerateTokenStep(login);
    }

    @ParameterizedTest
    @DisplayName("Create, Login And Get Client")
    @Severity(SeverityLevel.NORMAL)
    @ArgumentsSource(UsersParameters.class)
    public void CreateAndGetClient(LoginViewModel login){
        userResult = CreateUserStep(login);
        token = GenerateTokenStep(login);
        LoginUserStep(login);
        GetUserStep(userResult, token);
    }

    @ParameterizedTest
    @DisplayName("Create, Login, Get, Add List of Books Client")
    @Severity(SeverityLevel.CRITICAL)
    @ArgumentsSource(UsersParameters.class)
    public void CreateAddAndBooksClient(LoginViewModel login){
        userResult = CreateUserStep(login);
        token = GenerateTokenStep(login);
        LoginModel loginModel = LoginUserStep(login);
        GetUserStep(userResult, token);
        List<CollectionOfIsbn> isbnList = GetAllBooksStep();
        AddListOfBooksStep(loginModel, isbnList);
    }
}
