package books;

import java.util.Collection;

public class Books {

    private Collection<Book> books;

    public Books() {}

    public Books(Collection<Book> books) {
        this.books = books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Books{" +
                "books=" + books +
                '}';
    }
}
