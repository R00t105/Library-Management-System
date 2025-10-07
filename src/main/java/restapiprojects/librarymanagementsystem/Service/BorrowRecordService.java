package restapiprojects.librarymanagementsystem.Service;

import org.springframework.data.jpa.repository.Query;
import restapiprojects.librarymanagementsystem.DTO.BorrowRecordDto;
import java.util.List;

public interface BorrowRecordService {

    // CRUD
    List<BorrowRecordDto> getAllBorrowRecords();
    BorrowRecordDto getBorrowRecordById(int id);
    BorrowRecordDto addBorrowRecord(BorrowRecordDto borrowRecordDto);
    BorrowRecordDto updateBorrowRecord(int id, BorrowRecordDto borrowRecordDto);
    void deleteBorrowRecord(int id);

    // Searching
    List<BorrowRecordDto> findByMemberId(Integer memberId);
    List<BorrowRecordDto> findByBookId(Integer bookId);
    List<BorrowRecordDto> findByIsReturnedFalse();

    @Query("SELECT b FROM BorrowRecord b WHERE b.isReturned = false AND b.returnDate < CURRENT_TIMESTAMP")
    List<BorrowRecordDto> findOverdueRecords();

}
