package api.ValueObject.Result;

public class BookResult {
    private String userId;
    private String message;

    public BookResult() {
    }

    public BookResult(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }
}
