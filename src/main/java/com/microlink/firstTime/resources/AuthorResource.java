package com.microlink.firstTime.resources;

import com.microlink.firstTime.domain.Author;
import com.microlink.firstTime.domain.Book;
import com.microlink.firstTime.exception.ResourceNotFoundException;
import com.microlink.firstTime.repository.AuthorRepository;
import com.microlink.firstTime.repository.BookRepository;
import com.microlink.firstTime.services.AuthorBookService;
import com.microlink.firstTime.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class AuthorResource {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @PutMapping("/author/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long id,
                                                 @RequestBody Author authorDetails) throws ResourceNotFoundException {
        Author author = authorService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id: " + id));

        author.setFirstName(authorDetails.getFirstName());
        author.setLastName(authorDetails.getLastName());

        final Author updateAuthor = authorService.update(author);
        return ResponseEntity.ok(updateAuthor);
    }

    @DeleteMapping("/delete-author/{id}")
    public Map< String, Boolean > deleteAuthor(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Author author = authorService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id: " + id));

        authorService.delete(author);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
