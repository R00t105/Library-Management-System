package restapiprojects.librarymanagementsystem.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BorrowRecordDto {

    private int bookId;
    private String bookName;
    private int memberId;
    private String memberName;

}
