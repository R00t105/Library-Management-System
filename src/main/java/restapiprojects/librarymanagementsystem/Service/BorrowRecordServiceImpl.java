package restapiprojects.librarymanagementsystem.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import restapiprojects.librarymanagementsystem.DTO.BorrowRecordDto;
import restapiprojects.librarymanagementsystem.Exception.BookNotFoundException;
import restapiprojects.librarymanagementsystem.Exception.BorrowRecordNotFoundException;
import restapiprojects.librarymanagementsystem.Exception.MemberNotFoundException;
import restapiprojects.librarymanagementsystem.Mapper.BorrowRecordMapper;
import restapiprojects.librarymanagementsystem.Model.Book;
import restapiprojects.librarymanagementsystem.Model.BorrowRecord;
import restapiprojects.librarymanagementsystem.Model.Member;
import restapiprojects.librarymanagementsystem.Repository.BookRepository;
import restapiprojects.librarymanagementsystem.Repository.BorrowRecordRepository;
import restapiprojects.librarymanagementsystem.Repository.MemberRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final BorrowRecordMapper borrowRecordMapper;

    @Override
    public List<BorrowRecordDto> getAllBorrowRecords() {
        return borrowRecordRepository.findAll().stream().map(borrowRecordMapper::toDto).toList();
    }

    @Override
    public BorrowRecordDto getBorrowRecordById(int id) {
        return borrowRecordRepository.findById(id).map(borrowRecordMapper::toDto).orElseThrow(() -> new BorrowRecordNotFoundException(id));
    }

    @Override
    public BorrowRecordDto addBorrowRecord(BorrowRecordDto borrowRecordDto) {
        if (!bookRepository.existsById(borrowRecordDto.getBookId())) {
            throw new BookNotFoundException(borrowRecordDto.getBookId());
        }
        if (!memberRepository.existsById(borrowRecordDto.getMemberId())) {
            throw new MemberNotFoundException(borrowRecordDto.getMemberId());
        }
        BorrowRecord borrowRecord = borrowRecordMapper.toEntity(borrowRecordDto);

        BorrowRecord savedBorrowRecord = borrowRecordRepository.save(borrowRecord);
        return borrowRecordMapper.toDto(savedBorrowRecord);
    }

    @Override
    public BorrowRecordDto updateBorrowRecord(int id, BorrowRecordDto borrowRecordDto) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id).orElseThrow(() -> new BorrowRecordNotFoundException(id));
        Book book = bookRepository.findById(borrowRecordDto.getBookId()).orElseThrow(() -> new BookNotFoundException(borrowRecordDto.getBookId()));
        Member member = memberRepository.findById(borrowRecordDto.getMemberId()).orElseThrow(() -> new MemberNotFoundException(borrowRecordDto.getMemberId()));
        borrowRecord.setBook(book);
        borrowRecord.setMember(member);

        BorrowRecord savedBorrowRecord = borrowRecordRepository.save(borrowRecord);
        return borrowRecordMapper.toDto(savedBorrowRecord);
    }

    @Override
    @Transactional
    public void deleteBorrowRecord(int id) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id).orElseThrow(() -> new BorrowRecordNotFoundException(id));
        borrowRecordRepository.delete(borrowRecord);
    }

    @Override
    public List<BorrowRecordDto> findByMemberId(Integer memberId) {
        return borrowRecordRepository.findByMemberId(memberId).stream().map(borrowRecordMapper::toDto).toList();
    }

    @Override
    public List<BorrowRecordDto> findByBookId(Integer bookId) {
        return borrowRecordRepository.findByBookId(bookId).stream().map(borrowRecordMapper::toDto).toList();
    }

    @Override
    public List<BorrowRecordDto> findByIsReturnedFalse() {
        return borrowRecordRepository.findByIsReturnedFalse().stream().map(borrowRecordMapper::toDto).toList();
    }

    @Override
    public List<BorrowRecordDto> findOverdueRecords() {
        return borrowRecordRepository.findOverdueRecords().stream().map(borrowRecordMapper::toDto).toList();
    }

}
