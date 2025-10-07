package restapiprojects.librarymanagementsystem.Service;

import org.springframework.stereotype.Service;
import restapiprojects.librarymanagementsystem.DTO.AuthorDto;
import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {

    // CRUD
    List<AuthorDto> getAllAuthors();
    AuthorDto getAuthorById(int id);
    AuthorDto addAuthor(AuthorDto authorDto);
    AuthorDto updateAuthor(int id, AuthorDto authorDto);
    void deleteAuthor(int id);

    // Searching
    Optional<AuthorDto> findByName(String name);
    List<AuthorDto> findByNationality(String nationality);

}
