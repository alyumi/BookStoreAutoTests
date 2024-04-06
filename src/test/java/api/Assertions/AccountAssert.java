package api.Assertions;

import api.ValueObject.Model.LoginModel;
import api.ValueObject.Model.LoginViewModel;
import api.ValueObject.Model.TokenViewModel;
import api.ValueObject.Result.CreateUserResult;
import api.ValueObject.Result.GetUserResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountAssert {
    public static void SuccessfulAuthorizationAssert(TokenViewModel resp){
        assertAll(
                () -> assertNotNull(resp.getToken()),
                () -> assertNotNull(resp.getExpires()),
                () -> assertEquals("Success", resp.getStatus()),
                () -> assertEquals("User authorized successfully.", resp.getResult())
        );
    }

    public static void SuccessfulLoginAssert(LoginViewModel login, LoginModel resp){
        assertAll(
                () -> assertEquals(login.getUserName(), resp.getUsername()),
                () -> assertEquals(login.getPassword(), resp.getPassword()),
                () -> assertNotNull(resp.getUserId()),
                () -> assertNotNull(resp.getToken()),
                () -> assertNotNull(resp.getExpires()),
                () -> assertNotNull(resp.getCreated_date()),
                () -> assertFalse(resp.getIsActive())
        );
    }

    public static void SuccessfulUserCreationAssert(LoginViewModel login, CreateUserResult resp){
        assertAll(
                () -> assertEquals(login.getUserName(), resp.getUsername()),
                () -> assertNotNull(resp.getUserId()),
                () -> assertTrue(resp.getBooks().isEmpty())
        );
    }

    public static void SuccessfulUserGetAssert(CreateUserResult user, GetUserResult resp){
        assertAll(
                () -> assertEquals(user.getUserId(), resp.getUserId()),
                () -> assertEquals(user.getUsername(), resp.getUsername()),
                () -> assertTrue(resp.getBooks().isEmpty())
        );
    }
}
