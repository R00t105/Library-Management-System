package restapiprojects.librarymanagementsystem.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUserDto {

    private String username;
    private String email;
    private String password;

}
