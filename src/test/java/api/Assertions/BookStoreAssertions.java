package api.Assertions;

import api.ValueObject.Model.AllBooksModel;

import static org.junit.jupiter.api.Assertions.*;

public class BookStoreAssertions {

    public static void SuccessfulGetListOfBooks(AllBooksModel resp){
        assertAll(
                () -> assertFalse(resp.getBooks().isEmpty())
        );
    }
}
