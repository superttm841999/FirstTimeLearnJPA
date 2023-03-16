package com.microlink.firstTime.resources;

import com.microlink.firstTime.domain.Author;
import com.microlink.firstTime.domain.Book;
import com.microlink.firstTime.exception.ResourceNotFoundException;
import com.microlink.firstTime.repository.BookRepository;
import com.microlink.firstTime.services.AuthorService;
import com.microlink.firstTime.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookResource {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }


    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) throws ResourceNotFoundException {
//        Long id = book.getAuthor().getId();
//        Author author = authorService.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id :: " + id));
//        if(authorService.findById(id).isEmpty()){
//            return ResponseEntity.noContent().build();
//        }

        Book createBook = bookService.save(book);
        return ResponseEntity.ok(createBook);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateAuthor(@PathVariable(value = "id") Long id,
                                               @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id: " + id));

        book.setTitle(bookDetails.getTitle());

        final Book updateAuthor = bookService.save(book);
        return ResponseEntity.ok(updateAuthor);
    }

    @DeleteMapping("/delete-book/{id}")
    public Map< String, Boolean > deleteBook(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id: " + id));

        bookService.delete(book);
        Map <String, Boolean> response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
