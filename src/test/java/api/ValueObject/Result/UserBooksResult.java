package api.ValueObject.Result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserBooksResult {
    @JsonProperty("userID")
    private String userId;
    private String isbn;
    private String message;

    public UserBooksResult() {
    }

    public UserBooksResult(String userId, String isbn, String message) {
        this.userId = userId;
        this.isbn = isbn;
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getMessage() {
        return message;
    }
}
