package restapiprojects.librarymanagementsystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("BOOK NOT FOUND WITH ID : " + id);
    }
}
