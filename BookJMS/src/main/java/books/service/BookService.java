package books.service;

import books.data.BookRepository;
import books.domain.Book;
import books.integration.JMsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    JMsSender jMsSender;

    public void add(Book book) {
        bookRepository.save(book);
        jMsSender.sendMessage(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public void delete(String isbn) {
        bookRepository.delete(isbn);
    }

    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }
}
