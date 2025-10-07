package restapiprojects.librarymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restapiprojects.librarymanagementsystem.Model.BorrowRecord;
import java.util.List;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {

    List<BorrowRecord> findByMemberId(Integer memberId);
    List<BorrowRecord> findByBookId(Integer bookId);
    List<BorrowRecord> findByIsReturnedFalse();

    @Query("SELECT b FROM BorrowRecord b WHERE b.isReturned = false AND b.returnDate < CURRENT_TIMESTAMP")
    List<BorrowRecord> findOverdueRecords();

}
