package restapiprojects.librarymanagementsystem.Mapper;

import org.mapstruct.Mapper;
import restapiprojects.librarymanagementsystem.DTO.AuthorDto;
import restapiprojects.librarymanagementsystem.Model.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toDto(Author author);
    Author toEntity(AuthorDto authorDto);
}
