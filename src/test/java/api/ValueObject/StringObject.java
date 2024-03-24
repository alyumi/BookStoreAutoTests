package api.ValueObject;

public class StringObject {
    private String userId;
    private String isbn;

    public StringObject() {
    }

    public StringObject(String userId, String isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }

    public String getUserId() {
        return userId;
    }

    public String getIsbn() {
        return isbn;
    }
}
