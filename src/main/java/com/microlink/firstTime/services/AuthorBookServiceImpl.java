package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.Author;
import com.microlink.firstTime.domain.Book;
import com.microlink.firstTime.repository.AuthorRepository;
import com.microlink.firstTime.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookServiceImpl implements AuthorBookService{
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Author> findAllByAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public List<Book> findAllByBook() {
        return bookRepository.findAll();
    }
}
