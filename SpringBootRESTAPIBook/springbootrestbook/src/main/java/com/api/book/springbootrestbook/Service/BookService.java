package com.api.book.springbootrestbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.springbootrestbook.Dao.BookRepository;
import com.api.book.springbootrestbook.entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<Book>();

    // static {

    // list.add(new Book(1, "Java Complete Reference", "Herbert Schildt"));
    // list.add(new Book(2, "Python Complete Reference", "Mark Lutz"));
    // list.add(new Book(3, "C Programming Reference", "Brian Kernighan"));
    // }

    // get all book
    public List<Book> getAllBooks() {

        List<Book> list = (List<Book>) this.bookRepository.findAll();

        return list;

    }

    // get single book id
    public Book getBookById(int bookId) {

        Book book = null;
        try {

            // book = list.stream().filter(e -> e.getbookId() == bookId).findFirst().get();
            book = this.bookRepository.findById(bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;

    }

    // adding book
    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        return result;
    }

    // delete book
    public void deleteBook(int bookId) {

        // list = list.stream().filter(book -> book.getbookId() !=
        // bid).collect(Collectors.toList());
        bookRepository.deleteById(bookId);
    }

    // Update book
    public void updateBook(Book book, int bookId) {

        // list = list.stream().map(b -> {

        // if (b.getbookId() == bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());

        // }
        // return b;
        // }).collect(Collectors.toList());

        book.setbookId(bookId);
        bookRepository.save(book);
    }
}
