package api.Steps;

import api.Specs.Specifications;
import api.ValueObject.AddListOfBooks;
import api.ValueObject.CollectionOfIsbn;
import api.ValueObject.Model.AllBooksModel;
import api.ValueObject.Model.BookModel;
import api.ValueObject.Model.LoginModel;
import api.ValueObject.Model.LoginViewModel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static api.Assertions.BookStoreAssertions.SuccessfulGetListOfBooks;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class BookStoreSteps {

    @BeforeAll
    public static void SetUp(){
        Specifications.InstallSpecifications(Specifications.requestBookstoreSpec());
    }

    @Step
    @DisplayName("AddListOfBooksStep")
    public static void AddListOfBooksStep(LoginModel login, List<CollectionOfIsbn> collectionOfIsbns){
        AddListOfBooks addListOfBooks = new AddListOfBooks(
                login.getUserId(),
                collectionOfIsbns
        );
        given()
                .header("Authorization", "Bearer " + login.getToken())
                .when()
                .body(addListOfBooks)
                .post("Books")
                .then().log().all()
                .statusCode(201);

    }

    @Step
    @DisplayName("GetAllBooksStep")
    public static List<CollectionOfIsbn> GetAllBooksStep(){
        AllBooksModel resp = given()
                .when()
                .get("Books")
                .then().log().all()
                .statusCode(200)
                .extract().body().as(AllBooksModel.class);

        SuccessfulGetListOfBooks(resp);

        return resp.getBooks().stream().map(BookModel::getIsbn).toList();
    }
}
