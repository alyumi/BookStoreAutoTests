package api.ValueObject;

import java.util.List;

public class AddListOfBooks {
    private String userId;
    private List<CollectionOfIsbn> collectionOfIsbns;

    public AddListOfBooks() {
    }

    public AddListOfBooks(String userId, List<CollectionOfIsbn> collectionOfIsbns) {
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public String getUserId() {
        return userId;
    }

    public List<CollectionOfIsbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }
}
