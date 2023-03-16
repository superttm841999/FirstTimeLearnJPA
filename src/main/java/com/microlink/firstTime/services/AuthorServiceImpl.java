package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.Author;
import com.microlink.firstTime.domain.Book;
import com.microlink.firstTime.repository.AuthorRepository;
import com.microlink.firstTime.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        List<Author> author = getAllAuthor();
        List<Book> book = getAllBook();

        for(int i=0; i<author.toArray().length;i++){
            //bookArr.removeAll(bookArr);
            for(int a=0; a<book.toArray().length;a++){
                if(author.get(i).getId()== book.get(a).getAuthor().getId()){
                    author.get(i).setBooks(getAllBookByAuthorId(author.get(i).getId()));
                }
            }
        }
        return author;
    }

    private Set<Book> getAllBookByAuthorId(Long id){
        return bookRepository.findAllByAuthorId(id);
    }

    private List<Book> getAllBook(){
        return bookRepository.findAll();
    }
    private List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }
}
