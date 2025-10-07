package restapiprojects.librarymanagementsystem.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import restapiprojects.librarymanagementsystem.DTO.AuthorDto;
import restapiprojects.librarymanagementsystem.Exception.AuthorNotFoundException;
import restapiprojects.librarymanagementsystem.Mapper.AuthorMapper;
import restapiprojects.librarymanagementsystem.Model.Author;
import restapiprojects.librarymanagementsystem.Repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;


    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream().map(authorMapper::toDto).toList();
    }

    @Override
    public AuthorDto getAuthorById(int id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        return authorMapper.toDto(author);
    }

    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.save(author);
        return authorMapper.toDto(author);
    }

    @Override
    public AuthorDto updateAuthor(int id, AuthorDto authorDto) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        author.setName(authorDto.getName());
        author.setNationality(authorDto.getNationality());
        author.setDateOfBirth(authorDto.getDateOfBirth());

        authorRepository.save(author);
        return authorMapper.toDto(author);
    }

    @Override
    public void deleteAuthor(int id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        authorRepository.delete(author);
    }

    @Override
    public Optional<AuthorDto> findByName(String name) {
        return authorRepository.findByName(name).map(authorMapper::toDto);
    }

    @Override
    public List<AuthorDto> findByNationality(String nationality) {
        return authorRepository.findByNationality(nationality).stream().map(authorMapper::toDto).toList();
    }
}
