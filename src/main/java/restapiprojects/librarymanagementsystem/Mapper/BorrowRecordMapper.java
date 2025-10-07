package restapiprojects.librarymanagementsystem.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import restapiprojects.librarymanagementsystem.DTO.BorrowRecordDto;
import restapiprojects.librarymanagementsystem.Model.BorrowRecord;

@Mapper(componentModel = "spring")
public interface BorrowRecordMapper {
    @Mapping(target = "bookId", source = "borrowRecord.book.id")
    @Mapping(target = "bookName", source = "borrowRecord.book.title")
    @Mapping(target = "memberId", source = "borrowRecord.member.id")
    @Mapping(target = "memberName", source = "borrowRecord.member.name")
    BorrowRecordDto toDto(BorrowRecord borrowRecord);


    @Mapping(target = "book.id", source = "borrowRecordDto.bookId")
    @Mapping(target = "member.id", source = "borrowRecordDto.memberId")
    BorrowRecord toEntity(BorrowRecordDto borrowRecordDto);
}
