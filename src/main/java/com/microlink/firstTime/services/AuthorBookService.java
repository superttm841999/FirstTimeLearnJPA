package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.Author;
import com.microlink.firstTime.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorBookService {
    List<Author> findAllByAuthor();
    List<Book> findAllByBook();
}
