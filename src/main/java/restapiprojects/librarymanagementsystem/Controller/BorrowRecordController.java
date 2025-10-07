package restapiprojects.librarymanagementsystem.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restapiprojects.librarymanagementsystem.DTO.BorrowRecordDto;
import restapiprojects.librarymanagementsystem.Service.BorrowRecordService;

import java.util.List;

@RestController
@RequestMapping("/borrow-records")
@RequiredArgsConstructor
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    @GetMapping
    public ResponseEntity<List<BorrowRecordDto>> getAllBorrowRecords() {
        return ResponseEntity.ok(borrowRecordService.getAllBorrowRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowRecordDto> getBorrowRecordById(@PathVariable int id) {
        return ResponseEntity.ok(borrowRecordService.getBorrowRecordById(id));
    }

    @PostMapping
    public ResponseEntity<BorrowRecordDto> createBorrowRecord(@Valid @RequestBody BorrowRecordDto borrowRecordDto) {
        return ResponseEntity.status(201).body(borrowRecordService.addBorrowRecord(borrowRecordDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowRecordDto> updateBorrowRecord(@PathVariable int id, @Valid @RequestBody BorrowRecordDto borrowRecordDto) {
        return ResponseEntity.ok(borrowRecordService.updateBorrowRecord(id, borrowRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBorrowRecord(@PathVariable int id) {
        borrowRecordService.deleteBorrowRecord(id);
        return ResponseEntity.ok("Borrow record deleted successfully");
    }

    @GetMapping("/search/by-member-id")
    public ResponseEntity<List<BorrowRecordDto>> getByMemberId(@RequestParam Integer memberId) {
        return ResponseEntity.ok(borrowRecordService.findByMemberId(memberId));
    }

    @GetMapping("/search/by-book-id")
    public ResponseEntity<List<BorrowRecordDto>> getByBookId(@RequestParam Integer bookId) {
        return ResponseEntity.ok(borrowRecordService.findByBookId(bookId));
    }

    @GetMapping("/search/not-returned")
    public ResponseEntity<List<BorrowRecordDto>> getUnreturnedRecords() {
        return ResponseEntity.ok(borrowRecordService.findByIsReturnedFalse());
    }

    @GetMapping("/search/overdue")
    public ResponseEntity<List<BorrowRecordDto>> getOverdueRecords() {
        return ResponseEntity.ok(borrowRecordService.findOverdueRecords());
    }

}
