package restapiprojects.librarymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapiprojects.librarymanagementsystem.Model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByTitle(String title);
    List<Book> findByAuthorId(Integer authorId);
    List<Book> findByTitleContainingIgnoreCase(String keyword);


}
