package restapiprojects.librarymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapiprojects.librarymanagementsystem.Model.Author;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByName(String name);
    List<Author> findByNationality(String nationality);

}
