// Author: Aksheen, Student ID: 991762812
package ca.sheridancollege.bhindeak.a4_webservices.service;

import ca.sheridancollege.bhindeak.a4_webservices.entity.Book;
import ca.sheridancollege.bhindeak.a4_webservices.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Create a book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Update a book
    public Book updateBook(Long id, Book book) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthorName(book.getAuthorName());
            updatedBook.setPrice(book.getPrice());
            updatedBook.setQuantity(book.getQuantity());
            return bookRepository.save(updatedBook);
        }
        return null;
    }

    // Delete a book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Find books by title
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}