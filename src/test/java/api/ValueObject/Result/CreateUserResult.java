package api.ValueObject.Result;

import api.ValueObject.Model.BookModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateUserResult {
    @JsonProperty("userID")
    private String userId;
    private String username;
    private List<BookModel> books;

    public CreateUserResult() {
    }

    public CreateUserResult(String userId, String username, List<BookModel> books) {
        this.userId = userId;
        this.username = username;
        this.books = books;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<BookModel> getBooks() {
        return books;
    }
}
