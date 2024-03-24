package api.ValueObject;

public class ReplaceIsbn {
    private String userId;
    private String isbn;

    public ReplaceIsbn() {
    }

    public ReplaceIsbn(String userId, String isbn) {
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
