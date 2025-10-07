package restapiprojects.librarymanagementsystem.DTO;

import lombok.*;

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
