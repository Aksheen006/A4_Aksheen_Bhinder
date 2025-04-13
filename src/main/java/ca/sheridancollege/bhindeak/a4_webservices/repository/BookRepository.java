// Author: Aksheen, Student ID: 991762812
package ca.sheridancollege.bhindeak.a4_webservices.repository;

import ca.sheridancollege.bhindeak.a4_webservices.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
}