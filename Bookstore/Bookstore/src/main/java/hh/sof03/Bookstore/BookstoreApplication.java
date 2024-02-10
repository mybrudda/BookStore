package hh.sof03.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
public CommandLineRunner demo(BookRepository repository) {
    return (args) -> {
        // Your code...add some demo data to db
        Book a = new Book("Harry Potter", "JK Rowling", 2001, "AGD53B", 23.56);
        Book b = new Book("Legend of Ahmed", "Bilal Kahmi", 1967, "NDS836", 34.90);
        Book c = new Book("Games People Play", "Robert Kazumi", 2010, "BKF49U", 50.99);
    
        log.info("save a couple of books");
        repository.save(a);
        repository.save(b);
        repository.save(c);
    
        log.info("fetch all books");
        for(Book book: repository.findAll()){
            log.info(book.toString());
        }
    };
}

	}
