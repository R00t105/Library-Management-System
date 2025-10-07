package restapiprojects.librarymanagementsystem.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restapiprojects.librarymanagementsystem.DTO.BookDto;
import restapiprojects.librarymanagementsystem.Service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto) {
        return ResponseEntity.status(201).body(bookService.addBook(bookDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable int id, @Valid @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

    @GetMapping("/search/by-title")
    public ResponseEntity<BookDto> getByTitle(@RequestParam String title) {
        return bookService.searchByTitle(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/by-author")
    public ResponseEntity<List<BookDto>> getByAuthor(@RequestParam Integer authorId) {
        return ResponseEntity.ok(bookService.searchByAuthorId(authorId));
    }

    @GetMapping("/search/by-title-include")
    public ResponseEntity<List<BookDto>> getByTitleInclude(@RequestParam String keyword) {
        return ResponseEntity.ok(bookService.searchByTitleIgnoreCase(keyword));
    }

}
