package api.ValueObject.Result;

import api.ValueObject.Model.BookModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetUserResult {

    private String userId;
    private String username;
    private List<BookModel> books;

    public GetUserResult() {
    }

    public GetUserResult(String userId, String username, List<BookModel> books) {
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
