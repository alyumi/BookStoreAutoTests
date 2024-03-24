package api.Steps;

import api.Specs.Specifications;
import api.ValueObject.AddListOfBooks;
import api.ValueObject.CollectionOfIsbn;
import api.ValueObject.Model.AllBooksModel;
import api.ValueObject.Model.BookModel;
import api.ValueObject.Model.LoginModel;
import api.ValueObject.Model.LoginViewModel;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class BookStoreSteps {
    @DisplayName("GetAllBooksStep")
    public static List<CollectionOfIsbn> GetAllBooksStep(){
        Specifications.InstallSpecifications(Specifications.requestBookstoreSpec(), Specifications.responseSpecStatus(200));
        AllBooksModel resp = given()
                .when()
                .get("Books")
                .then().log().all()
                .extract().body().as(AllBooksModel.class);

        assertAll(
                () -> assertFalse(resp.getBooks().isEmpty())
        );

        return resp.getBooks().stream().map(BookModel::getIsbn).toList();
    }

    @DisplayName("AddListOfBooksStep")
    public static void AddListOfBooksStep(LoginModel login, List<CollectionOfIsbn> collectionOfIsbns){
        Specifications.InstallSpecifications(Specifications.requestBookstoreSpec(), Specifications.responseSpecStatus(201));
        AddListOfBooks addListOfBooks = new AddListOfBooks(
                login.getUserId(),
                collectionOfIsbns
        );
        given()
                .header("Authorization", "Bearer " + login.getToken())
                .when()
                .body(addListOfBooks)
                .post("Books")
                .then().log().all();

    }
}
