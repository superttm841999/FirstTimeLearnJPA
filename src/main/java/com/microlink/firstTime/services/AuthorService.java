package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {

    Author save(Author author);

    Author update(Author author);
    void delete(Author author);

    Optional<Author> findById(Long id);

    List<Author> findAll();


}
