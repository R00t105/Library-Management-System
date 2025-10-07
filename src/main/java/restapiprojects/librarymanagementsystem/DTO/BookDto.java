package restapiprojects.librarymanagementsystem.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDto {

    @NotBlank(message = "THIS FIELD IS REQUIRED")
    private String title;

    private int authorId;

    private String authorName;

}
