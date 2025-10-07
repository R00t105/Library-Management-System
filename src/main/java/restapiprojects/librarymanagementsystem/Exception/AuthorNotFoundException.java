package restapiprojects.librarymanagementsystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(int id) {
        super("AUTHOR NOT FOUND WITH ID : " + id);
    }
}
