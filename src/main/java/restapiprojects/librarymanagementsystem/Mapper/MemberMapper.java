package restapiprojects.librarymanagementsystem.Mapper;

import org.mapstruct.Mapper;
import restapiprojects.librarymanagementsystem.DTO.MemberDto;
import restapiprojects.librarymanagementsystem.Model.Member;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberDto toDto(Member member);
    Member toEntity(MemberDto memberDto);
}
