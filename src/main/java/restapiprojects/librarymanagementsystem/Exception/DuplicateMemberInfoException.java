package restapiprojects.librarymanagementsystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateMemberInfoException extends RuntimeException {
    public DuplicateMemberInfoException(String message) {
        super(message);
    }
}
