package com.bookstore.bookstoremanagement;

import com.bookstore.bookstoremanagement.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    // Initialize some pre-stored books
    {
        books.add(new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 10.99));
        books.add(new Book(2L, "To Kill a Mockingbird", "Harper Lee", "9780061120084", 12.50));
        books.add(new Book(3L, "1984", "George Orwell", "9780451524935", 9.75));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Book addBook(Book book) {
        book.setId((long) (books.size() + 1));
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
        return null;
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
