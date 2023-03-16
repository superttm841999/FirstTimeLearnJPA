package com.microlink.firstTime;

import com.microlink.firstTime.domain.Author;
import com.microlink.firstTime.domain.Book;
import com.microlink.firstTime.repository.AuthorRepository;
import com.microlink.firstTime.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstTimeApplication {
	private final BookRepository bookRepository;

	public FirstTimeApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstTimeApplication.class, args);
		System.out.println("hello world");
	}

	@Bean
	CommandLineRunner commandLineRunner(AuthorRepository authorRepository){
		System.out.println("gg world");
		return args -> {
//			Author author1 = new Author("Tai","Ming");
//			Author author2 = new Author("TTT","111");
//			Author author3 = new Author("AAA","222");
//			authorRepository.save(author1);
//			authorRepository.save(author2);
//			authorRepository.save(author3);
//
//			Book book1 = new Book("Book1",1L);
//			Book book2 = new Book("Book2",2L);
//			Book book3 = new Book("Book3",3L);
//
//			bookRepository.save(book1);
//			bookRepository.save(book2);
//			bookRepository.save(book3);

		};
	}


}
