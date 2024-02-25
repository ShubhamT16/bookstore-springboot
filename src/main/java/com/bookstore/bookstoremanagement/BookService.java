package com.bookstore.bookstoremanagement;

import com.bookstore.bookstoremanagement.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(Long id, Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setIsbn(updatedBook.getIsbn());
                book.setPrice(updatedBook.getPrice());
                return book;
            }
        }
        return null; // Book not found
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public List<Book> getAllBooks() {
        return books;
    }
}