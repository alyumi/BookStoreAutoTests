package api.ValueObject;

public class CollectionOfIsbn {
    private String isbn;

    public CollectionOfIsbn(String isbn) {
        this.isbn = isbn;
    }

    public CollectionOfIsbn() {
    }

    public String getIsbn() {
        return isbn;
    }
}
