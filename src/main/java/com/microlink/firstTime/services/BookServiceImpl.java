package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.Author;
import com.microlink.firstTime.domain.Book;
import com.microlink.firstTime.repository.AuthorRepository;
import com.microlink.firstTime.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book save(Book book) {
        //Optional<Author> au = authorRepository.findById(book.getAuthorId());
        //Author author = new Author(au.get().getFirstName(), au.get().getLastName());
        //book.setAuthor(author);
        authorRepository.save(book.getAuthor());
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
