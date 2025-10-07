package restapiprojects.librarymanagementsystem.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {

    @NotBlank(message = "THIS FIELD IS REQUIRED")
    private String name;

    @NotBlank(message = "THIS FIELD IS REQUIRED")
    @Email(message = "ENTER A VALID EMAIL")
    private String email;

    @NotBlank(message = "THIS FIELD IS REQUIRED")
    private String phone;

}
