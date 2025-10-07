package restapiprojects.librarymanagementsystem.Service;

import restapiprojects.librarymanagementsystem.DTO.BookDto;
import java.util.List;
import java.util.Optional;

public interface BookService {

    // CRUD
    List<BookDto> getAllBooks();
    BookDto getBookById(int id);
    BookDto addBook(BookDto bookDto);
    BookDto updateBook(int id, BookDto bookDto);
    void deleteBook(int id);

    // Searching
    Optional<BookDto> searchByTitle(String title);
    List<BookDto> searchByAuthorId(Integer authorId);
    List<BookDto> searchByTitleIgnoreCase(String keyword);

}
