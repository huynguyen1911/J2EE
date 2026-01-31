package com.example.baitap2.Service;

import com.example.baitap2.Model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>(List.of(
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell")));

    public List<Book> getAllBooks() {
        return books;
    }

    private int nextId = 4;

    public Optional<Book> getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public void updateBook(Book updatedBook) {
        books.stream().filter(book -> book.getId() == updatedBook.getId()).findFirst().ifPresent(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        });
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
