package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    Book save(Book book);
    Book update(Book book);
    void delete(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
}
