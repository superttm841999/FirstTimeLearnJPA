package com.microlink.firstTime.repository;

import com.microlink.firstTime.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    Set<Book> findAllByAuthorId(Long authorId);
}
