package api.ValueObject.Model;

import java.util.List;

public class AllBooksModel {
    private List<BookModel> books;

    public AllBooksModel() {
    }

    public AllBooksModel(List<BookModel> books) {
        this.books = books;
    }

    public List<BookModel> getBooks() {
        return books;
    }
}
