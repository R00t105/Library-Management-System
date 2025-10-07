package restapiprojects.librarymanagementsystem.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import restapiprojects.librarymanagementsystem.DTO.BookDto;
import restapiprojects.librarymanagementsystem.Model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "authorId", source = "book.author.id")
    @Mapping(target = "authorName", source = "book.author.name")
    BookDto toDto(Book book);

    @Mapping(target = "author.id", source = "bookDto.authorId")
    @Mapping(target = "author.name", source = "bookDto.authorName")
    Book toEntity(BookDto bookDto);
}
