package hh.sof03.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;
import hh.sof03.Bookstore.domain.Category;
import hh.sof03.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
public CommandLineRunner demo(BookRepository repository, CategoryRepository cRepository) {
    return (args) -> {
        
        


        Category first =  new Category("Fiction");
        Category second = new Category("Fantasy");


        log.info("save a couple categories");
        cRepository.save(first);
        cRepository.save(second);

    
        Book a = new Book("Harry Potter", "JK Rowling", 2001, "AGD53B", 23.56, cRepository.findByName("Fiction").get(0));
        Book b = new Book("Legend of Ahmed", "Bilal Kahmi", 1967, "NDS836", 34.90, cRepository.findByName("Fantasy").get(0));

    
        log.info("save a couple of books");
        repository.save(a);
        repository.save(b);
        
    };
}

	}
