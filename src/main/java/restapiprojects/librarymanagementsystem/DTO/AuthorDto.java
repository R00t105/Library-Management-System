package restapiprojects.librarymanagementsystem.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorDto {

    @NotBlank(message = "THIS FIELD IS REQUIRED")
    private String name;

    @NotBlank(message = "THIS FIELD IS REQUIRED")
    private String nationality;

    private LocalDate dateOfBirth;

}
