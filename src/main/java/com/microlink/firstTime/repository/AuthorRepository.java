package com.microlink.firstTime.repository;

import com.microlink.firstTime.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface AuthorRepository extends JpaRepository<Author, Long> {

}
