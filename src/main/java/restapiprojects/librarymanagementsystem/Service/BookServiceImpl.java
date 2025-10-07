package restapiprojects.librarymanagementsystem.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restapiprojects.librarymanagementsystem.DTO.BookDto;
import restapiprojects.librarymanagementsystem.Exception.AuthorNotFoundException;
import restapiprojects.librarymanagementsystem.Exception.BookNotFoundException;
import restapiprojects.librarymanagementsystem.Mapper.BookMapper;
import restapiprojects.librarymanagementsystem.Model.Author;
import restapiprojects.librarymanagementsystem.Model.Book;
import restapiprojects.librarymanagementsystem.Repository.AuthorRepository;
import restapiprojects.librarymanagementsystem.Repository.BookRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;


//    private BookDto bookMapper.toDto(Book book) {
//        return new BookDto(book.getTitle(), book.getAuthor().getId(), book.getAuthor().getName());
//    }
//
//    private Book bookMapper.toEntity(BookDto bookDto) {
//        Author author = authorRepository.getReferenceById(bookDto.getAuthorId());
//        Book book = new Book();
//        book.setTitle(bookDto.getTitle());
//        book.setAuthor(author);
//        return book;
//    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }

    @Override
    public BookDto getBookById(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public BookDto updateBook(int id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setTitle(bookDto.getTitle());
        if (bookDto.getAuthorId() != 0) {
            Author author = authorRepository.getReferenceById(bookDto.getAuthorId());
            book.setAuthor(author);
        }

        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.delete(book);
    }

    @Override
    public Optional<BookDto> searchByTitle(String title) {
        return bookRepository.findByTitle(title).map(bookMapper::toDto);
    }

    @Override
    public List<BookDto> searchByAuthorId(Integer authorId) {
        return bookRepository.findByAuthorId(authorId).stream().map(bookMapper::toDto).toList();
    }

    @Override
    public List<BookDto> searchByTitleIgnoreCase(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword).stream().map(bookMapper::toDto).toList();
    }
}
